package client.view.login;



import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * A controller to control the Login view for all users. Users can select the
 * type of user, enter their username, and password.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */

public class LoginViewController
{
  @FXML private Button loginButton;
  @FXML private TextField usernameTextField;
  @FXML private TextField passwordTextField;
  @FXML private Label loginResultLabel;
  @FXML private ToggleGroup userType;
  private String selectedUserType;
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;

  public LoginViewController(ViewHandler viewHandler, LoginViewModel loginViewModel)
  {
    this.viewHandler = viewHandler;
    this.loginViewModel = loginViewModel;
  }



  /**
   * Initializes the controller. Sets the viewHandler and loginViewModel. Binds
   * the text fields and login button to the viewModel. The login button is
   * disabled until the user enters the username. Listens to the viewModel and
   * calls the onLoginResult method.
   */
   public void  initialize()
  {

    usernameTextField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
    passwordTextField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
    loginResultLabel.textProperty().bindBidirectional(loginViewModel.loginResultProperty());
    loginButton.disableProperty().bind(loginViewModel.loginButtonDisabledProperty());
    loginViewModel.loginResultProperty().addListener((ObservableValue, oldValue, newValue) -> onLoginResult(newValue));
  }

  /**
   * Called when a login result is received from the server. If the result is
   * "OK", then the appropriate view will open depending on the type of user.
   * @param result received from the server to decided if the login credentials
   *               are valid.
   */
  private void onLoginResult(String result)
  {
    if ("OK".equals(result)) {

      if ("Tenant".equals(selectedUserType))
        {
          viewHandler.openSummerHouseList();
        }
      if ("Regional Admin".equals(selectedUserType))
      {
        viewHandler.openMainView();
      }
      if ("System Admin".equals(selectedUserType))
      {
        viewHandler.openMainViewSystemAdmin();
      }

    }
  }

  /**
   * Takes the type of user and the credentials entered by the user and calls
   * the loginViewModel.
   * @param actionEvent Event trigger by the login button.
   *
   */
  public void onLoginButton(ActionEvent actionEvent) {

    RadioButton selectedRadioButton = (RadioButton) userType.getSelectedToggle();
    selectedUserType = selectedRadioButton.getText();

    loginViewModel.login(selectedUserType);
  }

}
