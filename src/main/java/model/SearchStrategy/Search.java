package model.SearchStrategy;

import java.util.ArrayList;
import model.domain.Member;


public interface Search {

  ArrayList<Member> found = new ArrayList<>();

  ArrayList<Member> find(ArrayList<Member> members, String string);

  void clearList();
  
}
