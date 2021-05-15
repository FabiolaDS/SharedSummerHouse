package server.model.login;

import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

public interface LoginModel extends PropertyChangeSubject
{
  String validateUser(User user);
}
