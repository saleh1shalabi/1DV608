package controller;

import java.util.Map.Entry;
import model.domain.Member;
import model.domain.MemberManager;
import model.domain.UserManager;
import view.ConsoleUi;


/**
* Facad of Controlles.
*/
public class Controller {
  
  private ConsoleUi console = new ConsoleUi();
  private MemberManager memMan = new MemberManager();
  private UserManager userMan = new UserManager();
  private DataController fc = new FileController(memMan, userMan);
  private UserController userCon = new UserController(userMan, console);
  private BoatController boatCon = new BoatController(console);
  private MemberController memCon = new MemberController(memMan, boatCon, console);

  public void memAdder() {
    fc.memAdder();
  }

  public void userAdder() {
    fc.userAdder();
  }

  public boolean logInCheck(Entry<String, String> acount) {
    return userCon.logInCheck(acount);
  }

  public void save() {
    fc.save();
  }

  public void registerBoat(Member mem) {
    boatCon.registerBoat(mem);
  }

  public void changeBoat(Member mem) {
    boatCon.changeBoat(mem);
  }

  public void removeBoat(Member mem) {
    boatCon.removeBoat(mem);
  }

  public void memberAdder() {
    memCon.memberAdder();
  }

  public void changeMember(Member mem) {
    memCon.changeMember(mem);
  }

  public void viewVerboseList() {
    memCon.viewVerboseList();
  }

  public void viewCompactList() {
    memCon.viewCompactList();
  }

  public void removeMember() {
    memCon.removeMember();
  }

  public Member memberChooser() {
    return memCon.memberChooser();
  }

  public String userChooser() {
    return userCon.chooseUser(userMan);
  }

  public void removeUser(String user) {
    userCon.removeUser(user);
  }

  public void viewUsers() {
    userCon.viewUsers();
  }

  public void addNewUser() {
    userCon.userAdder();
  }

  public void findByName() {
    memCon.findByName(memMan.getMembers());
  }

  public void findByAge() {
    memCon.findByAge(memMan.getMembers());
  }

  public void findByMonth() {
    memCon.findByMonth(memMan.getMembers());

  }

  public void findByYear() {
    memCon.findByYear(memMan.getMembers());
  }

  public void findByBoat() {
    memCon.findByBoat(memMan.getMembers());
  }
}
