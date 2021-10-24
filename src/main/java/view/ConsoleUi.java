package view;

import java.util.Map;
import java.util.Map.Entry;

import model.domain.UserManager;
import view.Choises.Boats;
import view.Choises.First;
import view.Choises.InLoged;
import view.Choises.Lite;
import view.Choises.Members;
import view.Choises.Users;


/**
* user interface for the application.
*/
public class ConsoleUi {

  private Getter get = new Getter();
  private ConsoleUiBoat consoleBoat = new ConsoleUiBoat();
  private ConsoleUiMember consoleMem = new ConsoleUiMember(this);



  public void wlecomeMsg() {
    System.out.println("\nWelcome to the Boat Club, choose what you want to do\n");
  }


  public void firstMenu() {
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

  public void inlogedMenu() {
    System.out.println("\n1. Members");
    System.out.println("2. Boats");
    System.out.println("3. Users");
    System.out.println("0. Log Out\n");
  }

  public InLoged InlogedChoise() {
    int nr = 10;
    InLoged g = null;
    while (g == InLoged.None || g == null) {
      inlogedMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = InLoged.Members;
          break;
        case 2:
          g = InLoged.Boats;
          break;
        case 3:
          g = InLoged.Users;
          break;
        case 0:
          g = InLoged.LogOut;
          break;
        default:
          wronger();
          g = InLoged.None;
          break;
      }
      break;
    }
    return g;
  } 

  public void liteMenu() {
    System.out.println("\n1. View Verbose list");
    System.out.println("2. View Compact list");
    System.out.println("0. Back\n");
  }

  public Lite liteChoise() {
    int nr = 10;
    Lite g = null;
    while (g == Lite.None || g == null) {
      liteMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = Lite.Verbose;
          break;
        case 2:
          g = Lite.Compact;
          break;
        case 0:
          g = Lite.Back;
          break;
        default:
          wronger();
          g = Lite.None;
          break;
      }
      break;
    }
    return g;
  } 
  
  public void UsersMenu() {
    System.out.println("\n1. Add new User");
    System.out.println("2. Delete a User");
    System.out.println("3. View Users");
    System.out.println("0. Back\n");
  }
  
  public Users usersChoice() {
    int nr = 10;
    Users g = null;
    while (g == Users.None || g == null) {
      UsersMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = Users.AddUser;
          break;
        case 2:
        g = Users.DeleteUser;;
          break;
        case 3:
          g = Users.ViewUsers;
          break;
        case 0:
          g = Users.Back;
          break;
        default:
          wronger();
          g = Users.None;
          break;
      }
      break;
    }
    return g;
  }


  public String chooseUser(UserManager userMan) {
    
    System.out.println("\nChoose the user: ");
    int count = 1; 
    for (Entry<String, String> g : userMan.getUsers().entrySet()) {
      System.out.println(count + ". " + g.getKey());
      count++;
    }
    int choose = get.compare(userMan.getUsers().size());
    count = 0;
    String user = "";
    for (Entry<String, String> g : userMan.getUsers().entrySet()) {
      if (count == choose) {
        user = g.getKey();
      }
      count++;
    }
    return user;
  }

  public void printUsers(Map<String, String> users) {
    System.err.println("\nAll Users: \n");
    int count = 1; 
    for (Entry<String, String> g : users.entrySet()) {
      System.out.println(count + ". " + g.getKey());
      count++;
    }
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
    System.out.println("Enter a name to Search");
    return get.stringGetter();
  }

}