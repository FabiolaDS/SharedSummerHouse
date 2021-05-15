package shared.transferobjects;

import java.io.Serializable;

/**
 * This class might not be useful becuase we are using RMI
 */
public class User implements Serializable
{
  private String username, password;

  public User(String username, String password)
  {
    this.username = username;
    this.password = password;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  @Override public String toString()
  {
    return "User{" + "username='" + username + '\'' + ", password='" + password
        + '\'' + '}';
  }
}
