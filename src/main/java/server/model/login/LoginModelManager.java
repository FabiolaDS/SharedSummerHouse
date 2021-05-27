package server.model.login;

import server.dataaccess.UserDAO;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

/**
 * Implements the LoginModel interface. Validates the login credentials received
 * from the client and sends the result of the validation to the client.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public class LoginModelManager implements LoginModel
{
  private UserDAO userDAO;
  private PropertyChangeSupport support;

  /**
   * 1-argument constructor setting the userDAO and the PropertyChangeSupport.
   * @param userDAO user data access object
   */
  public LoginModelManager(UserDAO userDAO)
  {
    this.userDAO = userDAO;
    support = new PropertyChangeSupport(this);
  }


  @Override public String validateUser(User user) throws SQLException
  {
    User foundUser = userDAO.validateUser(user);
    String result = "User type, username or password are incorrect";
    boolean userFound = false;

    if (foundUser != null)
    {
      if (foundUser.getUsername().equals(user.getUsername()))
      {
        if (foundUser.getPassword().equals(user.getPassword()))
        {
          result = "OK";
        }
        else
        {
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

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null) {
      addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      removePropertyChangeListener(listener);
    } else {
      support.removePropertyChangeListener(listener);
    }
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
