package controller;

import java.util.ArrayList;
import java.util.Map;
import model.domain.Boat;
import model.domain.Member;
import model.presistence.PersistenceInterface;


/**
* abstract class to be data handler.
*/
public abstract class DataController {

  protected PersistenceInterface hc;

  /**
  * adds the members and theire boats from files or hardcode.
  *
  * @return members as arraylist.
  */
  public ArrayList<Member> memAdder() {
    ArrayList<Member> members = new ArrayList<>();
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
      members.add(mem);
    }
    return members;
  }



  /**
  * Responsible saving changes when quit.
  *
  * @param members all members.
  *
  * @param users all users.
  */
  public void save(Map<String, String> users, Iterable<Member> members) {
    hc.saveUsers(users);
    hc.saveBoats(members);
    hc.saveMembers(members);
  }


  /**
  * Responsible adding the users.
  *
  * @return users as map.
  */
  public Map<String, String> userAdder() {
    Map<String, String> users = hc.getUsers();
    return users;
  }
  
}
