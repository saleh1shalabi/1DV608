package controller.controllers;

import model.domain.Boat;
import model.domain.Member;
import view.ConsoleUi;

/**
* This is the controller of boats.
*/
public class BoatController {
  
  private ConsoleUi console;

  public BoatController(ConsoleUi console) {
    this.console = console;
  }
  
  /**
  * Responsible for register a boat to a member.
  */
  public void registerBoat(Member mem) {
    String boatType = console.getBoatType();
    Integer length = console.lengthGetter();
    Boat boat = new Boat(boatType, length);
    mem.addBoat(boat);
  }

  /**
  * Responsible for changing a boats information.
  */
  public void changeBoat(Member mem) {
    console.chooseMessage();
    int boatIndex = console.chooseBoat(mem);
    console.sureMsgChange();
    boolean check = console.checker();
    if (check) {
      if (console.whatToChange() == 1) {
        mem.getBoats().get(boatIndex).setType(console.getBoatType());
      } else {
        mem.getBoats().get(boatIndex).setLength(console.lengthGetter());
      }
    }
  }

  /**
  * Responsible for removing a boat from a member.
  */
  public void removeBoat(Member mem) {
    
    console.chooseMessage();
    int boatIndex = console.chooseBoat(mem);
    console.sureMsgDelete(mem.getBoats().get(boatIndex).getType());
    boolean check = console.checker();
    if (check) {
      mem.removeBoat(mem.getBoats().get(boatIndex));
    }
  }
}