package client.view.systemadmin.seedetails;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class MunicipalityDetailsViewController implements ViewController
{
  public Label municipalityNameLabel;
  public Label municipalityRegionLabel;
  public Label municipalityIdLabel;
  public Label fnameLabel;
  public Label nameLabel;
  private SAViewHandler viewHandler;
   private MunicipalityDetailsViewModel detailsViewModel;


  @Override public void init() throws IOException
  {
    this.viewHandler = SAViewHandler.getInstance();
    detailsViewModel = ViewModelFactory.getInstance()
        .getMunicipalityDetailsViewModel();
    municipalityIdLabel.textProperty().bind(detailsViewModel.idProperty());
    municipalityRegionLabel.textProperty().bind(detailsViewModel.regionProperty());
    municipalityNameLabel.textProperty().bind(detailsViewModel.nameProperty());
  }

  public void onAddRegionalAdmin(ActionEvent actionEvent)
  {
    viewHandler.openAddRegionalAdminView();
  }

  public void onBack(ActionEvent actionEvent)
  {
    viewHandler.openMainView();
  }
}
