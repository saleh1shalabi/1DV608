package model.presistence;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class DBLoader implements PersistenceInterface {
  
  private final String user = "root";
  private final String db = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
  private final String url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
  private final String pass = "root";
  private Connection con;


  private String[] names = {};
  private int[] personalIds = {};
  private String[] memberIds = {};
  private Map<String, String> users = new HashMap<>();
  private Map<String, ArrayList<Boat>> membersBoats = new HashMap<>();


  /**
  * to add data from files.
  */
  public DBLoader() {
    try {
      connect();
    }  catch (SQLException e) {
      if (e.toString().equals("java.sql.SQLSyntaxErrorException: Unknown database 'test'")) {
        createDb();
      } else {
      e.printStackTrace();
      } 
    } 
  }

  /**
  * to add data from files.
  */  
  private void createDb() {
    String sql = "Create database test";
    try(Connection conn = DriverManager.getConnection(url, user, pass)) {
      Statement stmt = conn.createStatement();
      stmt.execute(sql);
      sql = "use test";
      stmt.execute(sql);
      System.out.println("Created DB");
      addTables();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 

  } 

  /**
  * to add data from files.
  */  
  private void addTables() {
    String sql;    
    try(Connection conn = connect()) {
      Statement stmt = conn.createStatement();
      sql = "Create Table members " + 
                  "(memberId varchar(6) not null, " + 
                  "name varchar(50), " + 
                  "personalId integer, " + 
                  "primary key (memberId))";
      stmt.execute(sql);
      sql = "Create Table boats " +
                "(memberId varchar(6) not null, " +
                "boatType varchar(50), " +
                "length integer)";
      stmt.execute(sql);
      sql = "Create Table users " +
                "(username varchar(50), " +
                " password varchar(50))";
      stmt.execute(sql);
      System.out.println("table Created");
      insertData();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  private void insertData() {
    PersistenceInterface hc = new FileLoader();
    try (Connection conn = connect()) {
      String[] nm = hc.getNames();
      int[] persId = hc.getPersonalIds();
      String[] memIds = hc.getMemberIds();
      Statement stmt = conn.createStatement();
      String sql;    

      for (int c = 0; c < nm.length; c++) {
        sql = "insert into members values('" + memIds[c] + "', '" + nm[c] + "', " + persId[c] + ")"; 
        stmt.execute(sql);
      }

      Map<String, ArrayList<Boat>> bots = hc.getBoats();

      for (Map.Entry<String, ArrayList<Boat>> b : bots.entrySet()) {
        String memId = b.getKey();
        for (Boat boat : b.getValue()){
          sql = "insert into boats values('" + memId + "', '" + boat.getType() + "', " + boat.getLength() + ")" ;
          stmt.execute(sql);
        }
      }

      Map<String, String> users = hc.getUsers();

      for (Map.Entry<String, String> user : users.entrySet()) {
        sql = "insert into users values('" + user.getKey() + "', '" + user.getValue() + "')" ;
        stmt.execute(sql);
      } 

      System.out.println("inserted Data");
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  public Connection connect() throws SQLException {
    con = DriverManager.getConnection(db, user, pass);
    return con;
  }

  
  /**
  * to add data from files.
  */
  @Override
  public String[] getNames() {
    readMembers();
    String[] namesToRet = Arrays.copyOf(names, names.length);
    return namesToRet;
  }

  /**
  * to add data from files.
  */
  private void readMembers() {
    String sql;
    try (Connection conn = connect()) {
      Statement stmt = conn.createStatement();
      sql = "select * from members";

      
      ResultSet res = stmt.executeQuery(sql);
      String name;
      int personalId;
      String memberId;
      while(res.next()) {
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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  @Override
  public int[] getPersonalIds() {
    int[] perToRet = Arrays.copyOf(personalIds, personalIds.length);
    return perToRet;
  }

  /**
  * to add data from files.
  */
  @Override
  public String[] getMemberIds() {
    String[] memIdToRet = Arrays.copyOf(memberIds, memberIds.length);
    return memIdToRet;
  }

  /**
  * to add data from files.
  */
  @Override
  public Map<String, ArrayList<Boat>> getBoats() {
    readBoats();
    Map<String, ArrayList<Boat>> toRet =  new HashMap<>(membersBoats);
    return toRet;
  }

  /**
  * to add data from files.
  */  
  private void readBoats() {
    String sql;
    try (Connection conn = connect()) {
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
      

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  @Override
  public void saveBoats(Iterable<Member> members) {
    try (Connection conn = connect()) {

      Statement stmt = conn.createStatement();
      String sql = "Delete from boats";
      stmt.execute(sql);
      String memId;
      for (Member mem : members) {
        memId = mem.getMemberId();
        ArrayList<Boat> boats = mem.getBoats();
        for (Boat boat : boats){
          sql = "insert into boats values('" + memId + "', '" + boat.getType() + "', " + boat.getLength() + ")" ;
          stmt.execute(sql);
        } 
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  @Override
  public void saveMembers(Iterable<Member> members) {
    try (Connection conn = connect()) {

      Statement stmt = conn.createStatement();
      String sql = "Delete from members";
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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  @Override
  public void saveUsers(Map<String, String> users) {
    try (Connection conn = connect()) {

      Statement stmt = conn.createStatement();
      String sql = "Delete from users";
      stmt.execute(sql);
      for (Map.Entry<String, String> user : users.entrySet()) {
        sql = "insert into users values('" + user.getKey() + "', '" + user.getValue() + "')" ;
        stmt.execute(sql);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * to add data from files.
  */
  @Override
  public Map<String, String> getUsers() {
    readUsers();
    Map<String, String> us = new HashMap<>(users);
    return us;
  }

  /**
  * to add data from files.
  */
  private void readUsers() {
    String sql;
    try (Connection conn = connect()) {
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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

}