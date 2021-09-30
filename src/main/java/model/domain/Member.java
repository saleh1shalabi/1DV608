package model.domain;

import java.util.ArrayList;

/**
 * Responsible for staring the application.
 */
public class Member {
    
  private String name;
  private Integer personalId;
  private String memberId;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
  * Responsible for staring the application.
  */
  public Member(String name, Integer personalId, String memberId) {

    this.name = name;
    this.personalId = personalId;
    this.memberId = memberId;
  }
  
  public String getName() {
    return name;
  }

  public Integer personalId() {
    return personalId;
  }

  public String getMemberId() {
    return memberId;
  }

  public ArrayList<Boat> getBoats() {
    return boats;
  }

  public void addBoat(Boat boat) {
    boats.add(boat);
  }

  public void removeBoat(Boat boat) {
    boats.remove(boat);
  }

  public int ownedBoats() {
    return boats.size();
  }

}
