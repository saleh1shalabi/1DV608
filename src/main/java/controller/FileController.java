package controller;

import model.domain.MemberManager;
import model.presistence.FileLoader;


/**
* to add data from files.
*/
public class FileController extends DataController {


  FileController(MemberManager memMan) {
    super(memMan);
    super.hc = new FileLoader();
  }
  
}
