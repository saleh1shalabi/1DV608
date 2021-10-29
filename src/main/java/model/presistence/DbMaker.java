package model.presistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import model.domain.Boat;


/**
 * handles the connection and creation of DB.
 */
public class DbMaker {

  



  private String user;
  private String db = "jdbc:mysql://localhost:3306/boatclub?useUnicode=true&useJDBCCompliantTimezoneShift="
                              + "true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
  private String url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift="
                              + "true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
  private String pass;

  /**
  * bla bla.
  */
  public DbMaker() {
    Properties prop = new Properties();
    try (InputStream st = new FileInputStream("./files/data.properties")) {
      prop.load(st);
      this.user = prop.getProperty("username");
      this.pass = prop.getProperty("password");
      st.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }


  /**
  * connect to DB.
  */
  public Connection connect() throws SQLException {
    return  DriverManager.getConnection(db, user, pass);
  }

  /**
  * Creates Db.
  */  
  void createDb() {
    String sql = "Create database boatclub";
    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.execute(sql);
      sql = "use boatclub";
      stmt.execute(sql);
      System.out.println("Created DB");
      addTables();
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 

  } 

  /**
  * adds tables to Db when created.
  */  
  private void addTables() {
       
    try (Connection conn = connect()) {
      String sql = "Create Table members "
                  + "(memberId varchar(6) not null, "
                  + "name varchar(50), "
                  + "personalId integer, " 
                  + "primary key (memberId))";
      
      PreparedStatement stmt = conn.prepareStatement(sql);
      
      stmt.execute(sql);
      sql = "Create Table boats "
                + "(memberId varchar(6) not null, "
                + "boatType varchar(50), " 
                + "length integer)";
      stmt.execute(sql);
      sql = "Create Table users "
                + "(username varchar(50), "
                + " password varchar(50))";
      stmt.execute(sql);
      System.out.println("table Created");
      insertData();
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (connect() != null) {
          connect().close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }

  /**
  * inserts the data from files.
  */
  private void insertData() {
    PersistenceInterface hc = new FileLoader();
    try (Connection conn = connect()) {
      String[] nm = hc.getNames();
      int[] persId = hc.getPersonalIds();
      String[] memIds = hc.getMemberIds();
      
      String sql = "use boatclub";
      PreparedStatement stmt = conn.prepareStatement(sql);  
      
      for (int c = 0; c < nm.length; c++) {
        sql = "insert into members values('" + memIds[c] + "', '" + nm[c] + "', " + persId[c] + ")"; 
        stmt.execute(sql);
      }

      Map<String, ArrayList<Boat>> bots = hc.getBoats();

      for (Map.Entry<String, ArrayList<Boat>> b : bots.entrySet()) {
        String memId = b.getKey();
        for (Boat boat : b.getValue()) {
          sql = "insert into boats values('" + memId + "', '" + boat.getType() + "', " + boat.getLength() + ")";
          stmt.execute(sql);
        }
      }

      Map<String, String> users = hc.getUsers();

      for (Map.Entry<String, String> user : users.entrySet()) {
        sql = "insert into users values('" + user.getKey() + "', '" + user.getValue() + "')";
        stmt.execute(sql);
      } 

      System.out.println("inserted Data");
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (connect() != null) {
          connect().close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
