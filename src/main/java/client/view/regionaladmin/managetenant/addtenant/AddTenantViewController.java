package client.view.regionaladmin.managetenant.addtenant;


import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

  private void reset(){
    cprField.clear();
    firstNameField.clear();
    lastNameField.clear();
    municipalityField.clear();
    passwordField.clear();
    regionalAdminIDField.clear();
  }


}
