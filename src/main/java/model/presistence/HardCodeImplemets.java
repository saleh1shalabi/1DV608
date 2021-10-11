package model.presistence;

import java.util.ArrayList;
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
  private String[] memberIds ={"A23FG5", "F55THJ", "WQ4YPO", "GGW14Y"};
  private PersistenceInterface file = new FileLoader();

  /**
  * it will add boats when an object is made.
  */
  public HardCodeImplemets() {
    file.getNames();
  }
  
  /**
  * returns the names array.
  */
  @Override
  public String[] getNames() {
    String[] nameToRet = names;
    return nameToRet;
  }

  /**
  * returns persId array.
  */
  public int[] getPersonalIds() {
    int[] perToRet = personalIds;
    return perToRet;
  }


  @Override
  public Map<String, ArrayList<Boat>> getBoats() {
    Map<String, ArrayList<Boat>> toRet = new HashMap<>();
    ArrayList<Boat> boatSaleh = new ArrayList<>();
    ArrayList<Boat> boatHanna = new ArrayList<>();
    ArrayList<Boat> boatLuffy = new ArrayList<>();
    ArrayList<Boat> boatVasa = new ArrayList<>();

    boatSaleh.add(new Boat("SailBoat", 45));
    boatSaleh.add(new Boat("Kayak", 10));
    boatHanna.add(new Boat("Motorsailer", 35));
    boatLuffy.add(new Boat("SailBoat", 19));
    boatLuffy.add(new Boat("Motorsailer", 39));
    boatVasa.add(new Boat("Sailboat", 69));

    
    toRet.put("A23FG5", boatSaleh);
    toRet.put("F55THJ", boatHanna);
    toRet.put("WQ4YPO", boatVasa);
    toRet.put("GGW14Y", boatLuffy);

    return toRet;
  }


  @Override
  public String[] getMemberIds() {
    String[] memIdsToRet = memberIds;
    return memIdsToRet;
  }

  @Override
  public void saveBoats(ArrayList<Member> members) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void saveMembers(ArrayList<Member> members) {
    // TODO Auto-generated method stub
    
  }


}
