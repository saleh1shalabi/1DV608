package model.presistence;

import java.util.HashMap;
import java.util.Map;

/**
* class that adds the first members when app is started.
*/
public class HardCodeImplemets implements PersistenceInterface {

  private String[] STRINGS = {"Saleh Shalabi", "Hanna Sjöberg", "Gustav Vasa", "Monkey D. Luffy"};
  private String[] names = STRINGS;
  private int[] personalIds = {199903330, 19950308, 14960512, 19800505};
  
  Map<String, Integer> boatsSaleh = new HashMap<>();
  Map<String, Integer> boatsHanna = new HashMap<>();
  Map<String, Integer> boatsVasa = new HashMap<>();
  Map<String, Integer> boatsLuffy = new HashMap<>();


  /**
  * it will add boats when an object is made.
  */
  public HardCodeImplemets() {
    boatsSaleh.put("Sailboat", 25);
    boatsSaleh.put("Motorsailer", 40);
    boatsHanna.put("Kayak", 10);
    boatsLuffy.put("Sailboat", 13);
    boatsLuffy.put("Motorsailer", 39);
    boatsVasa.put("Sailboat", 69);
  }
  
  
  /**
  * returns boats for first member.
  */
  public Map<String, Integer> getmem1Boats() {
    return boatsSaleh;
  }

  /**
  * returns boats for second member.
  */
  public Map<String, Integer> getmem2Boats() {
    return boatsHanna;
  }

  /**
  * returns boats for 3ed member.
  */
  public Map<String, Integer> getmem3Boats() {
    return boatsVasa;
  }
  
  /**
  * returns boats for 4th member.
  */
  public Map<String, Integer> getmem4Boats() {
    return boatsLuffy;
  }
  
  /**
  * returns the names array.
  */
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
}
