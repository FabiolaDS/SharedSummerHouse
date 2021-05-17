package client.model.login;

import client.network.Client;
import shared.transferobjects.EventType;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginModelManager implements LoginModel
{
  private Client client;
  private User loggedInUser;
  private PropertyChangeSupport support;

  public LoginModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
   // client.addPropertyChangeListener(EventType.LOGIN.toString(), this::onLoginResult);
  }

  private void onLoginResult(PropertyChangeEvent propertyChangeEvent)
  {
    String loginResult = (String) propertyChangeEvent.getNewValue();
    if (!"OK".equals(loginResult)) {
      loggedInUser = null;
    }
    support.firePropertyChange(EventType.LOGIN.toString(), null, loginResult);
  }

  @Override public void login(String username, String password)
  {
    loggedInUser = new User(username, password);
    client.login(loggedInUser);
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
