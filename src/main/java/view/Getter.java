package view;

import java.util.Scanner;


/**
* Class for the inputs from user.
*/
public class Getter {
  
  private Scanner input = new Scanner(System.in, "utf-8");
  private ConsoleUi console;
  
  Getter(ConsoleUi console) {
    this.console = console;
  }

  /**
  * gets only integer inputs and handels error inputs type.
  */
  public int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        return nr;
      } catch (Exception e) {
        console.wronger();
      }
    }
  }

  /**
  * Responsible for returning a string input.
  */
  public String stringGetter() {
    String st = "";
    do {
      st = input.nextLine();
      st = st.toLowerCase();
    } while (st.equals(""));
    // returns a string with upper case at the first char
    return st = st.substring(0, 1).toUpperCase() + st.substring(1);
  }

  /**
  * looks at the value inputed from the user
  * and compare it to be a right value.
  */
  public int compare(int comparTo) {
    int number = intGetter() - 1;
    while (number >= comparTo || number < 0) {
      console.wronger();
      System.out.println("Please Try To Insert A Right Value");
      number = intGetter() - 1;
    }
    return number;
  }

  
}
