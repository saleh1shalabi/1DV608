package model.search;

import java.util.ArrayList;
import model.domain.Member;

/**
* Search by a name given.
*/
public class ByName implements Search {
  private ArrayList<Member> found = new ArrayList<>();

  
  @Override
  public ArrayList<Member> find(Iterable<Member>  members, String name) {
    for (Member mem : members) {
      if (mem.getName().equals(name)) {
        found.add(mem);
      } else if (mem.getName().contains(name)) {
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
