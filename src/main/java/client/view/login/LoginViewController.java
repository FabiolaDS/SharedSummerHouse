package client.view.login;

import client.core.viewhandler.LoginViewHandler;
import client.core.viewhandler.SAViewHandler;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController implements ViewController
{
  @FXML private Button loginButton;
  @FXML private TextField usernameTextField;
  @FXML private TextField passwordTextField;
  @FXML private Label loginResultLabel;
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;

  /*public void init(LoginViewModel loginViewModel) throws IOException
  {
    this.loginViewModel = loginViewModel;
    usernameTextField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
    passwordTextField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
    loginResultLabel.textProperty().bindBidirectional(loginViewModel.loginResultProperty());
    loginButton.disableProperty().bind(loginViewModel.loginButtonDisabledProperty());
    // When something changes in the loginResultLabel, the system reacts to it below
    loginViewModel.loginResultProperty().addListener((ObservableValue, oldValue, newValue) -> onLoginResult(newValue));
  }*/

  @Override public void init() throws IOException
  {
    this.viewHandler = LoginViewHandler.getInstance();
    this.loginViewModel = ViewModelFactory.getInstance().getLoginViewModel();
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

  public void onLoginButton(ActionEvent actionEvent) throws IOException {
    //if user = SAdmin do:
    SAViewHandler.getInstance().start(LoginViewHandler.getInstance().getStage()); //this should be included in onLoginResult()
   // loginViewModel.login();
  }

  public void onExitButton(ActionEvent actionEvent)
  {
  }


}
