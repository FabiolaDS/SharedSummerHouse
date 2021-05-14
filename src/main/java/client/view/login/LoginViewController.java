package client.view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController
{
  @FXML private Button loginButton;
  @FXML private TextField usernameTextField;
  @FXML private TextField passwordTextField;
  @FXML private Label loginResultLabel;
  private LoginViewModel loginViewModel;

  public void init(LoginViewModel loginViewModel)
  {
    this.loginViewModel = loginViewModel;
    usernameTextField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
    passwordTextField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
    loginResultLabel.textProperty().bindBidirectional(loginViewModel.loginResultProperty());
    loginButton.disableProperty().bind(loginViewModel.loginButtonDisabledProperty());
    // When something changes in the loginResultLabel, the system reacts to it below
    loginViewModel.loginResultProperty().addListener((ObservableValue, oldValue, newValue) -> onLoginResult(newValue));
  }

  private void onLoginResult(String result)
  {
    if ("OK".equals(result)) {
      // TODO: open main view
    }
  }

  public void onChangePassword(ActionEvent actionEvent)
  {
  }

  public void onLoginButton(ActionEvent actionEvent)
  {
    loginViewModel.login();
  }

  public void onExitButton(ActionEvent actionEvent)
  {
  }


}
