package view;

import java.util.Scanner;


/**
* Class for the inputs from user.
*/
public class Getter {
  
  private Scanner input = new Scanner(System.in, "utf-8");
  
  
  
  /**
  * gets only integer inputs and handels error inputs type.
  */
  public int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        return nr;
      } catch (Exception e) {
        System.out.println("\nWrong Value!\n");
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
      System.out.println("\nWrong Value!");
      System.out.println("Please Try To Insert A Right Value\n");
      number = intGetter() - 1;
    }
    return number;
  }

  
}
