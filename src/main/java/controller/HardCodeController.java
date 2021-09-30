package controller;

import java.util.Map;
import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;
import model.presistence.HardCodeImplemets;

/**
* controler to add members when program start from hard coded clases.
*/
public class HardCodeController {
  private HardCodeImplemets hc = new HardCodeImplemets();
  private MemberManager memMan;

  HardCodeController(MemberManager memMan) {
    this.memMan = memMan;
  }

  /**
  * Responsible of adding the hard coded members with thier boats.
  */
  public void memAdder() {
    int[] persId = hc.getPersonalIds();
    String[] nm = hc.getNames();
    int le = nm.length;
    for (int c = 0; c < le; c++) {
      Member mem = new Member(nm[c], persId[c], memMan.randomId().toString());
      memMan.addMember(mem);
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
}