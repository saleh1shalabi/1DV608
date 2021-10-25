package view;

import java.util.Map;
import java.util.Map.Entry;
import model.domain.UserManager;
import view.Choises.InLoged;
import view.Choises.Lite;
import view.Choises.Search;
import view.Choises.Users;

public class ConsoleUiUser {

  private Getter get = new Getter();

  private void inlogedMenu() {
    System.out.println("\n1. Members");
    System.out.println("2. Boats");
    System.out.println("3. Search");
    System.out.println("4. Users");
    System.out.println("0. Log Out\n");
  }

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

  private void liteMenu() {
    System.out.println("\n1. View Verbose list");
    System.out.println("2. View Compact list");
    System.out.println("3. Search");
    System.out.println("0. Back\n");
  }

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
          System.out.println("Wrong Value!");
          g = Lite.None;
          break;
      }
      break;
    }
    return g;
  } 
  
  private void UsersMenu() {
    System.out.println("\n1. Add new User");
    System.out.println("2. Delete a User");
    System.out.println("3. View Users");
    System.out.println("0. Back\n");
  }
  
  public Users usersChoice() {
    int nr = 10;
    Users g = null;
    while (g == Users.None || g == null) {
      UsersMenu();
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


  private void searchMenu() {
    System.out.println("\n1. Search by Name");
    System.out.println("2. Search by Age");
    System.out.println("3. Search by month of berth");
    System.out.println("4. Search by year of berth");
    System.out.println("5. Search for members with a special boatType");
    System.out.println("0. Back\n");
  }


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
        case 0:
          g = Search.Back;
          break;
        default:
          System.out.println("Wrong Value!");
          g = Search.None;
          break;
      }
      break;
    }
    return g;
  }

  public String chooseUser(UserManager userMan) {
    
    System.out.println("\nChoose the user: ");
    int count = 1; 
    for (java.util.Map.Entry<String, String> g : userMan.getUsers().entrySet()) {
      System.out.println(count + ". " + g.getKey());
      count++;
    }
    int choose = get.compare(userMan.getUsers().size());
    count = 0;
    String user = "";
    for (java.util.Map.Entry<String, String> g : userMan.getUsers().entrySet()) {
      if (count == choose) {
        user = g.getKey();
      }
      count++;
    }
    return user;
  }

  public void printUsers(Map<String, String> users) {
    System.err.println("\nAll Users: \n");
    int count = 1; 
    for (Entry<String, String> g : users.entrySet()) {
      System.out.println(count + ". " + g.getKey());
      count++;
    }
  }    
}
