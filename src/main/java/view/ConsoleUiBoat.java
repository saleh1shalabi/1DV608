package view;

import model.domain.Member;
import model.domain.MemberManager;

public class ConsoleUiBoat {

  private Getter get = new Getter();
  
  public int chooseMember(MemberManager memMan) {
    int count = 1; 
    for (Member mem : memMan.getMembers()){
      System.out.println(count + ". " + mem.getName());
      count++;
    }
    int choose = get.compare(memMan.getMembers().size());
    return choose;

  }

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

  public Integer lengthGetter(){
    System.out.println("Enter length of boat: ");
    Integer length = get.intGetter();
    return length;
  }
}