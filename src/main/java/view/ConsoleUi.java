package view;

import java.util.Map;

/**
* user interface for the application.
*/
public class ConsoleUi {

  private Getter get = new Getter();

  /**
  * actions to be made in the program.
  */
  public enum InLoged {
    None, Members, Boats, Users, LogOut
  }

  public enum Lite {
    Compact, Verbose, None, Back
  }

  public enum First {
    LogIn, UseLite, Exit, None
  }

  public enum Members {
    AddMember, ChangeMember, Compact, Verbose,
    DeleteMember,  Back, None
  }

  public enum Boats {
    RegisterBoat, ChangeBoat, DeleteBoat, Back, None
  }

  public enum Users {
    AddUser, ChangeUser, DeleteUser, ViewUsers,
    Back, None
  }

  public void wlecomeMsg() {
    System.out.println("Welcome to the Boat Club, choose what you want to do");
  }

  public void inlogedMenu() {
    System.out.println("1. Members");
    System.out.println("2. Boats");
    System.out.println("3. Users");
    System.out.println("0. Log Out");
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

  public void firstMenu() {
    System.out.println("1. Log in");
    System.out.println("2. Use lite");
    System.out.println("0. Exit");
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

  public void liteMenu() {
    System.out.println("1. View Verbose list");
    System.out.println("2. View Compact list");
    System.out.println("0. Back");
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

  /**
  * shows the main menu.
  */
  public void showMenuMembers() {
    System.out.println("1. Add a member");
    System.out.println("2. Change a member information");
    System.out.println("3. View Verbose list");
    System.out.println("4. View Compact list");
    System.out.println("5. Delete a member");
    System.out.println("0. Back");
  }

  /**
  * Gets the chooes of the main menu.
  */
  public Members membersChoice() {
    int nr = 10;
    Members g = null;
    while (g == Members.None || g == null) {
      showMenuMembers();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g =  Members.AddMember;
          break;
        case 2:
          g = Members.ChangeMember;
          break;
        case 3: 
          g = Members.Verbose;
          break;
        case 4: 
          g = Members.Compact;
          break;
        case 5: 
          g = Members.DeleteMember;
          break;
        case 0:
          g = Members.Back;
          break;
        default:
          wronger();
          g = Members.None;
          break;
      }
      break;
    }
    return g;
  }

  public void showMenuBoats() {
    System.out.println("1. Add a Boat");
    System.out.println("2. Change a Boat");
    System.out.println("3. Delete a Boat");
    System.out.println("0. Back");
  }

  public Boats BoatsChoise() {
    int nr = 10;
    Boats g = null;
    while (g == Boats.None || g == null) {
      showMenuBoats();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = Boats.RegisterBoat;
          break;
        case 2:
          g = Boats.ChangeBoat;
          break;
        case 3:
          g = Boats.DeleteBoat;
          break;
        case 0:
          g = Boats.Back;
          break;
        default:
          wronger();
          g = Boats.None;
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
    System.out.println("Are You Sure to delete " + name + " ? (Y/N)");
  }
  
  public void sureMsgChange() {
    System.out.println("Do You want to Change? (Y/N)");
  }
  
  /**
  * exiting msg.
  */
  public void shutDownApp() {
    System.out.println("...");
    System.out.println("Exiting");
    System.out.println("Thanks for using our Program!");
  }

  /**
  * error msg.
  */
  public void wronger() {
    System.out.println("Wrong Value!");
  }

  public Map.Entry<String, String>  userInfo() {
    System.out.println("Enter username: ");
    String username = get.stringGetter();
    System.out.println("Enter password: ");
    String password = get.stringGetter();
    Map.Entry<String, String> g = Map.entry(username.toLowerCase(),password.toLowerCase());
    return g;
  }

  public void loginMsg() {
    System.out.println("Loged in successfully!");
  }

}