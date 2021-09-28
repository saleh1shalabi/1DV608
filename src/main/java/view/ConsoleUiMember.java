package view;

import java.util.ArrayList;
import model.domain.Boat;

/**
* Responsible for staring the application.
*/
public class ConsoleUiMember {
 
  private Getter get = new Getter();

  /**
  * Responsible for staring the application.
  */
  public String nameGetter() {
    System.out.println("Enter The new Member name: ");
    String name = get.stringGetter();
    return name;
  }

  /**
  * Responsible for staring the application.
  */
  public Integer personalIdGetter() {
    System.out.println("Enter the members personal number: ");
    Integer pers = get.intGetter();
    return pers;
  }

  /**
  * Responsible for staring the application.
  */
  public void showSpecMemberInfo() {
    // Här ska ett objekt av en medlem skickas in och sedan ska metoder som getName osv anropas härifrån
    System.out.println("");
  }
  
  /**
  * Responsible for staring the application.
  */
  public void showVerboseList(ArrayList<model.domain.Member> members) {
    System.out.println("------VERBOSE LIST------");
    for (model.domain.Member memm : members) {
      System.out.println("=============");
      System.out.println("\n");
      System.out.println("Name: " + memm.getName());
      System.out.println("Personal number: " + memm.personalId());
      System.out.println("Member id: " + memm.getMemberId());
      System.out.println("\n");
      System.out.println("Boats:");
      for (Boat boat : memm.getBoats()) {
        System.out.println("Type: " + boat.getType() + " || Length: " + boat.getLength());
      }
    }
  }
  
  /**
  * Responsible for staring the application.
  */
  public void showCompactList(ArrayList<model.domain.Member> members) {
    System.out.println("-----COMPACT LIST------");
    for (model.domain.Member memm : members) {
      System.out.println("Name: " + memm.getName());
      System.out.println("Member id: " + memm.getMemberId());
      System.out.println("Number of boats: " + memm.ownedBoats());
    }
  }


}