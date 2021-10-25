package view;

import java.util.Map;

import model.domain.UserManager;
import view.Choises.Boats;
import view.Choises.First;
import view.Choises.InLoged;
import view.Choises.Lite;
import view.Choises.Members;
import view.Choises.Search;
import view.Choises.Users;


/**
* user interface for the application.
*/
public class ConsoleUi {

  private Getter get = new Getter();
  private ConsoleUiBoat consoleBoat = new ConsoleUiBoat();
  private ConsoleUiMember consoleMem = new ConsoleUiMember(this);
  private ConsoleUiUser consoleUser = new ConsoleUiUser();



  public void wlecomeMsg() {
    System.out.println("\nWelcome to the Boat Club, choose what you want to do\n");
  }


  private void firstMenu() {
    System.out.println("\n1. Log in");
    System.out.println("2. Use lite");
    System.out.println("0. Exit\n");
  }

  public First firstChoise() {
    int nr = 10;
    First g = null;
    while (g == First.None || g == null) {
      firstMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = First.LogIn;
          break;
        case 2:
          g = First.UseLite;
          break;
        case 0:
          g = First.Exit;
          break;
        default:
          wronger();
          g = First.None;
          break;
      }
      break;
    }
    return g;
  } 

  
  /**
  * checks and gets an answer when change or remove actions is been made.
  */
  public boolean checker() {
    String answer = get.stringGetter();
    while (!(answer.equals("Y") || answer.equals("N"))) {
      wronger();
      answer = get.stringGetter();
    }
    if (answer.equals("Y")) {
      return true;
    } else {
      return false;
    }
  }
  
  public void sureMsgDelete(String name) {
    System.out.println("\nAre You Sure to delete " + name + " ? (Y/N)");
  }
  
  public void sureMsgChange() {
    System.out.println("\nDo You want to Change? (Y/N)");
  }
  
  /**
  * exiting msg.
  */
  public void shutDownApp() {
    System.out.println("\n...");
    System.out.println("Exiting");
    System.out.println("Thanks for using our Program!");
  }

  /**
  * error msg.
  */
  public void wronger() {
    System.out.println("\nWrong Value!");
  }

  public Map.Entry<String, String>  userInfo() {
    System.out.println("\nEnter username: ");
    String username = get.stringGetter();
    System.out.println("\nEnter password: ");
    String password = get.stringGetter();
    Map.Entry<String, String> g = Map.entry(username.toLowerCase(),password.toLowerCase());
    return g;
  }

  public void loginMsg() {
    System.out.println("\nLoged in successfully!");
  }


  public Boats BoatsChoise() {
    return consoleBoat.BoatsChoise();
  }


  public Members membersChoice() {
    return consoleMem.membersChoice();
  }


  public String getString() {
    System.out.println("\nEnter value to Search for\n");
    return get.stringGetter();
  }


  public void noMatch(String name) {
    System.out.println("\nNo match found of the search of " + name + "\n");
  }


  public InLoged inlogedChoise() {
    return consoleUser.inlogedChoise();
  }


  public Lite liteChoise() {
    return consoleUser.liteChoise();
  }


  public Users usersChoice() {
    return consoleUser.usersChoice();
  }


  public String chooseUser(UserManager userMan) {
    return consoleUser.chooseUser(userMan);
  }


  public void printUsers(Map<String, String> users) {
    consoleUser.printUsers(users);
  }

  public Search searchChoies() {
    return consoleUser.searchChoies();
  }

}