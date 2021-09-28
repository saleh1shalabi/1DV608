package controller;

import java.util.Map;
import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;
import model.presistence.HardCodeImplemets;
import view.ConsoleUi;
import view.ConsoleUiBoat;
import view.ConsoleUiMember;

/**
* Responsible for staring the application.
*/
public class BoatClub {
  private view.ConsoleUi console = new ConsoleUi();
  private view.ConsoleUiMember consoleMember = new ConsoleUiMember();
  private view.ConsoleUiBoat consoleBoat = new ConsoleUiBoat();
  private HardCodeImplemets hc = new HardCodeImplemets();
  private MemberManager memMan = new MemberManager();

  /**
   * Responsible for staring the application.
   */
  private void memAdder() {
    int[] persId = hc.getPersonalIds();
    String[] nm = hc.getNames();
    int le = nm.length;
    for (int c = 0; c < le; c++) {
      Member mem = new Member(nm[c], persId[c], memMan.randomId());
      memMan.addMemberToCatalog(mem);
    }
    for (Map.Entry<String, Integer> b : hc.getmem1Boats().entrySet()) {
      String boatType = b.getKey();
      int length = b.getValue();
      memMan.getMembers().get(0).addBoat(new Boat(boatType, length));
    }
    for (Map.Entry<String, Integer> b : hc.getmem2Boats().entrySet()) {
      String boatType = b.getKey();
      int length = b.getValue();
      memMan.getMembers().get(1).addBoat(new Boat(boatType, length));
    }
    for (Map.Entry<String, Integer> b : hc.getmem3Boats().entrySet()) {
      String boatType = b.getKey();
      int length = b.getValue();
      memMan.getMembers().get(2).addBoat(new Boat(boatType, length));
    }
    for (Map.Entry<String, Integer> b : hc.getmem4Boats().entrySet()) {
      String boatType = b.getKey();
      int length = b.getValue();
      memMan.getMembers().get(3).addBoat(new Boat(boatType, length));
    }
  }

  /**
   * Responsible for staring the application.
   */
  public void startApp() {
    randomId();
    memAdder();
    boolean quit = false;
    ConsoleUi.Action g = null;
    while (!quit) {
      g = console.menuActionchoise();
      switch (g) {
        case ADDMEMBER:
          String memberName = consoleMember.nameGetter();
          model.domain.Member mem = new model.domain.Member(memberName, consoleMember.personalIdGetter(), memMan.randomId());
          memMan.addMemberToCatalog(mem);
          break;
        case REGISTERBOAT:
          int memIndex = consoleBoat.chooseMember(memMan);
          String boatType = consoleBoat.chooseBoatType();
          Integer length = consoleBoat.lengthGetter();
          Boat boat = new Boat(boatType, length);
          memMan.getMembers().get(memIndex).addBoat(boat);
          break;
        case CHANGEMEMBER:
          System.out.println("change mem");
          break;
        case CHANGEBOAT:
          System.out.println("change boat");
          break;
        case VIEWLISTVERBOSE:
          consoleMember.showVerboseList(memMan.getMembers());
          break;
        case VIEWLISTCOMPACT:
          consoleMember.showCompactList(memMan.getMembers());
          System.out.println("compact");
          break;
        case DELETEMEMBER:
          System.out.println("remove mem");
          break;
        case DELETEBOAT:
          System.out.println("remove boat");
          break;
        case EXIT:
          quit = true;
          System.out.println("BYE");
          break;
        default:
      }
    }
  }

  /**
  * Responsible for staring the application.
  */
  public void randomId(){

    String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int count = 6;
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
      int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }  
    System.out.println(builder);
  }

}
