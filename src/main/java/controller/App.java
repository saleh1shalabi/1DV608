package controller;

import model.presistence.DbLoader;

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
