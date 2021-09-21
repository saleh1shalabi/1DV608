package controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import view.ConsoleUI;

/**
 * Responsible for staring the application.
 */
public class App {

  ArrayList<Member> members = new ArrayList<>();
  view.ConsoleUI console = new view.ConsoleUI();


  /**
   * Responsible for staring the application.
   */
  private void startApp() {
    boolean quit = false;
    do {
      ConsoleUI.Action a = console.showMenu();
      switch (a) {
        case ADDMEMBER:
          System.out.println("Add member");
          break;
        case REGISTERBOAT:
          System.out.println("boat add");
          break;
        case CHANGEMEMBER:
          System.out.println("change mem");
          break;
        case CHANGEBOAT:
          System.out.println("change boat");
          break;
        case VIEWLISTVERBOSE:
          System.out.println("verbos");
          break;
        case VIEWLISTCOMPACT:
          System.out.println("compact");
          break;
        case DELETEMEMBER:
          System.out.println("remove mem");
          break;
        case DELETEBOAT:
          System.out.println("remove boat");
          break;
        case EXIT:
          quit = true;
          break;
        default:
      }
    } while (!quit);
  }

  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    App a = new App();
    a.startApp();
    // adapt to start the application in your way
    model.Simple m = new model.Simple();
    Simple c = new Simple();
    view.Simple v = new view.Simple();

    c.doSomethingSimple(m, v);
  }
  
}
