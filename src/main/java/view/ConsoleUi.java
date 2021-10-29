package view;

import java.util.Map;
import java.util.Map.Entry;
import model.domain.Member;
import view.Choises.Boats;
import view.Choises.First;
import view.Choises.InLoged;
import view.Choises.Lite;
import view.Choises.Members;
import view.Choises.Search;
import view.Choises.Users;


/**
* Class to be an interface for consols.
*/
public class ConsoleUi {

  private ConsoleMain console = new ConsoleMain(); 
  private ConsoleUiBoat consoleBoat = new ConsoleUiBoat();
  private ConsoleUiMember consoleMem = new ConsoleUiMember();
  private ConsoleUiUser consoleUser = new ConsoleUiUser();



  


  public Boats boatsChoise() {
    return consoleBoat.boatsChoise();
  }


  public Members membersChoice() {
    return consoleMem.membersChoice();
  }


  public InLoged inlogedChoise() {
    return consoleUser.inlogedChoise();
  }


  public Lite liteChoise() {
    return console.liteChoise();
  }


  public Users usersChoice() {
    return consoleUser.usersChoice();
  }


  public String chooseUser(Map<String, String> users, int size) {
    return consoleUser.chooseUser(users, size);
  }


  public void printUsers(Map<String, String> users) {
    consoleUser.printUsers(users);
  }

  public Search searchChoies() {
    return console.searchChoies();
  }


  public int getYear() {
    return consoleMem.getYear();
  }


  public int getMonth() {
    return consoleMem.getMonth();
  }


  public int getAge() {
    return consoleMem.getAge();
  }


  public String getBoatType() {
    return consoleBoat.chooseBoatType();
  }

  public int chooseMember(Iterable<Member> members, int size) {
    return consoleMem.chooseMember(members, size);
  }

  public String firstNameGetter() {
    return consoleMem.firstNameGetter();
  }

  public String lastNameGetter() {
    return consoleMem.lastNameGetter();
  }

  public Integer personalIdGetter() {
    return consoleMem.personalIdGetter();
  }

  public void addBoat(String name) {
    consoleMem.addBoat(name);
  }

  public void showSpecMemberInfo(Member mem) {
    consoleMem.showSpecMemberInfo(mem);
  }

  public int whatToChangeMember() {
    return consoleMem.whatToChange();
  }

  public void showVerboseList(Iterable<Member> iterable) {
    consoleMem.showVerboseList(iterable);
  }

  public void showCompactList(Iterable<Member> iterable) {
    consoleMem.showCompactList(iterable);
  }


  public void wlecomeMsg() {
    console.wlecomeMsg();
  }


  public First firstChoise() {
    return console.firstChoise();
  }


  public Entry<String, String> userInfo() {
    return consoleUser.userInfo();
  }


  public void loginMsg() {
    console.loginMsg();
  }


  public void wronger() {
    console.wronger();
  }


  public void shutDownApp() {
    console.shutDownApp();
  }


  public void sureMsgChange() {
    console.sureMsgChange();
  }


  public boolean checker() {
    return console.checker();
  }


  public void sureMsgDelete(String name) {
    console.sureMsgDelete(name);
  }


  public String getString() {
    return console.getString();
  }


  public void noMatch() {
    console.noMatch();
  }


  public void cantRemove() {
    console.cantRemove();
  }


  public Integer lengthGetter() {
    return consoleBoat.lengthGetter();
  }


  public void chooseMessage() {
    consoleBoat.chooseMessage();
  }


  public int chooseBoat(Member mem) {
    return consoleBoat.chooseBoat(mem);
  }
  
  public int whatToChangeBoat() {
    return consoleBoat.whatToChange();
  }

}