package client.view.systemadmin.addmunicipality;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMunicipalityViewController implements ViewController
{
  @FXML public TextField municipalityNameField;
  @FXML public TextField municipalityRegionField;
  @FXML public TextField municipalityIDField;
  @FXML Label warningLabel;

  private SAViewHandler viewHandler;
  private AddMunicipalityViewModel addMunicipalityViewModel;

  @Override public void init() throws IOException
  {

    this.viewHandler = SAViewHandler.getInstance();
    this.addMunicipalityViewModel = ViewModelFactory.getInstance()
        .addMunicipalityViewModel();
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
    viewHandler.openMainView();
  }

  private void reset()
  {
    municipalityNameField.clear();
    municipalityRegionField.clear();
    municipalityIDField.clear();
  }
}
