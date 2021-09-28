package view;

import java.util.Scanner;

public class Getter {
  private Scanner input = new Scanner(System.in, "utf-8");
  //private ConsoleUi console = new ConsoleUi();

  public int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        // clears the console 
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return nr;
      } catch (Exception e) {
       ConsoleUi.wronger();
      }
    }
  }

  public String stringGetter() {
    String st = "";
    do {
      st = input.nextLine();
      st = st.toLowerCase();
    } while (st.equals(""));
    // returns a string with upper case at the first char
    return st = st.substring(0, 1).toUpperCase() + st.substring(1);
  }


  public int compare(int comparTo) {
    int number = intGetter() - 1;
    while (number >= comparTo || number < 0) {
      ConsoleUi.wronger();
      System.out.println("Please Try To Insert A Right Value");
      number = intGetter() - 1;
    }
    return number;
  }

  
}
