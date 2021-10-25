package controller;

import java.util.Map;
import java.util.Map.Entry;
import model.domain.UserManager;
import view.ConsoleUi;


/**
* Class to be the controller of user.
*/
public class UserController {

  private UserManager userMan;
  private ConsoleUi console;
 

  UserController(UserManager userMan, ConsoleUi console) {
    this.userMan = userMan;
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
      }    
    }
    return c;
  }

  public void userAdder() {
    Map.Entry<String, String> acount = console.userInfo();
    userMan.addUser(acount.getKey(), acount.getValue());
  }

  public String chooseUser(UserManager userMan) {
    return console.chooseUser(userMan);
  }

  /**
  * removes user.
  */
  public void removeUser(String user) {
    console.sureMsgDelete(user);
    if (console.checker()) {
      userMan.removeUser(user);
    }
  }

  public void viewUsers() {
    console.printUsers(userMan.getUsers());
  }

}
