package controller;

import model.domain.MemberManager;
import model.presistence.FileLoader;
import model.presistence.PersistenceInterface;

public class FileController extends DataController {
  public PersistenceInterface hc = new FileLoader();

  FileController(MemberManager memMan) {
    super(memMan);
    super.hc = hc;
  }
  
}
