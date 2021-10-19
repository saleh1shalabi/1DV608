package controller;

import model.domain.MemberManager;
import model.domain.UserManager;
import model.presistence.HardCodeImplemets;


/**
* controler to add members when program start from hard coded clases.
*/
public class HardCodeController extends DataController {

  HardCodeController(MemberManager memMan, UserManager userMan) {
    super(memMan, userMan);
    super.hc = new HardCodeImplemets();

  }
  
}