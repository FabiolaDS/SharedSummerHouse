package client.model.login;

import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

public interface LoginModel extends PropertyChangeSubject
{
  void login(String username, String password, String userType);

  User getCurrentUser();

}
