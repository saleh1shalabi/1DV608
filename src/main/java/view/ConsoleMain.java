package view;

import view.Choises.First;
import view.Choises.Lite;
import view.Choises.Search;


/**
* user interface for the application.
*/
public class ConsoleMain {

  private Getter get = new Getter();


  public void wlecomeMsg() {
    System.out.println("\nWelcome to the Boat Club, choose what you want to do\n");
  }

  /**
  * first menu.
  */
  private void firstMenu() {
    System.out.println("\n1. Log in");
    System.out.println("2. Use lite");
    System.out.println("0. Exit\n");
  }

  /**
  * choise of first menu.
  */
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
  * outloged menu.
  */
  private void liteMenu() {
    System.out.println("\n1. View Verbose list");
    System.out.println("2. View Compact list");
    System.out.println("3. Search");
    System.out.println("0. Back\n");
  }

  /**
  * outloged choise.
  */
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
        case 3:
          g = Lite.Search;
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
  * search menu.
  */
  private void searchMenu() {
    System.out.println("\n1. Search by Name");
    System.out.println("2. Search by Age");
    System.out.println("3. Search by month of berth");
    System.out.println("4. Search by year of berth");
    System.out.println("5. Search for members with a special boatType");
    System.err.println("6. Complex search EXEMPLE");
    System.out.println("0. Back\n");
  }

  /**
  * search choise.
  */
  public Search searchChoies() {
    int nr = 10;
    Search g = null;
    while (g == Search.None || g == null) {
      searchMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = Search.Name;
          break;
        case 2:
          g = Search.Age;
          break;
        case 3:
          g = Search.Month;
          break;
        case 4:
          g = Search.Year;
          break;
        case 5:
          g = Search.Boat;
          break;
        case 6:
          g = Search.Complex;
          break;
        case 0:
          g = Search.Back;
          break;
        default:
          wronger();
          g = Search.None;
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
    get.wronger();
  }



  public void loginMsg() {
    System.out.println("\nLoged in successfully!");
  }

  public String getString() {
    System.out.println("\nEnter a Name to Search for\n");
    return get.stringGetter();
  }


  public void noMatch() {
    System.out.println("\nNo match found of the search \n");
  }

  public void cantRemove() {
    System.out.println("Can not Delete the user while inlogged!");
  }
  
  
}
