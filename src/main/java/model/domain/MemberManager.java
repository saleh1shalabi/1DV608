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
  public void addMemberToCatalog(Member member) {
    members.add(member);
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
  public String randomId() {

    String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int count = 6;
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
      int character = (int) (Math.random() * alphanumeric.length());
      builder.append(alphanumeric.charAt(character));
    }  
    for (Member mem : members) {
      if (mem.getMemberId().equals(builder.toString())) {
        randomId();
      }
    } 
    return builder.toString();
  }
}


