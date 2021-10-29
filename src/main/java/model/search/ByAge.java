package model.search;

import java.util.ArrayList;
import model.domain.Member;

/**
* Search by a age given.
*/
public class ByAge implements Search {
  private ArrayList<Member> found = new ArrayList<>();

  @Override
  public ArrayList<Member> find(Iterable<Member>  members, String string) {
    int old = Integer.parseInt(string);
    int memAge;
    for (Member mem : members) {
      memAge = 2021 - mem.getYear();
      if (memAge == old) {
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
