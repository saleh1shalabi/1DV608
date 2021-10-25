package model.SearchStrategy;

import java.util.ArrayList;
import model.domain.Member;

public class ByYear implements Search {

  @Override
  public ArrayList<Member> find(ArrayList<Member> members, String string) {
    int old = Integer.parseInt(string);
    int year;
    for (Member mem : members) {
     year = mem.getYear();
     if (year == old) {
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
