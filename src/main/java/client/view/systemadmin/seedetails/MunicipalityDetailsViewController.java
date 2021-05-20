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
  public Label emailLabel;
  public Label cprLabel;
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

    cprLabel.textProperty().bind(detailsViewModel.cprProperty());
    fnameLabel.textProperty().bind(detailsViewModel.firstNameProperty());
    nameLabel.textProperty().bind(detailsViewModel.lastNameProperty());
    emailLabel.textProperty().bind(detailsViewModel.emailProperty());
  }

  public void onAddRegionalAdmin(ActionEvent actionEvent)
  {
    String id = municipalityIdLabel.textProperty().get();
    ViewModelFactory.getInstance().getAddRegionalAdministratorViewModel().setMunicipalityId(id);
    viewHandler.openAddRegionalAdminView();
  }

  public void onBack(ActionEvent actionEvent)
  {
    viewHandler.openMainView();
  }
}
