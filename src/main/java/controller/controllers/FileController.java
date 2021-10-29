package controller.controllers;

import model.presistence.FileLoader;


/**
* to add data from files.
*/
public class FileController extends DataController {


  FileController() {
    super.hc = new FileLoader();
  }
  
}
