package model.search;

import java.util.ArrayList;
import model.domain.Member;

/**
* interface for the search strategy.
*/
public interface Search {


  ArrayList<Member> find(ArrayList<Member> members, String string);

  void clearList();
  
}
