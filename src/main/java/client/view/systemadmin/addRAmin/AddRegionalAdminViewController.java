package client.view.systemadmin.addRAmin;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * class controlling the view for Adding a new RegionalAdmin to the system
 * @author Agsotina Mezzabotta
 */
public class AddRegionalAdminViewController
{

  public Label municipalityLabel;
  private AddRegionalAdministratorViewModel addRegionalAdministratorVM;
  private ViewHandler viewHandler;
  public TextField cprField;
  public TextField fnameField;
  public TextField lnameField;
  public TextField emailField;
  public TextField passwordField;

  public AddRegionalAdminViewController(ViewHandler viewHandler,
      AddRegionalAdministratorViewModel addRegionalAdministratorVM)
  {
    this.addRegionalAdministratorVM = addRegionalAdministratorVM;
    this.viewHandler = viewHandler;
  }

  public void  initialize()
  {

    municipalityLabel.textProperty()
        .bindBidirectional(addRegionalAdministratorVM.getMunicipalityId());
    cprField.textProperty()
        .bindBidirectional(addRegionalAdministratorVM.cprNrProperty());
    fnameField.textProperty()
        .bindBidirectional(addRegionalAdministratorVM.nameProperty());
    lnameField.textProperty()
        .bindBidirectional(addRegionalAdministratorVM.lastNameProperty());
    emailField.textProperty()
        .bindBidirectional(addRegionalAdministratorVM.mnameProperty());
    passwordField.textProperty()
        .bindBidirectional(addRegionalAdministratorVM.passwordProperty());

  }

  public void onCreateRadmin(ActionEvent actionEvent)
  {
    addRegionalAdministratorVM.addRegionalAdmin();
    reset();
  }

  public void onBack(ActionEvent actionEvent)
  {
    ViewModelFactory.getInstance().getMunicipalityDetailsViewModel()
        .getMunicipalityDetailsId(municipalityLabel.getText());
    municipalityLabel.textProperty().setValue("");
    viewHandler.openSeeMunicipalityDetailsView();
  }
  /**
   * reset view components
   */
  private void reset()
  {
    fnameField.textProperty().setValue("");
    cprField.textProperty().setValue("");
    lnameField.textProperty().setValue("");
    emailField.textProperty().setValue("");
    passwordField.textProperty().setValue("");
  }

}
