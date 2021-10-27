package controller;

import java.util.Map;
import model.domain.Member;
import view.Choises.Boats;
import view.Choises.First;
import view.Choises.InLoged;
import view.Choises.Lite;
import view.Choises.Members;
import view.Choises.Search;
import view.Choises.Users;
import view.ConsoleUi;


/**
* This is the controller of the Boat club.
*/
public class BoatClub {
  private ConsoleUi console = new ConsoleUi();
  // private DataController hc = new HardCodeController(memMan, userMan);//HardCode used in grade2  
  private Controller controller = new Controller();
  


  /**
   * Responsible for starting the application and calls on the diffrent controllers.
   */
  public void startApp() {
    // hc.memAdder();    // hard code used in grade 2
    controller.memAdder();
    controller.userAdder();
    console.wlecomeMsg();
    firstMenu();
  }


  /**
  * first menu of choises.
  */
  private void firstMenu() {
    First g = null;
    while (g != First.Exit) {
      g = console.firstChoise();
      switch (g) {
        case LogIn:
          Map.Entry<String, String> acount = console.userInfo();
          if (controller.logInCheck(acount)) {
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
          controller.save();
          console.shutDownApp();
          break;
        default:
      }
    }
  }

  /**
  * inloged menu.
  */
  private void inlogedMenu() {
    InLoged g = null;
    while (g != InLoged.LogOut) {
      g = console.inlogedChoise();
      switch (g) {
        case Members:
          memberMenu();
          break;
        case Boats:
          boatMenu();
          break;
        case Search:
          searchMenu();
          break;
        case Users:
          userMenu();
          break;
        case LogOut:
          break;
        default:
      }
    }
  }

  /**
  * users choises.
  */
  private void userMenu() {
    Users g = null;
    String user;
    while (g != Users.Back) {
      g = console.usersChoice();
      switch (g) {
        case AddUser:
          controller.addNewUser();
          break;
        case DeleteUser:
          user = controller.userChooser(); 
          controller.removeUser(user);
          break;
        case ViewUsers:
          controller.viewUsers();
          break;
        case Back:
          break;
        default:
      }
    }
  }

  /**
  * outloged menu.
  */
  private void liteUse() {
    Lite g = null;
    while (g != Lite.Back) {
      g = console.liteChoise();
      switch (g) {
        case Verbose:
          controller.showVerboseList();
          break;
        case Compact:
          controller.showCompactList();
          break;
        case Search:
          searchMenu();
          break;
        case Back:
          break;
        default:
      }
    }
  }

  /**
  * search menu.
  */
  private void searchMenu() {
    Search g = null;
    while (g != Search.Back) {
      g = console.searchChoies();
      switch (g) {
        case Name:
          controller.findByName();
          break;
        case Age:
          controller.findByAge();
    
          break;
        case Month:
          controller.findByMonth();
          break;
        case Year:
          controller.findByYear();
          break;
        case Boat:
          controller.findByBoat();
          break;
        // case DeleteMember:
        //   controller.removeMember();
          // break;
        case Back:
          break;
        default:
      }
    }
  }


  /**
  * menu of what to do with member.
  */
  private void memberMenu() {
    Members g = null;
    Member mem;
    while (g != Members.Back) {
      g = console.membersChoice();
      switch (g) {
        case AddMember:
          controller.memberAdder();
          break;
        case ChangeMember:
          mem = controller.memberChooser();
          controller.changeMember(mem);
          break;
        case Verbose:
          controller.showVerboseList();
          break;
        case Compact:
          controller.showCompactList();
          break;
        case DeleteMember:
          controller.removeMember();
          break;
        case Back:
          break;
        default:
      }
    }
  }


  /**
  * boat menu.
  */
  private void boatMenu() {

    Boats g = null;
    Member mem;
    while (g != Boats.Back) {
      g = console.boatsChoise();
      switch (g) {
        case RegisterBoat:
          mem = controller.memberChooser();
          controller.registerBoat(mem);
          break;
        case ChangeBoat:
          mem = controller.memberChooser();
          controller.changeBoat(mem);
          break;
        case DeleteBoat:
          mem = controller.memberChooser();
          controller.removeBoat(mem);
          break;
        case Back:
          break;
        default:
      }
    }
  }

}
