package model.presistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;


import model.domain.Boat;
import model.domain.Member;

public class DBLoade implements PersistenceInterface {
  
  private final String user = "root";
  private final String db = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
  private final String url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
  private final String pass = "root";
  private Connection con;


  public DBLoade() {
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

  private void createDb() {
    String sql = "Create database test";
    try(Connection conn = con = DriverManager.getConnection(url, user, pass)) {
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
    }
  }

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
    }
  }

  public Connection connect() throws SQLException {
    con = DriverManager.getConnection(db, user, pass);
    return con;
  }

  

  @Override
  public String[] getNames() {
    readNames();
    return null;
  }

  private void readNames() {
    String sql;
    try (Connection conn = connect()) {
      Statement stmt = conn.createStatement();
      sql = "select name from members";

      ResultSet res = stmt.executeQuery(sql);
      
      

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int[] getPersonalIds() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getMemberIds() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Map<String, ArrayList<Boat>> getBoats() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveBoats(Iterable<Member> members) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void saveMembers(Iterable<Member> members) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void saveUsers(Map<String, String> users) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Map<String, String> getUsers() {
    // TODO Auto-generated method stub
    return null;
  }


}