package model.presistence;

import java.util.HashMap;
import java.util.Map;

public class HardCodeImplemets {

  String[] names = {"Saleh", "Hanna", "Gustav Vasa", "Monkey D. Luffy"};
  int[] personalIds = {123, 321, 567, 9876};
  
  Map<String, Integer> boatsSaleh = new HashMap<>();
  Map<String, Integer> boatsHanna = new HashMap<>();
  Map<String, Integer> boatsVasa = new HashMap<>();
  Map<String, Integer> boatsLuffy = new HashMap<>();


  
  public HardCodeImplemets() {
    boatsSaleh.put("Sailboat", 25);
    boatsSaleh.put("Motorsailer", 40);
    boatsHanna.put("Kayak", 10);
    boatsLuffy.put("Marry GO", 13);
    boatsLuffy.put("Thousand Sunny ", 39);
    boatsVasa.put("Regalskeppet Vasa", 69);
    

  }

  public Map<String, Integer> getmem1Boats() {
    return boatsSaleh;
  }

  public Map<String, Integer> getmem2Boats() {
    return boatsHanna;
  }
  public Map<String, Integer> getmem3Boats() {
    return boatsVasa;
  }
  public Map<String, Integer> getmem4Boats() {
    return boatsLuffy;
  }
  
  public String[] getNames() {
    return names;
  }

  public int[] getPersonalIds() {
    return personalIds;
  }
}
