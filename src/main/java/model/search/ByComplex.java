package model.search;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import model.domain.Member;

/**
 * complex Search Based on (month || (name && age)).
 */
public class ByComplex implements Search {

  private ArrayList<Member> found = new ArrayList<>();
  String month;
  String age;
  String name;
  

  /**
   * constructor takes in.
   */
  public ByComplex(String month, String name, String age) {
    this.month = month; 
    this.name = name;
    this.age = age;
  }

  /**
  * opreation of finding by the complex search.
  */
  @Override
  public ArrayList<Member> find(Iterable<Member> members, String string) {
    Search s = new ByMonth();

    
    ArrayList<Member> foundedByMonth = s.find(members, month);
    Set<Member> set = new LinkedHashSet<>(foundedByMonth);

    s = new ByName();
    ArrayList<Member> membersByName = s.find(members, name);
    
    s = new ByAge();
    membersByName = s.find(membersByName, age);
    
    for (Member mem : membersByName) {
      set.add(mem);
    }
    ArrayList<Member> founded = new ArrayList<>(set);
    clearList();
    return founded;
  }

  

  @Override
  public void clearList() {
    found.clear();
  }
  
}
