package view;

import model.domain.Boat;
import model.domain.Member;
import view.Choises.Members;

/**
* This is the console class for members.
*/
public class ConsoleUiMember {
 
  
  private Getter get = new Getter();

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
          System.out.println("Wroung Value!");
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
  public int chooseMember(Iterable<Member> members, int size) {
    chooseMessage();
    int count = 1; 
    for (Member mem : members) {
      System.out.println(count + ". " + mem.getName());
      count++;
    }
    int choose = get.compare(size);
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
  * gets the year of the berth.
  */
  public int getYear() {
    System.out.println("\nYear of Berth: (YYYY)");
    int year = get.intGetter();
    
    while (String.valueOf(year).length() != 4 || year < 1900 || year > 2021) {
      System.out.println("Wroung Value!");
      System.out.println("\nThe Correct Format is (YYYY)");
      year = get.intGetter();
    }
    return year;
  }

  /**
  * gets the month of the berth.
  */
  public int getMonth() {
    System.out.println("\nMonth of Berth:");
    int month = get.intGetter();
    while (month <= 0 || month > 12) {
      System.out.println("Wroung Value!");
      month = get.intGetter();
    }
    return month;

  }


  /**
  * gets the day of the berth.
  */
  public int getDay(int month) {
    System.out.println("\nDay of Berth: (DD)");
    int day = get.intGetter();
    if (month == 2) {
      while (day <= 0 || day > 29) {
        System.out.println("Wroung Value!");
        day = get.intGetter();
      }
    } else {
      while (day <= 0 || day > 31) {
        System.out.println("Wroung Value!");
        day = get.intGetter();
      }
    }
    return day;
  }

  /**
  * gets the age to search for.
  */
  public int getAge() {
    System.out.println("\nAge of Member:");
    int age = get.intGetter();
    while (age <= 0 || age > 100) {
      System.out.println("Wroung Value!");
      age = get.intGetter();
    }
    return age;
  }

  /**
  * Responsible for viewing the personal id form.
  */
  public Integer personalIdGetter() {
    int year = getYear();
    int month = getMonth();
    
    int day = getDay(month);
    
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
    System.out.println("\nMember Info!\n");
    memInfo(member);
  }
  
  /**
  * Responsible for viewing the verbose list.
  */
  public void showVerboseList(Iterable<Member> iterable) {
    System.out.println("\n------VERBOSE LIST------\n");
    int count = 1;
    for (Member memm : iterable) {
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
  public void showCompactList(Iterable<Member> iterable) {
    System.out.println("\n-----COMPACT LIST------\n");
    System.out.println("Member  ||      Name        ||     Member ID    ||   Number Of Boats\n");
    int count = 1;
    for (model.domain.Member memm : iterable) {
      String name = memm.getName();
      String memId = "   " + memm.getMemberId() + "     ";
      while (name.length() < 18) {
        name = " " + name;
        if (name.length() < 18) {
          name += " "; 
        }
      }
      if (String.valueOf(count).length() == 1) {
        System.out.println(count + "       ||" + name + "||    " + memId 
            + "||          " + memm.ownedBoats());
      } else {
        System.out.println(count + "      ||" + name + "||    " + memId 
            + "||          " + memm.ownedBoats());
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