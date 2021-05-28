package client.model.login;

import client.network.Client;
import shared.transferobjects.EventType;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Class implementing the LoginModel. Sends login credentials to the client and
 * receives login validation from the server.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */

public class LoginModelManager implements LoginModel
{
    private Client client;
    private User loggedInUser;
    private PropertyChangeSupport support;

    /**
     * 1-argument constructor setting the client, the PropertyChangSupport and
     * listening to the client calling onLoginResult.
     * @param client the client using the system
     */
    public LoginModelManager(Client client)
    {
        this.client = client;
        support = new PropertyChangeSupport(this);
        client.addPropertyChangeListener(EventType.LOGIN.toString(), this::onLoginResult);

    }

    /**
     * If the login validation received from the server is not successful, then
     * the logged in user is set to null. The LOGIN property is fired with the
     * validation result from the server.
     * @param propertyChangeEvent
     */
    private void onLoginResult(PropertyChangeEvent propertyChangeEvent)
    {
        String loginResult = (String) propertyChangeEvent.getNewValue();
        if (!"OK".equals(loginResult)) {
            loggedInUser = null;
        }
        support.firePropertyChange(EventType.LOGIN.toString(), null, loginResult);
    }


    @Override
    public void login(String username, String password, String userType)
    {
        loggedInUser = new User(username, password, userType);
        client.login(loggedInUser);
    }

    @Override
    public User getCurrentUser()
    {
        return loggedInUser;
    }

    @Override
    public void addPropertyChangeListener(String name,
                                          PropertyChangeListener listener)
    {
        if (name == null) {
            addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(name, listener);
        }
    }

    @Override
    public void addPropertyChangeListener(
            PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name,
                                             PropertyChangeListener listener)
    {
        if (name == null) {
            removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(listener);
        }
    }

    @Override
    public void removePropertyChangeListener(
            PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }
}
