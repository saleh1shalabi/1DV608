package controller;

import model.domain.Boat;
import model.domain.Member;
import view.ConsoleUi;
import view.ConsoleUiBoat;

/**
* This is the controller of boats.
*/
public class BoatController {
  
  private ConsoleUi console;
  private ConsoleUiBoat consoleBoat = new ConsoleUiBoat();


  BoatController(ConsoleUi console) {
    this.console = console;
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
    
    consoleBoat.chooseMessage();
    int boatIndex = consoleBoat.chooseBoat(mem);
    console.sureMsgDelete(mem.getBoats().get(boatIndex).getType());
    boolean check = console.checker();
    if (check) {
      mem.removeBoat(mem.getBoats().get(boatIndex));
    }
  }
}