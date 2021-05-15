package server.dataaccess;

import shared.transferobjects.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has to be substituted by access to the database
 */
public class InMemoryUsers implements UserHome
{
  private List<User> users;

  public InMemoryUsers()
  {
    this.users = new ArrayList<>();
    users.add(new User("Michael", "Jordan"));
  }

  @Override public String validateUser(User user)
  {
    String result = "";
    boolean userFound = false;
    for (User u : users)
    {
      if (u.getUsername().equals(user.getUsername()))
      {
        if (u.getPassword().equals(user.getPassword())) {
          result = "OK";
        } else {
          result = "Incorrect password";
        }
        userFound = true;
      }
      if (!userFound)
      {
        result = "User not found";
      }
    }
    return result;
  }
}