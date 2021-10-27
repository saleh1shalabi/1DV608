package view;

import java.util.Map;
import java.util.Map.Entry;
import view.Choises.InLoged;
import view.Choises.Users;


/**
* user interface for the user.
*/
public class ConsoleUiUser {

  private Getter get = new Getter();

  /**
  * inloged menu.
  */
  private void inlogedMenu() {
    System.out.println("\n1. Members");
    System.out.println("2. Boats");
    System.out.println("3. Search");
    System.out.println("4. Users");
    System.out.println("0. Log Out\n");
  }

  /**
  * gets the username and password.
  */
  public Map.Entry<String, String>  userInfo() {
    System.out.println("\nEnter username: ");
    String username = get.stringGetter();
    System.out.println("\nEnter password: ");
    String password = get.stringGetter();
    Map.Entry<String, String> g = Map.entry(username.toLowerCase(), password.toLowerCase());
    return g;
  }


  /**
  *inloged choise.
  */
  public InLoged inlogedChoise() {
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
          g = InLoged.Search;
          break;
        case 4:
          g = InLoged.Users;
          break;
        case 0:
          g = InLoged.LogOut;
          break;
        default:
          System.out.println("Wrong Value!");
          g = InLoged.None;
          break;
      }
      break;
    }
    return g;
  } 


  
  
  /**
  * user menu.
  */
  private void usersMenu() {
    System.out.println("\n1. Add new User");
    System.out.println("2. Delete a User");
    System.out.println("3. View Users");
    System.out.println("0. Back\n");
  }
  
  /**
  * user choise.
  */
  public Users usersChoice() {
    int nr = 10;
    Users g = null;
    while (g == Users.None || g == null) {
      usersMenu();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = Users.AddUser;
          break;
        case 2:
          g = Users.DeleteUser;;
          break;
        case 3:
          g = Users.ViewUsers;
          break;
        case 0:
          g = Users.Back;
          break;
        default:
          System.out.println("Wrong Value!");
          g = Users.None;
          break;
      }
      break;
    }
    return g;
  }


  

  /**
  * shows the users and return one to delete.
  */
  public String chooseUser(Map<String,String> users, int size) {
    
    System.out.println("\nChoose the user: ");
    int count = 1; 
    for (java.util.Map.Entry<String, String> g : users.entrySet()) {
      System.out.println(count + ". " + g.getKey());
      count++;
    }
    int choose = get.compare(size);
    count = 0;
    String user = "";
    for (java.util.Map.Entry<String, String> g : users.entrySet()) {
      if (count == choose) {
        user = g.getKey();
      }
      count++;
    }
    return user;
  }


  /**
  * print out the users.
  */
  public void printUsers(Map<String, String> users) {
    System.err.println("\nAll Users: \n");
    int count = 1; 
    for (Entry<String, String> g : users.entrySet()) {
      System.out.println(count + ". " + g.getKey());
      count++;
    }
  }    
}
