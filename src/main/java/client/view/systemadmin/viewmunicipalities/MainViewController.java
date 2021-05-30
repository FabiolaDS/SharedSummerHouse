package client.view.systemadmin.viewmunicipalities;


import client.core.ViewModelFactory;
import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Municipality;

import java.io.IOException;

public class MainViewController
{
  public TableColumn<Municipality, String> muniColumn;
  public TableColumn<Municipality, String> regionColumn;
  public TableColumn<Municipality, String> idColumn;
  public TableColumn<Municipality, String> rAdminColumn;
  public TableView<Municipality> municipalityTable;
  public Label warningLabel;

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private MainViewModel mainViewModel;



  public MainViewController(ViewHandler viewHandler, MainViewModel mainViewModel)
  {
    this.mainViewModel = mainViewModel;
    this.viewHandler = viewHandler;
  }

  public void initialize()
  {

    muniColumn.setCellValueFactory(
        new PropertyValueFactory<Municipality, String>("name"));
    idColumn.setCellValueFactory(
        new PropertyValueFactory<Municipality, String>("id"));
    regionColumn.setCellValueFactory(
        new PropertyValueFactory<Municipality, String>("region"));
    rAdminColumn.setCellValueFactory(
        new PropertyValueFactory<Municipality, String>("regionalAdminCPR"));
    warningLabel.textProperty().setValue(" ");

    tableViewLoad();
  }

  private void tableViewLoad()
  {
    municipalityTable.setItems(mainViewModel.getMunicipalities());
  }

  public void onCreatMunicipality(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAddMunicipalityView();
  }

  public void onSeeDetails(ActionEvent actionEvent)
  {
    municipalityTable.getSelectionModel().getSelectedItem();
    updateSelectedMunicipality();
    viewHandler.openSeeMunicipalityDetailsView();

  }

  private void updateSelectedMunicipality()
  {
    if (municipalityTable.getSelectionModel().getSelectedItem() != null)
    {
      String id = municipalityTable.getSelectionModel().getSelectedItem()
          .getId();
      ViewModelFactory.getInstance().getMunicipalityDetailsViewModel()
          .getMunicipalityDetailsId(id);
    }
  }

  public void onDeleteMunicipality(ActionEvent actionEvent)
  {

    if (municipalityTable.getSelectionModel().getSelectedItem().getRegionalAdminCPR() == null)
    {
      mainViewModel.deleteMunicipality(municipalityTable.getSelectionModel().getSelectedItem()
          .getId());
      warningLabel.textProperty().setValue("Municipality has been deleted");
    }
    else
    {
      warningLabel.textProperty().setValue(" Delete Regional Admin first ");
    }

  }
}
