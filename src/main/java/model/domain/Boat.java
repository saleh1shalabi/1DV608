package model.domain;

/**
* boat class.
*/
public class Boat {
  
  private Integer length;
  private String boatType;

  /**
  * creating boat objects.
  */
  public Boat(String boatType, int length) {
    this.length = length;
    this.boatType = boatType;
  }  


  public Integer getLength() {
    return length;
  }
  
  public void setLength(int length) {
    this.length = length;
  }


  public String getType() {
    return boatType;
  }
  
  public void setType(String boatType) {
    this.boatType = boatType;
  }

}
  