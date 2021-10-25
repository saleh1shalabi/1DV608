package model.domain;

import java.util.HashMap;
import java.util.Map;

/**
* manager of users.
*/
public class UserManager {

  private Map<String, String> users = new HashMap<>();

  public Map<String, String> getUsers() {
    Map<String, String> toRet = new HashMap<>(users);
    return toRet;
  }

  public void removeUser(String user) {
    users.remove(user);
  }

  public void addUser(String username, String password) {
    users.put(username, password);
  }

}
