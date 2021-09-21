package controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import view.ConsoleUi;

/**
 * Responsible for staring the application.
 */
public class App {

  ArrayList<Member> members = new ArrayList<>();
  view.ConsoleUi console = new view.ConsoleUi();


  /**
   * Responsible for staring the application.
   */
  private void startApp() {
    boolean quit = false;
    ConsoleUi.Action g = null;
    while (!quit) {
      g = console.menuActionchoise();
      switch (g) {
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
          System.out.println("BYE");
          break;
        default:
        
        

      }
    }
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
