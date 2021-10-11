package controller;

import model.domain.MemberManager;

import model.presistence.HardCodeImplemets;
import model.presistence.PersistenceInterface;

/**
* controler to add members when program start from hard coded clases.
*/
public class HardCodeController extends DataController {
  public PersistenceInterface hc = new HardCodeImplemets();

  HardCodeController(MemberManager memMan) {
    super(memMan);
    super.hc = hc;

  }
  
}