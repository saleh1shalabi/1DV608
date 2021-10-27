package controller;

import java.util.ArrayList;
import model.domain.Member;
import model.domain.MemberManager;
import model.search.ByAge;
import model.search.ByBoat;
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

  MemberController(BoatController boatCon, ConsoleUi console) {
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
  */
  private void getFounded(Iterable<Member> iterable, view.Choises.Search s) { 
    String toSearch = "";
    switch (s) {
      case Name:
        toSearch = console.getString();
        break;
      case Age:
        toSearch = String.valueOf(console.getAge());
        break;
      case Month:
        toSearch = String.valueOf(console.getMonth());
        break;
      case Year:
        toSearch = String.valueOf(console.getYear());
        break;
      case Boat:
        toSearch = console.getBoatType();
        break;
      default:
        break;
    }
    ArrayList<Member> members = search.find(iterable, toSearch);
    if (members.size() == 0) {
      console.noMatch(toSearch);
    } else {
      console.showVerboseList(members);
    }
    search.clearList();
  }

  /**
  * finds the search by name.
  */
  public void findByName() {
    search = new ByName();
    Iterable<Member> members = new ArrayList<>(memMan.getMembers());
    getFounded(members, view.Choises.Search.Name);

  }

  /**
  * finds the search by Year of berth.
  */
  public void findByYear() {
    search = new ByYear();
    Iterable<Member> members = new ArrayList<>(memMan.getMembers());
    getFounded(members, view.Choises.Search.Year);
  }

  /**
  * finds the search by Age.
  */
  public void findByAge() {
    Iterable<Member> members = new ArrayList<>(memMan.getMembers());
    search = new ByAge();
    getFounded(members, view.Choises.Search.Age);
  }

  /**
  * finds the search by month of berth.
  */
  public void findByMonth() {
    search = new ByMonth();
    Iterable<Member> members = new ArrayList<>(memMan.getMembers());
    getFounded(members, view.Choises.Search.Month);
  }

  /**
  * finds the search by type of boats owned.
  */
  public void findByBoat() {
    search = new ByBoat();
    Iterable<Member> members = new ArrayList<>(memMan.getMembers());
    getFounded(members, view.Choises.Search.Boat);
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

}