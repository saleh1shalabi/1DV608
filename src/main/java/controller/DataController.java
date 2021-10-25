package controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.UserManager;
import model.presistence.PersistenceInterface;


/**
* abstract class to be data handler.
*/
public abstract class DataController {

  
  private MemberManager memMan;
  private UserManager userMan;
  protected PersistenceInterface hc;

  DataController(MemberManager memMan, UserManager userMan) {
    this.memMan = memMan;
    this.userMan = userMan;
  }


  /**
  * adds the members and theire boats from files or hardcode.
  */
  public void memAdder() {
    String[] nm = hc.getNames();
    int[] persId = hc.getPersonalIds();
    String[] memberIds = hc.getMemberIds();
    int le = nm.length;
    Map<String, ArrayList<Boat>> bl = hc.getBoats();
    for (int c = 0; c < le; c++) {
      Member mem = new Member(nm[c], persId[c], memberIds[c]);
      for (java.util.Map.Entry<String, ArrayList<Boat>> l : bl.entrySet()) {
        if (l.getKey().equals(memberIds[c])) {
          ArrayList<Boat> boats = l.getValue();
          for (Boat b : boats) {
            mem.addBoat(b);
          }
          break;
        }
      }
      memMan.addMember(mem);
    }
  }



  /**
  * Responsible saving changes when quit.
  */
  public void save() {
    hc.saveUsers(userMan.getUsers());
    hc.saveBoats(memMan.getMembers());
    hc.saveMembers(memMan.getMembers());
  }


  /**
  * Responsible adding the users.
  */
  public void userAdder() {
    Map<String,String> users = hc.getUsers();
    String username;
    String password;
    for (Entry<String, String> g : users.entrySet()) {
      username = g.getKey();
      password = g.getValue();
      userMan.addUser(username, password);
    }
  }
  
}
