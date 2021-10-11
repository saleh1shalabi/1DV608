package controller;

import model.domain.Member;
import model.domain.MemberManager;
import view.ConsoleUi;

/**
* This is the controller of the Boat club.
*/
public class BoatClub {
  private ConsoleUi console = new ConsoleUi();
  private MemberManager memMan = new MemberManager();
  private DataController hc = new HardCodeController(memMan);
  private DataController fc = new FileController(memMan);
  private BoatController boatCon = new BoatController(console);
  private MemberController memCon = new MemberController(memMan, boatCon, console);


  /**
   * Responsible for starting the application and calls on the diffrent controllers.
   */
  public void startApp() {
    // hc.memAdder();
    fc.memAdder();
    console.wlecomeMsg();
    boolean quit = false;
    ConsoleUi.Action g = null;
    Member mem;
    while (!quit) {
      g = console.menuActionChoice();
      switch (g) {
        case ADDMEMBER:
          memCon.memberAdder();
          break;
        case REGISTERBOAT:
          mem = memCon.memberChooser();
          boatCon.registerBoat(mem);
          break;
        case CHANGEMEMBER:
          memCon.changeMember();
          break;
        case CHANGEBOAT:
          mem = memCon.memberChooser();
          boatCon.changeBoat(mem);
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
          mem = memCon.memberChooser();
          boatCon.removeBoat(mem);
          break;
        case EXIT:
          quit = true;
          fc.save();
          console.shutDownApp();
          break;
        default:
      }
    }
  }
}
