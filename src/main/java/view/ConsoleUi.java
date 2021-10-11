package view;

/**
* user interface for the application.
*/
public class ConsoleUi {

  private Getter get = new Getter();

  /**
  * actions to be made in the program.
  */
  public enum Action {
    ADDMEMBER, REGISTERBOAT, CHANGEMEMBER, CHANGEBOAT, VIEWLISTVERBOSE,
    VIEWLISTCOMPACT, DELETEMEMBER, DELETEBOAT, EXIT, None
  }

  public void wlecomeMsg() {
    System.out.println("Welcome to the Boat Club, choose what you want to do");
  }

  /**
  * shows the main menu.
  */
  public void showMenu() {
    System.out.println("1. Add a member");
    System.out.println("2. Register a boat");
    System.out.println("3. View and/or Change a member information");
    System.out.println("4. Change boat information");
    System.out.println("5. View Verbose list");
    System.out.println("6. View Compact list");
    System.out.println("7. Delete a member");
    System.out.println("8. Delete a boat");
    System.out.println("0. Exit");
  }

  /**
  * Gets the chooes of the main menu.
  */
  public Action menuActionChoice() {
    int nr = 10;
    Action g = null;
    while (g == Action.None || g == null) {
      showMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g =  Action.ADDMEMBER;
          break;
        case 2:
          g = Action.REGISTERBOAT;
          break;
        case 3:
          g = Action.CHANGEMEMBER;
          break;
        case 4:
          g = Action.CHANGEBOAT;
          break;
        case 5: 
          g = Action.VIEWLISTVERBOSE;
          break;
        case 6: 
          g = Action.VIEWLISTCOMPACT;
          break;
        case 7: 
          g = Action.DELETEMEMBER;
          break;
        case 8:
          g = Action.DELETEBOAT;
          break;
        case 0:
          g = Action.EXIT;
          break;
        default:
          wronger();
          g = Action.None;
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

}