package model.domain;

import java.util.ArrayList;

public class MemberManager {

  private ArrayList<model.domain.Member> members = new ArrayList<>();
  
  public void addMemberToCatalog(Member member){
    members.add(member);
  }

  public  ArrayList<Member> getMembers() {
    return members;
  }

  public String randomId(){

    String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int count = 6;
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
      int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }  
    for (Member mem : members) {
      if(mem.getMemberId() == builder.toString()) {
        randomId();
      }
    } 
    return builder.toString();
  }
}


