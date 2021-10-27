package model.presistence;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import model.domain.Boat;
import model.domain.Member;

/**
* the fileload class.
*/
public class FileLoader implements PersistenceInterface {
  
  private String pathToMembers = "./files/members.csv";
  private String pathToBoats = "./files/boats.csv";
  private String pathToUsers = "./files/users.csv";

  private String[] names = {};
  private int[] personalIds = {};
  private String[] memberIds = {};
  private Map<String, String> users = new HashMap<>();


  private Map<String, ArrayList<Boat>> membersBoats = new HashMap<>();


  /**
  * reads the members from file.
  */
  private void readMembers() {
    try (InputStream st = new FileInputStream(pathToMembers)) {
      Reader read = new InputStreamReader(st, StandardCharsets.UTF_8);
      BufferedReader nameReader = new BufferedReader(read);
      String[] line;
      String sline;
      String name;
      int personalId;
      String memberId;
      
      while ((sline = nameReader.readLine()) != null) {
        line = sline.split(",");
      
        name = line[0];
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = name;
    
        personalId = Integer.parseInt(line[1]);
        personalIds = Arrays.copyOf(personalIds, personalIds.length + 1);
        personalIds[personalIds.length - 1] = personalId;

        memberId = line[2];
        membersBoats.put(memberId, new ArrayList<Boat>());
        memberIds = Arrays.copyOf(memberIds, memberIds.length + 1);
        memberIds[memberIds.length - 1] = memberId;
      }
      nameReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }    
    
  }

  /**
  * reads the boats from file.
  */
  private void readBoats() {
    try (InputStream st = new FileInputStream(pathToBoats)) {
      Reader read = new InputStreamReader(st, StandardCharsets.UTF_8);
      BufferedReader nameReader = new BufferedReader(read);
      
      String sline;
      String memberId;
      String[] line;
      String boatType;
      int length;

      while ((sline = nameReader.readLine()) != null) {
        line = sline.split(",");
        memberId = line[0];
        boatType = line[1];
        length = Integer.parseInt(line[2]);
        membersBoats.get(memberId).add(new Boat(boatType, length));
        
      }
      nameReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 

  }

  @Override
  public String[] getNames() {
    readMembers();
    String[] namesToRet = Arrays.copyOf(names, names.length);
    return namesToRet;
  }


  @Override
  public int[] getPersonalIds() {
    int[] perToRet = Arrays.copyOf(personalIds, personalIds.length);
    return perToRet;
  }


  @Override
  public Map<String, ArrayList<Boat>> getBoats() {
    readBoats();
    Map<String, ArrayList<Boat>> toRet =  new HashMap<>(membersBoats);
    return toRet;
  }


  @Override
  public String[] getMemberIds() {
    String[] memIdToRet = Arrays.copyOf(memberIds, memberIds.length);
    return memIdToRet;
  }

  /**
  * saves the boats to file.
  */
  @Override
  public void saveBoats(Iterable<Member> members) {
    FileWriter boatWriter = null;
    try {
      boatWriter = new FileWriter(pathToBoats, StandardCharsets.UTF_8);
      String memberId;
      for (Member mem : members) {
        memberId = mem.getMemberId();
        ArrayList<Boat> boats = mem.getBoats();
        String toAppend;
        for (Boat boat : boats) {
          toAppend = memberId + "," + boat.getType() + "," + boat.getLength() + "\n";
          boatWriter.append(toAppend);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally { 
      // hole this block of code is becuse the check style and findBugs 
      if (boatWriter != null) {
        try {
          boatWriter.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          boatWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
  * saves the members to file.
  */
  @Override
  public void saveMembers(Iterable<Member> members) {
    FileWriter memberWriter = null;
    try {
      memberWriter = new FileWriter(pathToMembers, StandardCharsets.UTF_8);
      String toAppend;
      String name;
      int personalId;
      String memberId;
      for (Member mem : members) {
        name = mem.getName();
        personalId = mem.getPersonalId();
        memberId = mem.getMemberId();
        toAppend = name + "," + personalId + "," + memberId + "\n";
        memberWriter.append(toAppend);
        
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally { 
      // hole this block of code is becuse the check style and findBugs 
      if (memberWriter != null) {
        try {
          memberWriter.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          memberWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
  * gets the users from file.
  */
  public Map<String, String> getUsers() {
    readUsers();
    Map<String, String> us = new HashMap<>(users);
    return us;

  }

  /**
  * read the users from file.
  */
  private void readUsers() {
    try (InputStream st = new FileInputStream(pathToUsers)) {
      Reader read = new InputStreamReader(st, StandardCharsets.UTF_8);
      BufferedReader nameReader = new BufferedReader(read);
      String[] line;
      String sline;
      String username;
      String password;
      
      while ((sline = nameReader.readLine()) != null) {
        line = sline.split(",");
      
        username = line[0];    
        password = line[1];
        users.put(username, password);
      }
      nameReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  /**
  * saves the users to the file.
  */
  public void saveUsers(Map<String, String> users) {
    FileWriter userWriter = null;
    try {
      userWriter = new FileWriter(pathToUsers, StandardCharsets.UTF_8);
      String username;
      String password;

      for (Entry<String, String> user : users.entrySet()) {
        username = user.getKey();
        password = user.getValue();
        userWriter.append(username + "," + password + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally { 
      // this block of code is becuse the check style and findBugs 
      if (userWriter != null) {
        try {
          userWriter.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          userWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


}
