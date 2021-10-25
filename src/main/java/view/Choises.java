package view;


/**
* class having enums used in program.
*/
public class Choises {

  /**
  * actions to be made in the program by inloged user.
  */
  public enum InLoged {
    None, Members, Boats, Users, LogOut, Search
  }

  /**
  * enum of ouloged user.
  */
  public enum Lite {
    Compact, Verbose, None, Back, Search
  }

  /**
  * enum of first choise in program.
  */
  public enum First {
    LogIn, UseLite, Exit, None
  }

  /**
  * enum of what to do with users.
  */
  public enum Users {
    AddUser, DeleteUser, ViewUsers,
    Back, None
  }

  /**
  * enum of what to do with Boats.
  */
  public enum Boats {
    RegisterBoat, ChangeBoat, DeleteBoat, Back, None
  }


  /**
  * enum of what to do with members.
  */
  public enum Members {
    AddMember, ChangeMember, Compact, Verbose,
    DeleteMember,  Back, None
  }

  /**
  * enum of what search behaivour it would be.
  */
  public enum Search {
    Name, Age, Month, Year, Boat, Back, None
  }

}
