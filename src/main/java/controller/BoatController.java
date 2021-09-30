package controller;
import view.ConsoleUiMember;
import model.domain.MemberManager;

/**
* Responsible for staring the application.
*/
public class BoatController {
  ConsoleUiMember consoleMember = new ConsoleUiMember();
  MemberManager memMan;

  BoatController(MemberManager memMan){
    this.memMan = memMan;
  }
}