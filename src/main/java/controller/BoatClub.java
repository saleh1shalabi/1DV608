package controller;

import java.util.Map;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.UserManager;
import view.ConsoleUi;
import view.ConsoleUi.Boats;
import view.ConsoleUi.First;
import view.ConsoleUi.InLoged;
import view.ConsoleUi.Lite;
import view.ConsoleUi.Members;

/**
* This is the controller of the Boat club.
*/
public class BoatClub {
  private ConsoleUi console = new ConsoleUi();
  private MemberManager memMan = new MemberManager();
  private UserManager userMan = new UserManager();
  // private DataController hc = new HardCodeController(memMan, userMan);    // HardCode used in grade 2  
  private DataController fc = new FileController(memMan, userMan);
  private userController userCon = new userController(userMan, console);
  private BoatController boatCon = new BoatController(console);
  private MemberController memCon = new MemberController(memMan, boatCon, console);


  /**
   * Responsible for starting the application and calls on the diffrent controllers.
   */
  public void startApp() {
    // hc.memAdder();    // hard code used in grade 2
    fc.memAdder();
    fc.userAdder();
    console.wlecomeMsg();
    firstMenu();
  }

  private void firstMenu() {
    ConsoleUi.First g = null;
    while (g != First.Exit) {
      g = console.firstChoise();
      switch (g) {
        case LogIn:
          Map.Entry<String, String> acount = console.userInfo();
          if (userCon.logInCheck(acount)) {
            console.loginMsg();
            inlogedMenu();
          } else {
            console.wronger();
          }
          break;
        case UseLite:
          liteUse();
          break;
        case Exit:
          fc.save();
          console.shutDownApp();
          break;
        default:
      }
    }
  }

  private void inlogedMenu() {
    ConsoleUi.InLoged g = null;
    while (g != InLoged.LogOut) {
      g = console.InlogedChoise();
      switch (g) {
        case Members:
          memberMenu();
          break;
        case Boats:
          boatMenu();
          break;
        case Users:
          break;
        case LogOut:
          break;
        default:
      }
    }
  }

  private void liteUse() {
    ConsoleUi.Lite g = null;
    while (g != Lite.Back) {
      g = console.liteChoise();
      switch (g) {
        case Verbose:
          memCon.viewVerboseList();
          break;
        case Compact:
          memCon.viewCompactList();
          break;
        case Back:
          break;
        default:
      }
    }
  }

  private void memberMenu() {
    ConsoleUi.Members g = null;
    Member mem;
    while (g != Members.Back) {
      g = console.membersChoice();
      switch (g) {
        case AddMember:
          memCon.memberAdder();
          break;
        case ChangeMember:
          mem = memCon.memberChooser();
          memCon.changeMember(mem);
          break;
        case Verbose:
          memCon.viewVerboseList();
          break;
        case Compact:
          memCon.viewCompactList();
          break;
        case DeleteMember:
          memCon.removeMember();
          break;
        case Back:
          break;
        default:
      }
    }
  }

  private void boatMenu() {

    ConsoleUi.Boats g = null;
    Member mem;
    while (g != Boats.Back) {
      g = console.BoatsChoise();
      switch (g) {
        case RegisterBoat:
          mem = memCon.memberChooser();
          boatCon.registerBoat(mem);
          break;
        case ChangeBoat:
          mem = memCon.memberChooser();
          boatCon.changeBoat(mem);
          break;
        case DeleteBoat:
          mem = memCon.memberChooser();
          boatCon.removeBoat(mem);
          break;
        case Back:
          break;
        default:
      }
    }
  }

}
