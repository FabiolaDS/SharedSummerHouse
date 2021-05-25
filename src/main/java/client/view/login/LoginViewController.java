package client.view.login;

import client.core.viewhandler.LoginViewHandler;
import client.core.viewhandler.RAViewHandler;
import client.core.viewhandler.SAViewHandler;
import client.core.viewhandler.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginViewController implements ViewController
{
  @FXML private Button loginButton;
  @FXML private TextField usernameTextField;
  @FXML private TextField passwordTextField;
  @FXML private Label loginResultLabel;
  @FXML private ToggleGroup userType;
  private String selectedUserType;
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

      if ("Tenant".equals(selectedUserType))
        {
          // TODO: I'm not sure what view to open here.
        }
      if ("Regional Admin".equals(selectedUserType))
      {
        try
        {
          RAViewHandler.getInstance().start(LoginViewHandler.getInstance().getStage());
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
      if ("System Admin".equals(selectedUserType))
      {
        try
        {
          SAViewHandler.getInstance().start(LoginViewHandler.getInstance().getStage());
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }

    }
  }

  public void onChangePassword(ActionEvent actionEvent)
  {
  }

  public void onLoginButton(ActionEvent actionEvent) throws IOException {

    RadioButton selectedRadioButton = (RadioButton) userType.getSelectedToggle();
    selectedUserType = selectedRadioButton.getText();

    loginViewModel.login(selectedUserType);
  }

  public void onExitButton(ActionEvent actionEvent)
  {
  }


}
