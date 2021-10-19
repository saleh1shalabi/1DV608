package controller;

import model.domain.MemberManager;
import model.domain.UserManager;
import model.presistence.FileLoader;


/**
* to add data from files.
*/
public class FileController extends DataController {


  FileController(MemberManager memMan, UserManager userMan) {
    super(memMan, userMan);
    super.hc = new FileLoader();
  }
  
}
