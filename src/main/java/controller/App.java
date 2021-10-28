package controller;

import model.presistence.DBLoader;

/**
 * Responsible for staring the application.
 */
public class App {

  /**
   * Application starting point.
   */
  public static void main(String[] args) {
    BoatClub a = new BoatClub();
    // DBLoade c = new DBLoade();
    
    a.startApp();
  }
  
}
