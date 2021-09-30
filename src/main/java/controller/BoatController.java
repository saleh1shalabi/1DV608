package controller;

import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;
import view.ConsoleUi;
import view.ConsoleUiBoat;
import view.ConsoleUiMember;

/**
* This is the controller of boats.
*/
public class BoatController {
  ConsoleUiMember consoleMember = new ConsoleUiMember();
  ConsoleUi console = new ConsoleUi();
  ConsoleUiBoat consoleBoat = new ConsoleUiBoat();


  BoatController(MemberManager memMann) {
  }
  
  /**
  * Responsible for register a boat to a member.
  */
  public void registerBoat(Member mem) {
    String boatType = consoleBoat.chooseBoatType();
    Integer length = consoleBoat.lengthGetter();
    Boat boat = new Boat(boatType, length);
    mem.addBoat(boat);
  }

  /**
  * Responsible for changing a boats information.
  */
  public void changeBoat(Member mem) {
    consoleMember.chooseMemberToRemoveBoat();
    consoleBoat.chooseMessage();
    int boatIndex = consoleBoat.chooseBoat(mem);
    console.sureMsgChange();
    boolean check = console.checker();
    if (check) {
      if (consoleBoat.whatToChange() == 1) {
        mem.getBoats().get(boatIndex).setType(consoleBoat.chooseBoatType());
      } else {
        mem.getBoats().get(boatIndex).setLength(consoleBoat.lengthGetter());
      }
    }
  }

  /**
  * Responsible for removing a boat from a member.
  */
  public void removeBoat(Member mem) {
    consoleMember.chooseMessage();
    consoleBoat.chooseMessage();
    int boatIndex = consoleBoat.chooseBoat(mem);
    console.sureMsgDelete();
    boolean check = console.checker();
    if (check) {
      mem.removeBoat(mem.getBoats().get(boatIndex));
    }
  }
}