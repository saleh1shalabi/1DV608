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

  /**
  * shows the main menu.
  */
  public void showMenu() {
    System.out.println("Welcome to the Boat Club, choose what you want to do");
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
  public Action menuActionchoise() {
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
    System.out.println("Are You Sure? (Y/N)");
    String answer = get.stringGetter();
    while (!(answer.equals("Y") || answer.equals("N"))) {
      System.out.println(answer);
      answer = get.stringGetter();
    }
    if (answer.equals("Y")) {
      return true;
    } else {
      return false;
    }
  }
  
  public void shutDownApp() {
    System.out.println("...");
    System.out.println("Exiting");
    System.out.println("Thanks for using our Program!");
  }

  /**
  * and error msg.
  */
  static void wronger() {
    System.out.println("Wrong Value!");
  }

}