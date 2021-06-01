package client.view.systemadmin.addmunicipality;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * This class controls the view to create municipalities
 * @author Agostina Mezzabotta
 * @version 1.0
 */

public class AddMunicipalityViewController
{
  @FXML public TextField municipalityNameField;
  @FXML public TextField municipalityRegionField;
  @FXML public TextField municipalityIDField;
  @FXML Label warningLabel;

  private ViewHandler viewHandler;
  private AddMunicipalityViewModel addMunicipalityViewModel;

  public AddMunicipalityViewController(ViewHandler viewHandler,
      AddMunicipalityViewModel addMunicipalityViewModel)
  {
    this.viewHandler = viewHandler;
    this.addMunicipalityViewModel = addMunicipalityViewModel;
  }

  /**
   * initializes the components used in the view and binds its content to the
   * AddMunicipalityViewModel class
   */
  public void initialize()
  {

    this.warningLabel.textProperty()
        .bind(addMunicipalityViewModel.getWarningProperty());
    municipalityIDField.textProperty()
        .bindBidirectional(addMunicipalityViewModel.idProperty());
    municipalityRegionField.textProperty()
        .bindBidirectional(addMunicipalityViewModel.regionProperty());
    municipalityNameField.textProperty()
        .bindBidirectional(addMunicipalityViewModel.nameProperty());
  }

  public void onCreateMunicipality(ActionEvent actionEvent)
  {
    addMunicipalityViewModel.addMunicipality();
    reset();
  }

  public void onBackToMain(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openMainViewSystemAdmin();
  }

  /**
   * resents the components in the view
   */
  private void reset()
  {
    municipalityNameField.clear();
    municipalityRegionField.clear();
    municipalityIDField.clear();
  }
}
