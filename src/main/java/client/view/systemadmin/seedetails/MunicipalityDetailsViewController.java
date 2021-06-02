package client.view.systemadmin.seedetails;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

/**
 * Class controlling the view for MunicipalityDetails
 * @author Agostina Mezzabotta
 */
public class MunicipalityDetailsViewController
{
  public Label municipalityNameLabel;
  public Label municipalityRegionLabel;
  public Label municipalityIdLabel;
  public Label fnameLabel;
  public Label nameLabel;
  public Label emailLabel;
  public Label cprLabel;
  private ViewHandler viewHandler;
  private MunicipalityDetailsViewModel detailsViewModel;

  public MunicipalityDetailsViewController(ViewHandler viewHandler, MunicipalityDetailsViewModel municipalityDetailsViewModel)
  {
    this.viewHandler = viewHandler;
    this.detailsViewModel = municipalityDetailsViewModel;
  }

  /**
   * initializes the view components and binds them to the View Model
   */
 public void initialize()
  {
    municipalityIdLabel.textProperty().bind(detailsViewModel.idProperty());
    municipalityRegionLabel.textProperty()
        .bind(detailsViewModel.regionProperty());
    municipalityNameLabel.textProperty().bind(detailsViewModel.nameProperty());
    cprLabel.textProperty().bind(detailsViewModel.cprProperty());
    fnameLabel.textProperty().bind(detailsViewModel.firstNameProperty());
    nameLabel.textProperty().bind(detailsViewModel.lastNameProperty());
    emailLabel.textProperty().bind(detailsViewModel.mNameProperty());
  }

  public void onAddRegionalAdmin(ActionEvent actionEvent)
  {
    String id = municipalityIdLabel.textProperty().get();
    ViewModelFactory.getInstance().getAddRegionalAdministratorViewModel()
        .setMunicipalityId(id);
    viewHandler.openAddRegionalAdminView();

  }

  public void onBack(ActionEvent actionEvent)
  {
    ViewModelFactory.getInstance().getMainViewModel().setMunicipalityList();
    viewHandler.openMainViewSystemAdmin();
  }

  public void onRemoverRegionalAdmin(ActionEvent actionEvent)
  {
    detailsViewModel.deleteRegionalAdmin();

  }
}
