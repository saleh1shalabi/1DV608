package controller;

import java.util.Map;
import java.util.Map.Entry;
import model.domain.UserManager;
import view.ConsoleUi;


/**
* Class to be the controller of user.
*/
public class UserController {

  private UserManager userMan = new UserManager();
  private ConsoleUi console;
  private String currentUser;

  UserController(ConsoleUi console) {
    this.console = console;
  }

  /**
  * Responsible of checking if the user is vaild.
  */
  public boolean logInCheck(Map.Entry<String, String> user) {
    boolean c = false;
    for (Entry<String, String> g : userMan.getUsers().entrySet()) {
      if (user.equals(g)) {
        c = true;
        currentUser = user.getKey();
      }    
    }
    return c;
  }

  public void userAdder() {
    Map.Entry<String, String> acount = console.userInfo();
    userMan.addUser(acount.getKey(), acount.getValue());
  }

  public String chooseUser() {
    return console.chooseUser(userMan.getUsers(), userMan.getUsers().size());
  }

  /**
  * removes user.
  */
  public void removeUser(String user) {
    if (user.equals(currentUser)) {
      console.cantRemove();
    } else {
      console.sureMsgDelete(user);
      if (console.checker()) {
        userMan.removeUser(user);
      }
    }
  }

  public void viewUsers() {
    console.printUsers(userMan.getUsers());
  }

  /**
  * adds users.
  */
  public void addUsers(Map<String, String> users) {
    for (Entry<String, String> user : users.entrySet()) {
      userMan.addUser(user.getKey(), user.getValue());
    }

  }

  public Map<String, String> getUsers() {
    return userMan.getUsers();
  }

}
