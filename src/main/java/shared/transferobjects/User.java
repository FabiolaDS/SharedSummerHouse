package shared.transferobjects;

import java.io.Serializable;

public class User implements Serializable
{
  private String username, password, userType;

  public User(String username, String password, String userType)
  {
    this.username = username;
    this.password = password;
    this.userType = userType;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public String getUserType()
  {
    return userType;
  }

  @Override public String toString()
  {
    return "User{" + "username='" + username + '\'' + ", password='" + password
        + '\'' + '}';
  }
}
