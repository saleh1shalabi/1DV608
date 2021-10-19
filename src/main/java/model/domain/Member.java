package model.domain;

import java.util.ArrayList;

/**
* member class.
*/
public class Member {
    
  private String name;
  private Integer personalId;
  private String memberId;
  private int year;
  private int month;
  private int day;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
  * creating new member object.
  */
  public Member(String name, Integer personalId, String memberId) {
    this.name = name;
    this.personalId = personalId;
    String s = String.valueOf(personalId);
    this.year = Integer.parseInt(s.substring(0, 4));
    this.month = Integer.parseInt(s.substring(5, 6));
    this.day = Integer.parseInt(s.substring(7, 8));
    this.memberId = memberId;
  }

  public int getYear() {
    return year;
  }
  
  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPersonalId() {
    return personalId;
  }

  public void setPersonalId(int personalId) {
    this.personalId = personalId;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
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
