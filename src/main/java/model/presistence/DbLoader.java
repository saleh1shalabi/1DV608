package model.presistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import model.domain.Boat;
import model.domain.Member;

/**
* to add data from files.
*/
public class DbLoader implements PersistenceInterface {


  private DbMaker dbMaker = new DbMaker();
  private String[] names = {};
  private int[] personalIds = {};
  private String[] memberIds = {};
  private Map<String, String> users = new HashMap<>();
  private Map<String, ArrayList<Boat>> membersBoats = new HashMap<>();

  /**
  * connects to tje DB.
  * if the DB is not Found it will create
  * the DB and insert the Data from the files.
  */
  public DbLoader() {
    try {
      dbMaker.connect();
    }  catch (SQLException e) {
      if (e.toString().equals("java.sql.SQLSyntaxErrorException: Unknown database 'boatclub'")) {
        dbMaker.createDb();
      } else {
        e.printStackTrace();
      } 
    } 
  }

  @Override
  public String[] getNames() {
    readMembers();
    String[] namesToRet = Arrays.copyOf(names, names.length);
    return namesToRet;
  }

  /**
  * reads the members from Db.
  */
  private void readMembers() {
    String sql;
    try (Connection conn = dbMaker.connect()) {
      Statement stmt = conn.createStatement();
      sql = "select * from members";

      
      ResultSet res = stmt.executeQuery(sql);
      String name;
      int personalId;
      String memberId;
      while (res.next()) {
        name = res.getString("name");
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = name;
    
        personalId = Integer.parseInt(res.getString("personalId"));
        personalIds = Arrays.copyOf(personalIds, personalIds.length + 1);
        personalIds[personalIds.length - 1] = personalId;

        memberId = res.getString("memberId");
        membersBoats.put(memberId, new ArrayList<Boat>());
        memberIds = Arrays.copyOf(memberIds, memberIds.length + 1);
        memberIds[memberIds.length - 1] = memberId;
      }
      res.close();
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int[] getPersonalIds() {
    int[] perToRet = Arrays.copyOf(personalIds, personalIds.length);
    return perToRet;
  }

  @Override
  public String[] getMemberIds() {
    String[] memIdToRet = Arrays.copyOf(memberIds, memberIds.length);
    return memIdToRet;
  }


  @Override
  public Map<String, ArrayList<Boat>> getBoats() {
    readBoats();
    Map<String, ArrayList<Boat>> toRet =  new HashMap<>(membersBoats);
    return toRet;
  }

  /**
  * reads the boats from DB.
  */
  private void readBoats() {
    String sql;
    try (Connection conn = dbMaker.connect()) {
      Statement stmt = conn.createStatement();
      sql = "select * from boats";

      ResultSet res = stmt.executeQuery(sql);
      String memberId;
      String boatType;
      int length;

      while (res.next()) {
        memberId = res.getString("memberId");
        boatType = res.getString("boatType");
        length = Integer.parseInt(res.getString("length"));
        membersBoats.get(memberId).add(new Boat(boatType, length));
      }
      res.close();
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
  * saves boats into db.
  */
  @Override
  public void saveBoats(Iterable<Member> members) {
    try (Connection conn = dbMaker.connect()) {
  
      String sql = "Delete from boats";
      PreparedStatement stmt = conn.prepareStatement(sql);

      stmt.execute(sql);
      String memId;
      for (Member mem : members) {
        memId = mem.getMemberId();
        ArrayList<Boat> boats = mem.getBoats();
        for (Boat boat : boats) {
          sql = "insert into boats values('" + memId + "', '" + boat.getType() + "', " + boat.getLength() + ")";
          stmt.execute(sql);
        } 
      }
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
  * saves members to db.
  */
  @Override
  public void saveMembers(Iterable<Member> members) {
    try (Connection conn = dbMaker.connect()) {
      String sql = "Delete from members";
      PreparedStatement stmt = conn.prepareStatement(sql);

      stmt.execute(sql);
      String memId;
      String name;
      int personalId;
      
      for (Member mem : members) {
        memId = mem.getMemberId();
        name = mem.getName();
        personalId = mem.getPersonalId();
        sql = "insert into members values('" + memId + "', '" + name + "', " + personalId + ")"; 
        stmt.execute(sql);
      } 
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
  * saves users to db.
  */
  @Override
  public void saveUsers(Map<String, String> users) {
    try (Connection conn = dbMaker.connect()) {
      String sql = "Delete from users";
      PreparedStatement stmt = conn.prepareStatement(sql);

      stmt.execute(sql);
      for (Map.Entry<String, String> user : users.entrySet()) {
        sql = "insert into users values('" + user.getKey() + "', '" + user.getValue() + "')";
        stmt.execute(sql);
      }
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Map<String, String> getUsers() {
    readUsers();
    Map<String, String> us = new HashMap<>(users);
    return us;
  }

  /**
  * reads the users from db.
  */
  private void readUsers() {
    String sql;
    try (Connection conn = dbMaker.connect()) {
      Statement stmt = conn.createStatement();
      sql = "select * from users";

      ResultSet res = stmt.executeQuery(sql);
      String username;
      String pass;

      while (res.next()) {
        username = res.getString("username");
        pass = res.getString("password");
        users.put(username, pass);
      }
      res.close();
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

}