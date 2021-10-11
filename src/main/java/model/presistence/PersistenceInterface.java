package model.presistence;

import java.util.ArrayList;
import java.util.Map;
import model.domain.Boat;
import model.domain.Member;


/**
* interface preperd to the load up.
*/
public interface PersistenceInterface {

  public String[] getNames();

  public int[] getPersonalIds();

  public String[] getMemberIds();

  public Map<String, ArrayList<Boat>> getBoats();

  public void saveBoats(ArrayList<Member> members);

  public void saveMembers(ArrayList<Member> members);

}
