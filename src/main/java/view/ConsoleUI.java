package view;

import java.util.Scanner;
/**
* Responsible for staring the application.
*/
public class ConsoleUI {

  private Scanner input = new Scanner(System.in, "utf-8");

  public enum Action {
    ADDMEMBER, REGISTERBOAT, CHANGEMEMBER, CHANGEBOAT, VIEWLISTVERBOSE, VIEWLISTCOMPACT, DELETEMEMBER, DELETEBOAT, EXIT, None
  }
  /**
  * Responsible for staring the application.
  */
  public Action showMenu() {
    System.out.println("Welcome to the Boat Club, choose what you want to do");
    System.out.println("1. Add a member");
    System.out.println("2. Register a boat");
    System.out.println("3. Change member information");
    System.out.println("4. Change boat information");
    System.out.println("5. View Verbose list");
    System.out.println("6. View Compact list");
    System.out.println("7. Delete a member");
    System.out.println("8. Delete a boat");
    System.out.println("9. Exit");

    int nr = intGetter();
    Action g = null;
    while(g != Action.EXIT){
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
        case 9:
          g = Action.EXIT;
          break;
        default:
          wronger();
          nr = intGetter();
        }
      break;
    }
    return g;
  }

  private int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        return nr;
      } catch (Exception e) {
        wronger();
      }
    }
  }
  
  private double doubleGetter() {
    while (true) {
      try {
        double nr = Double.parseDouble(input.nextLine());
        // clears the console 
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // round to only 1 decimal 
        double te = Math.round(nr * 10.0) / 10.0;
        // check if the value is 0
        while (te == 0) {
          System.out.println("you can not add så smal number");
          nr = Double.parseDouble(input.nextLine());
          te = Math.round(nr * 10.0) / 10.0;
        }
        return te;
      } catch (Exception e) {
        wronger();
      }
    }
  }

  private String stringGetter() {
    String st = "";
    do {
      st = input.nextLine();
      st = st.toLowerCase();
    } while (st.equals(""));
    // returns a string with upper case at the first char
    return st = st.substring(0, 1).toUpperCase() + st.substring(1);
  }

  private void wronger() {
    System.out.println("Wrong Value!");
  }

}