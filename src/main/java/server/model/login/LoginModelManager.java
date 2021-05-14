package server.model.login;

import server.dataaccess.UserHome;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginModelManager implements LoginModel
{
  // I only use the interface, this way if I want to exchange the InMemoryAccess
  // with a database access class I can do it without changing this code
  private UserHome userHome;
  private PropertyChangeSupport support;

  public LoginModelManager(UserHome userHome)
  {
    this.userHome = userHome;
    support = new PropertyChangeSupport(this);
  }

  @Override public String validateUser(User user)
  {
    return userHome.validateUser(user);
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
