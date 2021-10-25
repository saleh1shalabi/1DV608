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
import view.ConsoleUiMember;

/**
* this is the controller of members.
*/
public class MemberController {

  private ConsoleUi console;
  private ConsoleUiMember consoleMember;
  private MemberManager memMan;
  private boolean check = false;
  private BoatController boatCon;
  private Search search;

  MemberController(MemberManager memMan, BoatController boatCon, ConsoleUi console) {
    this.memMan = memMan;
    this.boatCon = boatCon;
    this.console = console;
    this.consoleMember = new ConsoleUiMember(console);

  }
  
  public Member memberChooser() {
    int memIndex = consoleMember.chooseMember(memMan.getMembers());
    return memMan.getMembers().get(memIndex);
  }

  /**
  * Responsible adding members.
  */
  public void memberAdder() {
    String memberName = consoleMember.firstNameGetter();
    memberName += " " + consoleMember.lastNameGetter();
    Member mem = new Member(memberName, consoleMember.personalIdGetter(),
         memMan.randomId().toString());
    consoleMember.addBoat(mem.getName());
    check = console.checker();
    while (check) {
      boatCon.registerBoat(mem);
      consoleMember.addBoat(mem.getName());
      check = console.checker();
    }
    memMan.addMember(mem);

  }

  /**
  * Responsible changing member info.
  */
  public void changeMember(Member mem) {
    consoleMember.showSpecMemberInfo(mem);
    console.sureMsgChange();
    check = console.checker();
    if (check) {
      if (consoleMember.whatToChange() == 1) {
        mem.setName(consoleMember.firstNameGetter() + consoleMember.lastNameGetter());
      } else {
        mem.setPersonalId(consoleMember.personalIdGetter());
      }
    }
  }

  /**
  * Responsible for removing member.
  */
  public void removeMember() {
    Member mem = memberChooser();
    console.sureMsgDelete(mem.getName());
    check = console.checker();
    if (check) {
      memMan.removeMember(mem);
    }
  }

  public void viewVerboseList() {
    consoleMember.showVerboseList(memMan.getMembers());
  }
  
  public void viewCompactList() {
    consoleMember.showCompactList(memMan.getMembers());
  }

  /**
  * finds the search wanted.
  */
  private void getFounded(ArrayList<Member> allMembers, view.Choises.Search s) { 
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
    ArrayList<Member> members = search.find(allMembers, toSearch);
    if (members.size() == 0) {
      console.noMatch(toSearch);
    } else {
      consoleMember.showVerboseList(members);
    }
    search.clearList();
  }

  /**
  * finds the search by name.
  */
  public void findByName(ArrayList<Member> members) {
    search = new ByName();
    getFounded(members, view.Choises.Search.Name);
    
  }

  public void findByYear(ArrayList<Member> members) {
    search = new ByYear();
    getFounded(members, view.Choises.Search.Year);
  }

  public void findByAge(ArrayList<Member> members) {
    search = new ByAge();
    getFounded(members, view.Choises.Search.Age);
  }

  public void findByMonth(ArrayList<Member> members) {
    search = new ByMonth();
    getFounded(members, view.Choises.Search.Month);
  }

  public void findByBoat(ArrayList<Member> members) {
    search = new ByBoat();
    getFounded(members, view.Choises.Search.Boat);
  }

}