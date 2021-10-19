package controller;

import java.util.Map;
import java.util.Map.Entry;
import model.domain.UserManager;
import view.ConsoleUi;

public class userController {

  private UserManager userMan;
  private ConsoleUi console;
 

  userController(UserManager userMan, ConsoleUi console) {
    this.userMan = userMan;
    this.console = console;
  }

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
  
}
