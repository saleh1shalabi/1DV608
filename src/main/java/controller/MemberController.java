package controller;

import view.ConsoleUiMember;
import model.domain.MemberManager;
import model.domain.Member;


/**
* Responsible for staring the application.
*/
public class MemberController {
  ConsoleUiMember consoleMember = new ConsoleUiMember();
  MemberManager memMan;
  MemberController(MemberManager memMan) {
    this.memMan = memMan;
  }

  public void memberAdder() {
    String memberName = consoleMember.nameGetter();
    Member mem = new Member(memberName, consoleMember.personalIdGetter(), memMan.randomId().toString());
    memMan.addMember(mem);
    for (Member memmm : memMan.getMembers()) {
      System.out.println(memmm.getName());
    }
  }

}