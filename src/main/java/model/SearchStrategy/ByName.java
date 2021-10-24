package model.SearchStrategy;

import java.util.ArrayList;
import model.domain.Member;

public class ByName implements Search {
  
  @Override
  public ArrayList<Member> getNames(ArrayList<Member> members, String name) {
    for (Member mem : members) {
      if (mem.getName().equals(name)) {
        found.add(mem);
      } else if (mem.getName().contains(name)) {
        found.add(mem);
      }
    }
    return found;
  }

}
