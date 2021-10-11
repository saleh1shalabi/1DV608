package view;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;

/**
* This is the console class for members.
*/
public class ConsoleUiMember {
 
  private ConsoleUi console = new ConsoleUi();
  private Getter get = new Getter();

  
  /**
  * Responsible for viewing the members for the user so they can pick a member.
  */
  public int chooseMember(MemberManager memMan) {
    chooseMessage();
    int count = 1; 
    for (Member mem : memMan.getMembers()) {
      System.out.println(count + ". " + mem.getName());
      count++;
    }
    int choose = get.compare(memMan.getMembers().size());
    return choose;

  }

  /**
  * shows and gets what to change.
  */
  public int whatToChange() {
    System.out.println("1. Name");
    System.out.println("2. Personal ID");
    int chooes = get.compare(2);
    System.out.println(chooes + 1);
    return chooes + 1;
  }

  /**
  * Responsible for viewing the first name form.
  */
  public String firstNameGetter() {
    System.out.println("Enter The new Members first name: ");
    String firstName = get.stringGetter();
    return firstName;
  }

  /**
  * Responsible for viewing the last name form.
  */
  public String lastNameGetter() {
    System.out.println("Enter The new Members last name: ");
    String lastName = get.stringGetter();
    return lastName;
  }

  /**
  * Responsible for viewing the personal id form.
  */
  public Integer personalIdGetter() {
    System.out.println("Enter the members personal number: as (YYYYMMDD)");
    Integer pers = get.intGetter();
    while (String.valueOf(pers).length() != 8) {
      console.wronger();
      System.out.println(" The Correct Format is (YYYYMMDD)");
      pers = get.intGetter();
    }
    return pers;
  }

  public void chooseMessage() {
    System.out.println("Choose a member: ");

  }

  /**
  * Responsible for viewing a specific members information.
  */
  public void showSpecMemberInfo(Member member) {
    // Här ska ett objekt av en medlem skickas in och sedan ska metoder som getName osv anropas härifrån
    System.out.println("Member Info!");
    memInfo(member);
  }
  
  /**
  * Responsible for viewing the verbose list.
  */
  public void showVerboseList(ArrayList<Member> members) {
    System.out.println("\n------VERBOSE LIST------\n");
    int count = 1;
    for (Member memm : members) {
      System.out.println("Member " + count);
      memInfo(memm);
      System.out.println("**********************************\n");
      count++;
    }
  }

  /**
  * Responsible for viewing members information and boats.
  */
  private void memInfo(Member member) {
    System.out.println("=============");
    System.out.println("Name: " + member.getName());
    System.out.println("Personal number: " + member.getPersonalId());
    System.out.println("Member id: " + member.getMemberId());
    System.out.println("Number of owned Boats: " + member.ownedBoats());

    System.out.println("\n");
    System.out.println("Boats:");
    for (Boat boat : member.getBoats()) {
      System.out.println("Type: " + boat.getType() + " || Length: " + boat.getLength());
    }
    System.out.println("======================");
  }

  /**
  * Responsible for viewing the compact list.
  */
  public void showCompactList(ArrayList<Member> members) {
    System.out.println("\n-----COMPACT LIST------\n");
    System.out.println("Member  ||      Name        ||     Member ID    ||   Number Of Boats\n");
    int count = 1;
    for (model.domain.Member memm : members) {
      String name = memm.getName();
      String memId = "   " + memm.getMemberId() + "     ";
      while (name.length() < 18) {
        name = " " + name;
        if (name.length() < 18) {
          name += " "; 
        }
      }
      System.out.println(count + "       ||" + name + "||    " + memId + "||          " + memm.ownedBoats());
      count++;
    }
    System.out.println();
    for (int c = 0; c < 69; c++) {
      System.out.print("=");
    }
    System.out.println("\n");

  }

  public void addBoat(String mem) {
    System.out.println("Add Boats to " + mem + " ? (Y/N)");
  }

}