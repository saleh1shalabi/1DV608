package model.domain;

import java.util.ArrayList;
/**
* Responsible for managing members.
*/
public class MemberManager {

  private ArrayList<Member> members = new ArrayList<>();

  public void addMember(Member member) {
    members.add(member);
  }

  public void removeMember(Member member) {
    members.remove(member);
  }


  public  ArrayList<Member> getMembers() {
    return members;
  }

  /**
  * Responsible for generating uniq member ID .
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


