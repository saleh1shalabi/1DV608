package controller;

import model.presistence.DBLoader;

public class DBController extends DataController {

  DBController() {
    super.hc = new DBLoader();
  }
  
}
