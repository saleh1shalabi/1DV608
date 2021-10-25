package model.SearchStrategy;

import java.util.ArrayList;

import model.domain.Member;

public class ByMonth implements Search {

  @Override
  public ArrayList<Member> find(ArrayList<Member> members, String string) {
    int old = Integer.parseInt(string);
    int month;
    for (Member mem : members) {
      month = mem.getMonth();
     if (month == old) {
       found.add(mem);
     }
    }
    return found;
  }

  @Override
  public void clearList() {
    found.clear();
  }

  
  
}
