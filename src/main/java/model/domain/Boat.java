package model.domain;

/**
* Responsible for staring the application.
*/
public class Boat {
  private Integer length;
  private String boatType;
  //private Getter get = new Getter();
  
  

  /**
  * Responsible for staring the application.
  */
  public Boat(String boatType, int length) {
    this.length = length;
    this.boatType = boatType;
  }  

  /**
  * Responsible for staring the application.
  */
  public Integer getLength() {
    return length;
  }

  /**
  * Responsible for staring the application.
  */
  public String getType() {
    return boatType;
  }

}
  