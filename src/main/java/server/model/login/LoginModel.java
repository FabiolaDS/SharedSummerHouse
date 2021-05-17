package server.model.login;

import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;

public interface LoginModel extends PropertyChangeSubject
{
  String validateUser(User user) throws SQLException;
}
