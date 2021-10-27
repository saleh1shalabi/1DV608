package model.presistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import model.domain.Boat;
import model.domain.Member;


/**
* class that adds the first members when app is started.
*/
public class HardCodeImplemets implements PersistenceInterface {

  private String[] names = {"Saleh Shalabi", "Hanna Sjöberg", "Gustav Vasa", "Monkey D. Luffy"};
  private int[] personalIds = {199903330, 19950308, 14960512, 19800505};
  private String[] memberIds = {"A23FG5", "F55THJ", "WQ4YPO", "GGW14Y"};
  
  /**
  * returns the names array.
  */
  @Override
  public String[] getNames() {
    String[] nameToRet = Arrays.copyOf(names, names.length);
    return nameToRet;
  }

  /**
  * returns persId array.
  */
  public int[] getPersonalIds() {
    int[] perToRet = Arrays.copyOf(personalIds, personalIds.length);
    return perToRet;
  }

  /**
  * makes boats for members hard coded.
  */
  @Override
  public Map<String, ArrayList<Boat>> getBoats() {
    
    ArrayList<Boat> boatSaleh = new ArrayList<>();
    boatSaleh.add(new Boat("SailBoat", 45));
    boatSaleh.add(new Boat("Kayak", 10));

    ArrayList<Boat> boatHanna = new ArrayList<>();
    boatHanna.add(new Boat("Motorsailer", 35));

    ArrayList<Boat> boatLuffy = new ArrayList<>();
    boatLuffy.add(new Boat("SailBoat", 19));
    boatLuffy.add(new Boat("Motorsailer", 39));

    ArrayList<Boat> boatVasa = new ArrayList<>();
    boatVasa.add(new Boat("Sailboat", 69));

    Map<String, ArrayList<Boat>> toRet = new HashMap<>();
    
    toRet.put("A23FG5", boatSaleh);
    toRet.put("F55THJ", boatHanna);
    toRet.put("WQ4YPO", boatVasa);
    toRet.put("GGW14Y", boatLuffy);

    return toRet;
  }


  @Override
  public String[] getMemberIds() {
    String[] memIdsToRet = Arrays.copyOf(memberIds, memberIds.length);
    return memIdsToRet;
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
    Map<String, String> users = new HashMap<>();
    users.put("admin", "admin");
    return users;
  }


}
