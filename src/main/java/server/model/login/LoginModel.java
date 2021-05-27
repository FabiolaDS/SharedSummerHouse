package server.model.login;

import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;

/**
 * Interface for the LoginModel in the server.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public interface LoginModel extends PropertyChangeSubject
{
  /**
   * Validates the user credentials received from the client and returns the
   * result of the validation.
   * @param user the user requesting login
   * @return the result of the validation
   * @throws SQLException exceptions from the database
   */
  String validateUser(User user) throws SQLException;
}
