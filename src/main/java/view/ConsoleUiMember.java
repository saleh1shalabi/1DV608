package view;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberManager;
import view.Choises.Members;

/**
* This is the console class for members.
*/
public class ConsoleUiMember {
 
  private ConsoleUi console;
  private Getter get = new Getter();


  public ConsoleUiMember(ConsoleUi console) {
    this.console = console;
  }
  /**
  * shows the main menu.
  */
  private void showMenuMembers() {
    System.out.println("1. Add a member");
    System.out.println("2. Change a member information");
    System.out.println("3. View Verbose list");
    System.out.println("4. View Compact list");
    System.out.println("5. Delete a member");
    System.out.println("0. Back");
  }


  /**
  * Gets the chooes of the main menu.
  */
  public Members membersChoice() {
    int nr = 10;
    Choises.Members g = null;
    while (g == Members.None || g == null) {
      showMenuMembers();
      nr = get.intGetter();
      switch (nr) {
        case 1:
          g =  Members.AddMember;
          break;
        case 2:
          g = Members.ChangeMember;
          break;
        case 3: 
          g = Members.Verbose;
          break;
        case 4: 
          g = Members.Compact;
          break;
        case 5: 
          g = Members.DeleteMember;
          break;
        case 0:
          g = Members.Back;
          break;
        default:
          console.wronger();
          g = Members.None;
          break;
      }
      break;
    }
    return g;
  }
  
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
    System.out.println("\n1. Name");
    System.out.println("2. Personal ID\n");
    int chooes = get.compare(2);
    System.out.println(chooes + 1);
    return chooes + 1;
  }

  /**
  * Responsible for viewing the first name form.
  */
  public String firstNameGetter() {
    System.out.println("\nEnter The new Members first name: \n");
    String firstName = get.stringGetter();
    return firstName;
  }

  /**
  * Responsible for viewing the last name form.
  */
  public String lastNameGetter() {
    System.out.println("\nEnter The new Members last name: \n");
    String lastName = get.stringGetter();
    return " " + lastName;
  }

  /**
  * Responsible for viewing the personal id form.
  */
  public Integer personalIdGetter() {
    
    System.out.println("\nYear of Berth: (YYYY)");
    int year = get.intGetter();
    
    while (String.valueOf(year).length() != 4 || year < 1900 || year > 2021) {
      console.wronger();
      System.out.println("\nThe Correct Format is (YYYY)");
      year = get.intGetter();
    }
    System.out.println("\nMonth of Berth:");
    int month = get.intGetter();
    while (month <= 0 || month > 12) {
      console.wronger();
      month = get.intGetter();
    }
    System.out.println("\nDay of Berth: (DD)");
    int day = get.intGetter();
    if (month == 2) {
      while (day <= 0 || day > 29) {
        console.wronger();
        day = get.intGetter();
      }
    } else {
      while (day <= 0 || day > 31) {
        console.wronger();
        day = get.intGetter();
      }
    }
    String pers = String.valueOf(year);
    if (String.valueOf(month).length() == 1) {
      pers += "0" + String.valueOf(month);
    } else {
      pers += String.valueOf(month);
    }
    if (String.valueOf(day).length() == 1) {
      pers += "0" + String.valueOf(day);
    } else {
      pers += String.valueOf(day);
    }
    return Integer.parseInt(pers);
  }

  public void chooseMessage() {
    System.out.println("\nChoose a member: \n");

  }

  /**
  * Responsible for viewing a specific members information.
  */
  public void showSpecMemberInfo(Member member) {
    // Här ska ett objekt av en medlem skickas in och sedan ska metoder som getName osv anropas härifrån
    System.out.println("\nMember Info!\n");
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
      if (String.valueOf(count).length() == 1) {
      System.out.println(count + "       ||" + name + "||    " + memId + "||          " + memm.ownedBoats());
      }
      else{
        System.out.println(count + "      ||" + name + "||    " + memId + "||          " + memm.ownedBoats());
      }
      count++;
    }
    System.out.println();
    for (int c = 0; c < 69; c++) {
      System.out.print("=");
    }
    System.out.println("\n");

  }

  public void addBoat(String mem) {
    System.out.println("\nAdd Boats to " + mem + " ? (Y/N)");
  }

}