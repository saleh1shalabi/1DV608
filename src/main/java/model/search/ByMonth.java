package model.search;

import java.util.ArrayList;
import model.domain.Member;

/**
* Search by a month given.
*/
public class ByMonth implements Search {

  private ArrayList<Member> found = new ArrayList<>();

  @Override
  public ArrayList<Member> find(Iterable<Member>  members, String string) {
    int old = Integer.parseInt(string);
    int month;
    for (Member mem : members) {
      month = mem.getMonth();
      if (month == old) {
        found.add(mem);
      }
    }
    ArrayList<Member> founded = new ArrayList<>(found);
    clearList();
    return founded;
  }

  @Override
  public void clearList() {
    found.clear();
  }

  
  
}
