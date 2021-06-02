package client.view.regionaladmin.managetenant.addtenant;


import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * controls the view to create tenants
 * @author alina
 */

public class AddTenantViewController
{
  @FXML public TextField cprField;
  @FXML public TextField firstNameField;
  @FXML public TextField lastNameField;
  @FXML public TextField municipalityField;
  @FXML public TextField regionalAdminIDField;
  @FXML public TextField passwordField;
  //@FXML public TextField passwordLabel;
  //@FXML public TextField typeLabel;


  private ViewHandler viewHandler;
  private AddTenantViewModel addTenantViewModel;

  public AddTenantViewController(ViewHandler viewHandler, AddTenantViewModel addTenantViewModel)
  {
    this.viewHandler = viewHandler;
    this.addTenantViewModel = addTenantViewModel;
  }

  /**
   * initialises the fields variable(properties) and binds with AddTenantViewModel class
   */
 public void  initialize()
  {
    cprField.textProperty().bindBidirectional(addTenantViewModel.cprProperty());
    firstNameField.textProperty().bindBidirectional(addTenantViewModel.firstNameProperty());
    lastNameField.textProperty().bindBidirectional(addTenantViewModel.lastNameProperty());
    municipalityField.textProperty().bindBidirectional(addTenantViewModel.municipalityProperty());
    regionalAdminIDField.textProperty().bindBidirectional(addTenantViewModel.getRegionalAdminIDProperty());
    passwordField.textProperty().bindBidirectional(addTenantViewModel.getPasswordProperty());
  }

  public void onCreateTenants(ActionEvent actionEvent)
  {
    addTenantViewModel.addTenant();
    reset();
  }

  public void onEditTenants(ActionEvent actionEvent)
  {
  }
  public void onBackToMain(ActionEvent actionEvent)
  {
    viewHandler.openMainView();
  }
  /**
   * resents the components in the view
   */
  private void reset(){
    cprField.clear();
    firstNameField.clear();
    lastNameField.clear();
    municipalityField.clear();
    passwordField.clear();
    regionalAdminIDField.clear();
  }


}
