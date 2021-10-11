package controller;

import java.util.ArrayList;
import java.util.Map;

import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;
import model.presistence.PersistenceInterface;

public abstract class DataController {
  public MemberManager memMan;
  public PersistenceInterface hc;

  DataController(MemberManager memMan) {
    this.memMan = memMan;
  }

  public void memAdder() {
    String[] nm = hc.getNames();
    int[] persId = hc.getPersonalIds();
    String[] memberIds = hc.getMemberIds();
    int le = nm.length;
    Map<String, ArrayList<Boat>> bl = hc.getBoats();
    for (int c = 0; c < le; c++) {
      Member mem = new Member(nm[c], persId[c], memberIds[c]);
      
      for (java.util.Map.Entry<String, ArrayList<Boat>> L : bl.entrySet()) {
        if (L.getKey() == memberIds[c]) {
          ArrayList<Boat> boats = L.getValue();
          for (Boat b : boats) {
            mem.addBoat(b);
          }
          break;
        }
      }
      memMan.addMember(mem);
    }
  }

  public void save() {
    hc.saveBoats(memMan.getMembers());
    hc.saveMembers(memMan.getMembers());
  }

  
}
