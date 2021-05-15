package client.view.login;

import client.model.login.LoginModel;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;

public class LoginViewModel
{
  private StringProperty username, password, loginResult;
  private LoginModel loginModel;
  private BooleanProperty loginButtonDisabled;

  public LoginViewModel(LoginModel loginModel)
  {
    this.loginModel = loginModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    loginResult = new SimpleStringProperty();
    loginButtonDisabled = new SimpleBooleanProperty(true);
    loginModel.addPropertyChangeListener(EventType.LOGIN.toString(), this::onLoginResult);
    username.addListener(((observableValue, oldValue, newValue) -> onUserNameChange(newValue)));
  }

  private void onUserNameChange(String newValue)
  {
    boolean disabled = (newValue == null || newValue.equals(""));
    loginButtonDisabled.set(disabled);
  }

  private void onLoginResult(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String) propertyChangeEvent.getNewValue();
    // This method is trying to modify a javafx property and it is being called
    // by a non javafx thread. The javafx thread is created in the RunLogin
    // with the Application class and is allowed to modify javafx elements.
    // But here the thread comes from listener pattern. So, we call the method
    // with a non javafx thread and we "ask" the javafx thread to call the
    // same method whenever possible.
    Platform.runLater(()-> {
      loginResult.set(result);
    });
  }

  public void login()
  {
    loginModel.login(username.get(), password.get());
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty loginResultProperty()
  {
    return loginResult;
  }

  public BooleanProperty loginButtonDisabledProperty() {
    return loginButtonDisabled;
  }
}
