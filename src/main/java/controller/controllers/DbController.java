package controller.controllers;

import model.presistence.DbLoader;

/**
* to add data from DB.
*/
public class DbController extends DataController {

  public DbController() {
    super.hc = new DbLoader();
  }
  
}
