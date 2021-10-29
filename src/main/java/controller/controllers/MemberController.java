package controller.controllers;

import java.util.ArrayList;
import model.domain.Member;
import model.domain.MemberManager;
import model.search.ByAge;
import model.search.ByBoat;
import model.search.ByComplex;
import model.search.ByMonth;
import model.search.ByName;
import model.search.ByYear;
import model.search.Search;
import view.ConsoleUi;


/**
* this is the controller of members.
*/
public class MemberController {

  private ConsoleUi console;
  private MemberManager memMan = new MemberManager();
  private BoatController boatCon;
  private Search search;
  private view.Choises.Search finn = null;

  public MemberController(BoatController boatCon, ConsoleUi console) {
    this.boatCon = boatCon;
    this.console = console;
  }
  
  public Member memberChooser() {
    int memIndex = console.chooseMember(memMan.getMembers(), memMan.getMembers().size());
    return memMan.getMembers().get(memIndex);
  }

  /**
  * Responsible adding members.
  */
  public void memberAdder() {
    String memberName = console.firstNameGetter();
    memberName += " " + console.lastNameGetter();
    Member mem = new Member(memberName, console.personalIdGetter(),
         memMan.randomId().toString());
    console.addBoat(mem.getName());
    boolean check = console.checker();
    while (check) {
      boatCon.registerBoat(mem);
      console.addBoat(mem.getName());
      check = console.checker();
    }
    memMan.addMember(mem);

  }

  /**
  * Responsible changing member info.
  */
  public void changeMember(Member mem) {
    console.showSpecMemberInfo(mem);
    console.sureMsgChange();
    boolean check = console.checker();
    if (check) {
      if (console.whatToChange() == 1) {
        mem.setName(console.firstNameGetter() + console.lastNameGetter());
      } else {
        mem.setPersonalId(console.personalIdGetter());
      }
    }
  }

  /**
  * Responsible for removing member.
  */
  public void removeMember() {
    Member mem = memberChooser();
    console.sureMsgDelete(mem.getName());
    boolean check = console.checker();
    if (check) {
      memMan.removeMember(mem);
    }
  }

  /**
  * finds the search wanted.
   * @return 
  */
  public ArrayList<Member> getFounded(Iterable<Member> iterable, view.Choises.Search g) { 
    String toSearch = "";
    switch (g) {
      case Name:
        search = new ByName();
        toSearch = console.getString();
        break;
      case Age:
        search = new ByAge();
        toSearch = String.valueOf(console.getAge());
        break;
      case Month:
        search = new ByMonth();
        toSearch = String.valueOf(console.getMonth());
        break;
      case Year:
        search = new ByYear();
        toSearch = String.valueOf(console.getYear());
        break;
      case Boat:
        search = new ByBoat();
        toSearch = console.getBoatType();
        break;
      case Complex:
        advanced(getMembers());
        break;
      case Back:
        break;
      default:
        break;
    }
    if (g == view.Choises.Search.Back) {
      return null;
    } else {
      ArrayList<Member> members = search.find(iterable, toSearch);
      printFounded(members);
      return members;
    }
    
  }

  private void printFounded(ArrayList<Member> members) {
    if (members.size() == 0) {
      console.noMatch();
    } else {
      Iterable<Member> mems = new ArrayList<>(members);
      console.showVerboseList(mems);
    }
    search.clearList();
  }

  public Iterable<Member> getMembers() {
    Iterable<Member> members = new ArrayList<>(memMan.getMembers());
    return members;
  }

  /**
  * adds members from list.
  */
  public void addMembers(ArrayList<Member> memAdder) {
    for (Member mem : memAdder) {
      memMan.addMember(mem);
    }
  }

  /**
  * exemple of advanced search.
  * it shows all members born in month 7.
  * and shows all members that name start with "Sa" and age of 22. 
  * Changing the vlues changes the results. 
  */
  private void advanced(Iterable<Member> iterable) {
    search = new ByComplex("7", "Sa", "22");
    // if u want to test in not hard coded uncomment bellow.
    // search = new ByComplex(String.valueOf(console.getMonth()),console.getString(), String.valueOf(console.getAge()));
    ArrayList<Member> mems = search.find(iterable, "");
    printFounded(mems);

  }

  /**
  * We think it's better to not even create a new class
  * in the interface but only use the already exsisting one's 
  * there is another way of using the complex search
  * by not using the new ByComplex Class and only use exsisting
  * in this case the complex search will only be in the controller
  * not in model.
  */
}