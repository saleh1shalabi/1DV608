package model.SearchStrategy;

import java.util.ArrayList;
import model.domain.Member;
import view.ConsoleUi;

public interface Search {

  ConsoleUi console = new ConsoleUi();
  ArrayList<Member> found = new ArrayList<>();

  ArrayList<Member> find(ArrayList<Member> members, String string);

  void clearList();
  
}
