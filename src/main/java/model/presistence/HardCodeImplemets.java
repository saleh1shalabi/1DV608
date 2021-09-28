package model.presistence;

import java.util.HashMap;
import java.util.Map;

/**
* Responsible for staring the application.
*/
public class HardCodeImplemets {

  String[] names = {"Saleh", "Hanna", "Gustav Vasa", "Monkey D. Luffy"};
  int[] personalIds = {123, 321, 567, 9876};
  
  Map<String, Integer> boatsSaleh = new HashMap<>();
  Map<String, Integer> boatsHanna = new HashMap<>();
  Map<String, Integer> boatsVasa = new HashMap<>();
  Map<String, Integer> boatsLuffy = new HashMap<>();


  /**
  * Responsible for staring the application.
  */
  public HardCodeImplemets() {
    boatsSaleh.put("Sailboat", 25);
    boatsSaleh.put("Motorsailer", 40);
    boatsHanna.put("Kayak", 10);
    boatsLuffy.put("Marry GO", 13);
    boatsLuffy.put("Thousand Sunny ", 39);
    boatsVasa.put("Regalskeppet Vasa", 69);
    

  }
  
  /**
  * Responsible for staring the application.
  */
  public Map<String, Integer> getmem1Boats() {
    return boatsSaleh;
  }

  /**
  * Responsible for staring the application.
  */
  public Map<String, Integer> getmem2Boats() {
    return boatsHanna;
  }

  /**
  * Responsible for staring the application.
  */
  public Map<String, Integer> getmem3Boats() {
    return boatsVasa;
  }
  
  /**
  * Responsible for staring the application.
  */
  public Map<String, Integer> getmem4Boats() {
    return boatsLuffy;
  }
  
  /**
  * Responsible for staring the application.
  */
  public String[] getNames() {
    String[] nameToRet = names;
    return nameToRet;
  }

  /**
  * Responsible for staring the application.
  */
  public int[] getPersonalIds() {
    int[] perToRet = personalIds;
    return perToRet;
  }
}
