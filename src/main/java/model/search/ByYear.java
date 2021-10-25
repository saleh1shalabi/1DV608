package model.search;

import java.util.ArrayList;
import model.domain.Member;

/**
* Search by a year given.
*/
public class ByYear implements Search {
  private ArrayList<Member> found = new ArrayList<>();


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
    ArrayList<Member> founded = new ArrayList<>(found);
    return founded;
  }

  @Override
  public void clearList() {
    found.clear();
  }
  
}
