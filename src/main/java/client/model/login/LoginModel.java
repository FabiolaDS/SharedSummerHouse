package client.model.login;

import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

/**
 * Interface for the loginModel. Sends login credentials to the client.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public interface LoginModel extends PropertyChangeSubject
{
  /**
   * Sends the login credentials to the client.
   * @param username user's username (cpr)
   * @param password user's password
   * @param userType user's type
   */
  void login(String username, String password, String userType);
  /**
   * Gets the logged in user if the login validation received from the server is
   * valid
   * @return returns the currently logged in user.
   */
  User getCurrentUser();

}
