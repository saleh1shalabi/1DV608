package model.search;

import java.util.ArrayList;
import model.domain.Member;

/**
* interface for the search strategy.
*/
public interface Search {


  ArrayList<Member> find(Iterable<Member> members, String string);

  void clearList();
  
}
