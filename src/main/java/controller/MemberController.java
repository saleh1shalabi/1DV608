package controller;

import model.domain.Member;
import model.domain.MemberManager;
import view.ConsoleUi;
import view.ConsoleUiMember;

/**
* this is the controller of members.
*/
public class MemberController {
  ConsoleUiMember consoleMember = new ConsoleUiMember();
  ConsoleUi console = new ConsoleUi();
  MemberManager memMan;
  boolean check = false;
  BoatController boatCon;

  MemberController(MemberManager memMan) {
    this.memMan = memMan;
    this.boatCon = new BoatController();

  }
  
  public Member memberChooser() {
    int memIndex = consoleMember.chooseMember(memMan);
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
  public void changeMember() {
    Member mem = memberChooser();
    consoleMember.showSpecMemberInfo(mem);
    console.sureMsgChange();
    check = console.checker();
    if (check) {
      if (consoleMember.whatToChange() == 1) {
        mem.setName(consoleMember.firstNameGetter() + " " + consoleMember.lastNameGetter());

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

}