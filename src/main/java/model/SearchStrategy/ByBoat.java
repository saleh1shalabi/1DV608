package model.SearchStrategy;

import java.util.ArrayList;

import model.domain.Boat;
import model.domain.Member;

public class ByBoat implements Search {

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
