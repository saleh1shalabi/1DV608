package model.search;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Member;

/**
* Search by a chosen boat.
*/
public class ByBoat implements Search {
  private ArrayList<Member> found = new ArrayList<>();


  @Override
  public ArrayList<Member> find(ArrayList<Member> members, String string) {
    
    for (Member mem : members) {
      for (Boat b : mem.getBoats()) {
        if (b.getType().equals(string)) {
          found.add(mem);
          break;
        }
      }
    }
    return found;
  }

  @Override
  public void clearList() {
    found.clear();
  }
  
}
