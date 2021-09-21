package model;

import java.util.ArrayList;


/**
 * Responsible for staring the application.
 */
public class Member {
    
  private String name;
  private String personalId;
  private int memberId;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
  * Responsible for staring the application.
  */
  Member(String name, String personalId, int memberId) {
    this.name = name;
    this.personalId = personalId;
    this.memberId = memberId;
  }
  
  /**
  * Responsible for staring the application.
  */
  private String getName(){
    return name;
  }

  private String personalId(){
    return personalId;
  }

  private int memberId(){
    return memberId;
  }

  private ArrayList<Boat> getBoats() {
    return new ArrayList<Boat>(boats);
  }


  private void newBoat(double length) {
    boats.add(new Boat(length));
  }


  private int getNumOwnedBoats() {
    return boats.size();
  }

  private void removeBoat(Boat boat) {
    boats.remove(boat);
  }

}
