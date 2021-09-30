package controller;

import model.domain.MemberManager;
import view.ConsoleUi;

/**
* This is the controller of the Boat club.
*/
public class BoatClub {
  private view.ConsoleUi console = new ConsoleUi();
  private MemberManager memMan = new MemberManager();
  private HardCodeController hcC = new HardCodeController(memMan);
  private MemberController memCon = new MemberController(memMan);
  private BoatController boatCon = new BoatController(memMan);

  /**
   * Responsible for starting the application and calls on the diffrent controllers.
   */
  public void startApp() {
    hcC.memAdder();
    boolean quit = false;
    ConsoleUi.Action g = null;
    while (!quit) {
      g = console.menuActionchoise();
      switch (g) {
        case ADDMEMBER:
          memCon.memberAdder();
          break;
        case REGISTERBOAT:
          boatCon.registerBoat();
          break;
        case CHANGEMEMBER:
          memCon.changeMember();
          break;
        case CHANGEBOAT:
          boatCon.changeBoat();
          break;
        case VIEWLISTVERBOSE:
          memCon.viewVerboseList();
          break;
        case VIEWLISTCOMPACT:
          memCon.viewCompactList();
          break;
        case DELETEMEMBER:
          memCon.removeMember();
          break;
        case DELETEBOAT:
          boatCon.removeBoat();
          break;
        case EXIT:
          quit = true;
          console.shutDownApp();
          break;
        default:
      }
    }
  }
}
