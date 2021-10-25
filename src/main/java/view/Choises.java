package view;

public class Choises {

    /**
  * actions to be made in the program.
  */
  public enum InLoged {
    None, Members, Boats, Users, LogOut, Search
  }

  public enum Lite {
    Compact, Verbose, None, Back, Search
  }

  public enum First {
    LogIn, UseLite, Exit, None
  }

  public enum Users {
    AddUser, ChangeUser, DeleteUser, ViewUsers,
    Back, None
  }

  public enum Boats {
    RegisterBoat, ChangeBoat, DeleteBoat, Back, None
  }

  public enum Members {
    AddMember, ChangeMember, Compact, Verbose,
    DeleteMember,  Back, None
  }

  public enum Search {
    Name, Age, Month, Year, Boat, Back, None
  }
  
}
