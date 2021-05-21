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
      // TODO: If the validation was successful, we can get the userType from the RadioButton
      /* This way
      if (selectedUserType.equals(...) // Create a field for selectedUserType that is assigned when the login button is pressed
        { open whatever view...}
       */
    }
  }

  public void onChangePassword(ActionEvent actionEvent)
  {
  }

  public void onLoginButton(ActionEvent actionEvent) throws IOException {
    //if user = SAdmin do:
    SAViewHandler.getInstance().start(LoginViewHandler.getInstance().getStage()); //this should be included in onLoginResult()
   // loginViewModel.login();

    // With User instead of Tenant, RegionalAdmin and SystemAdmin
    // if(user.getType().equals("tenant") {
    // } else if(user.getType().equals("reginal_admin")) {
    // } else { --> has to be system admin
    // }
   /// RAViewHandler.getInstance().start(LoginViewHandler.getInstance().getStage());
    /* TODO: We can include the logic to chose a view in the onLoginResult
     */
    RadioButton selectedRadionButton = (RadioButton) userType.getSelectedToggle();
    String toggleGroupValue = selectedRadionButton.getText();
    System.out.println(toggleGroupValue);

    loginViewModel.login(toggleGroupValue);
  }

  public void onExitButton(ActionEvent actionEvent)
  {
  }


}
