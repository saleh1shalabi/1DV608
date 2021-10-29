package controller.controllers;

import model.presistence.DBLoader;

/**
* to add data from DB.
*/
public class DBController extends DataController {

  public DBController() {
    super.hc = new DBLoader();
  }
  
}
