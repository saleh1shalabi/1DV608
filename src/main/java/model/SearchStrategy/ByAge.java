package model.SearchStrategy;

import java.util.ArrayList;

import model.domain.Member;

public class ByAge implements Search {

  @Override
  public ArrayList<Member> find(ArrayList<Member> members, String string) {
    int old = Integer.parseInt(string);
    int memAge;
    for (Member mem : members) {
     memAge = 2021 - mem.getYear();
     if (memAge == old) {
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
