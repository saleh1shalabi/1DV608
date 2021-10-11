package controller;

import model.domain.MemberManager;
import model.presistence.HardCodeImplemets;


/**
* controler to add members when program start from hard coded clases.
*/
public class HardCodeController extends DataController {

  HardCodeController(MemberManager memMan) {
    super(memMan);
    super.hc = new HardCodeImplemets();

  }
  
}