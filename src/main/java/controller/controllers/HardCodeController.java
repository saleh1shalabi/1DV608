package controller.controllers;

import model.presistence.HardCodeImplemets;


/**
* controler to add members when program start from hard coded clases.
*/
public class HardCodeController extends DataController {

  HardCodeController() {
    super.hc = new HardCodeImplemets();
  }
  
}