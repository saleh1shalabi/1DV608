package model.domain;

import java.util.ArrayList;

/**
* Responsible for staring the application.
*/
public class MemberManager {

  private ArrayList<model.domain.Member> members = new ArrayList<>();

  /**
  * Responsible for staring the application.
  */
  public void addMember(Member member) {
    members.add(member);
  }

  public void removeMember(Member member) {
    members.remove(member);
  }

  /**
  * Responsible for staring the application.
  */
  public  ArrayList<Member> getMembers() {
    return members;
  }

  /**
  * Responsible for staring the application.
  */
  public StringBuilder randomId() {

    String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int count = 6;
    StringBuilder memberId = new StringBuilder();
    while (count-- != 0) {
      int character = (int) (Math.random() * alphanumeric.length());
      memberId.append(alphanumeric.charAt(character));
    }  
    for (Member mem : members) {
      if (mem.getMemberId().equals(memberId.toString())) {
        memberId = randomId();
      }
    } 
    return memberId;
  }
}


