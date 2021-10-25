package view;

import model.domain.Boat;
import model.domain.Member;
import view.Choises.Boats;

/**
* userinterface for boats and all its outputs.
*/
public class ConsoleUiBoat {

  private Getter get = new Getter();

  /**
  * boats menu.
  */
  private void showMenuBoats() {
    System.out.println("1. Add a Boat");
    System.out.println("2. Change a Boat");
    System.out.println("3. Delete a Boat");
    System.out.println("0. Back");
  }

  /**
  * choise of boat menu.
  */
  public Boats boatsChoise() {
    int nr = 10;
    Choises.Boats g = null;
    while (g == Boats.None || g == null) {
      showMenuBoats();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g = Boats.RegisterBoat;
          break;
        case 2:
          g = Boats.ChangeBoat;
          break;
        case 3:
          g = Boats.DeleteBoat;
          break;
        case 0:
          g = Boats.Back;
          break;
        default:
          System.out.println("Wrong Value!");
          g = Boats.None;
          break;
      }
      break;
    }
    return g;
  } 


  /**
  * shows and gets the type chosen.
  */
  public String chooseBoatType() {
    String[] boatTypesStrings = {"Sailboat", "Motorsailer", "Kayak",
        "Other"};
    int count = 1;  
    System.out.println("Choose one: ");
    for (String boatType : boatTypesStrings) {
      System.out.println(count + ". " + boatType);
      count++;
    }
    int choose = get.compare(4);
    return boatTypesStrings[choose];   
  }

  /**
  * shows and gets what to change.
  */
  public int whatToChange() {
    System.out.println("1. Change Type");
    System.out.println("2. Change length");
    int chooes = get.compare(2);
    System.out.println(chooes + 1);
    return chooes + 1;
  }

  public void chooseMessage() {
    System.out.println("Choose a boat: ");
  }

  /**
  * shows and gets the chosen boat.
  */
  public int chooseBoat(Member member) {
    int count = 1;
    for (Boat boat : member.getBoats()) {
      System.out.println(count + ". Type: " + boat.getType() + " || Length: " + boat.getLength());
      count++;
    }
    int choose = get.compare(member.getBoats().size());
    return choose;
  }

  /**
  * gets the length of a boat when created or edited.
  */
  public Integer lengthGetter() {
    System.out.println("Enter length of boat: ");
    Integer length = get.intGetter();
    return length;
  }
}