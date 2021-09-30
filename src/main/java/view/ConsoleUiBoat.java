package view;

/**
* Responsible for staring the application.
*/
public class ConsoleUiBoat {

  private Getter get = new Getter();

  /**
  * Responsible for staring the application.
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
    int choose = get.compare(5);
    return boatTypesStrings[choose];   
  }

  /**
  * Responsible for staring the application.
  */
  public Integer lengthGetter() {
    System.out.println("Enter length of boat: ");
    Integer length = get.intGetter();
    return length;
  }
}