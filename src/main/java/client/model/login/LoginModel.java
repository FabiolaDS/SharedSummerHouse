package client.model.login;

import shared.util.PropertyChangeSubject;

public interface LoginModel extends PropertyChangeSubject
{
  void login(String username, String password, String userType);

}
