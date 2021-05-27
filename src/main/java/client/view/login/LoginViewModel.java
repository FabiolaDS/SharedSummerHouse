package client.view.login;

import client.model.login.LoginModel;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;

/**
 * Receives login credentials from the login controller and sends validation
 * results from the server.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public class LoginViewModel
{
  private StringProperty username, password, loginResult;
  private LoginModel loginModel;
  private BooleanProperty loginButtonDisabled;

  /**
   * 1-argument constructor setting the loginModel and login credentials.
   * Listens to the loginModel and calls the onLoginResult method. Listens also
   * to changes on the username field and calls the onUserNameChange method.
   * @param loginModel login model on the client side.
   */
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

  /**
   * Disables the login button if the user has not entered a username.
   * @param newValue value received from the username listener
   */
  private void onUserNameChange(String newValue)
  {
    boolean disabled = (newValue == null || newValue.equals(""));
    loginButtonDisabled.set(disabled);
  }

  /**
   * Sets the loginResult field to a new value received from the model.
   * The method is trying to modify a javafx property and it is being called
   * by a non javafx thread. The javafx thread is created in the RunLogin
   * with the Application class and is allowed to modify javafx elements.
   * But here the thread comes from listener pattern. So, we call the method
   * with a non javafx thread and we "ask" the javafx thread to call the
   * same method whenever possible.
   * @param propertyChangeEvent
   */
  private void onLoginResult(PropertyChangeEvent propertyChangeEvent)
  {
    String result = (String) propertyChangeEvent.getNewValue();
    Platform.runLater(()-> {
      loginResult.set(result);
    });
  }

  /**
   * Sends the user credentials to the model.
   * @param userType type of user (Tenant, System Admin or Regional Admin)
   */
  public void login(String userType)
  {
    loginModel.login(username.get(), password.get(), userType);
  }

  /**
   * Gets the password StringProperty.
   * @return the password StringProperty.
   */
  public StringProperty passwordProperty()
  {
    return password;
  }

  /**
   * Gets the username StringProperty.
   * @return the username StringProperty.
   */
  public StringProperty usernameProperty()
  {
    return username;
  }

  /**
   * Gets the login result StringProperty.
   * @return the login result StringProperty.
   */
  public StringProperty loginResultProperty()
  {
    return loginResult;
  }

  /**
   * Get the login's button disabled BooleanProperty.
   * @return the login's button disabled BooleanProperty.
   */
  public BooleanProperty loginButtonDisabledProperty() {
    return loginButtonDisabled;
  }
}
