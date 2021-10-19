package model.domain;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

  private Map<String,String> users = new HashMap();

  public Map<String,String> getUsers() {
    return users;
  }

  public void removeUser(String user) {
    users.remove(user);
  }

  public void addUser(String username, String password) {
    users.put(username, password);
  }
}
