package controller;

import java.util.ArrayList;

import model.SearchStrategy.ByAge;
import model.SearchStrategy.ByBoat;
import model.SearchStrategy.ByMonth;
import model.SearchStrategy.ByName;
import model.SearchStrategy.ByYear;
import model.SearchStrategy.Search;
import model.domain.Member;
import model.domain.MemberManager;
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
    Member mem = new Member(memberName, consoleMember.personalIdGetter(), memMan.randomId().toString());
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

  private void getFounded(ArrayList<Member> allMembers, String s) { 
    String toSearch = "";
    if (s.equals("name")) {
      toSearch = console.getString();
    } else if (s.equals("age")) {
      toSearch = String.valueOf(console.getAge());
    } else if (s.equals("month")) {
      toSearch = String.valueOf(console.getMonth());
    } else if (s.equals("year")) {
      toSearch = String.valueOf(console.getYear());
    } else if (s.equals("boat")) {
      toSearch = console.getBoatType();
    }
    System.out.println(toSearch);

    ArrayList<Member> members = search.find(allMembers, toSearch);
    if (members.size() == 0) {
      console.noMatch(toSearch);
    } else {
    consoleMember.showVerboseList(members);
    }
    search.clearList();
  }
  public void findByName(ArrayList<Member> members) {
    search = new ByName();
    getFounded(members, "name");
    
  }

  public void findByYear(ArrayList<Member> members) {
    search = new ByYear();
    getFounded(members, "year");
  }

  public void findByAge(ArrayList<Member> members) {
    search = new ByAge();
    getFounded(members, "age");
  }

  public void findByMonth(ArrayList<Member> members) {
    search = new ByMonth();
    getFounded(members, "month");
  }

  public void findByBoat(ArrayList<Member> members) {
    search = new ByBoat();
    getFounded(members, "boat");
  }

}