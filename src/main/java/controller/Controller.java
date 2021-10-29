package controller;

import java.util.Map.Entry;

import controller.controllers.BoatController;
import controller.controllers.DBController;
import controller.controllers.DataController;
import controller.controllers.MemberController;
import controller.controllers.UserController;
import model.domain.Member;
import view.ConsoleUi;


/**
* Facad of Controlles.
*/
public class Controller {
  
  private ConsoleUi console = new ConsoleUi();
  private DataController fc = new DBController();

  // HardCode Controller, to use comment the prevuios line and un comment bellow 
  // private DataController fc = new HardCodeController(memMan, userMan);

  private UserController userCon = new UserController(console);
  private BoatController boatCon = new BoatController(console);
  private MemberController memCon = new MemberController(boatCon, console);

  public void memAdder() {
    memCon.addMembers(fc.memAdder());
  }

  public void userAdder() {
    userCon.addUsers(fc.userAdder());
  }

  public boolean logInCheck(Entry<String, String> acount) {
    return userCon.logInCheck(acount);
  }

  public void save() {
    fc.save(userCon.getUsers(), memCon.getMembers());
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

  public void showVerboseList() {
    console.showVerboseList(memCon.getMembers());
  }

  public void showCompactList() {
    console.showCompactList(memCon.getMembers());
  }

  public void removeMember() {
    memCon.removeMember();
  }

  public Member memberChooser() {
    return memCon.memberChooser();
  }

  public String userChooser() {
    return userCon.chooseUser();
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

  public void getFounded(view.Choises.Search g) {
    memCon.getFounded(memCon.getMembers(), g);
  }
}
