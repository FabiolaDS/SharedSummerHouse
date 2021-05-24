package client.view.regionaladmin.managetenant.viewtenantdetail;

import client.core.ViewModelFactory;
import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Tenant;


import java.io.IOException;

public class TenantDetailsViewController implements ViewController
{
  @FXML private TableColumn<Tenant, String> cprColumn;
  @FXML private TableColumn<Tenant, String> firstNameColumn;
  @FXML private TableColumn<Tenant, String> lastNameColumn;
  @FXML private TableColumn<Tenant, String> municipalityColumn;
  @FXML private TableColumn<Tenant, String> regAdminIDColumn;
        private TableView<Tenant> tenantTable;

  private RAViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private TenantDetailsViewModel tenantDetailsViewModel;

  public TenantDetailsViewController(){}

  @Override public void init()
  {
    this.viewModelFactory = ViewModelFactory.getInstance();
    this.tenantDetailsViewModel = viewModelFactory.getTenantDetailsViewModel();

    viewHandler = RAViewHandler.getInstance();

    cprColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("cpr"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("firstname"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("lastname"));
    municipalityColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("municipality"));
    regAdminIDColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("regAdminID"));


    //tableViewLoad();

  }

  private void tableViewLoad(){
    tenantTable.setItems(tenantDetailsViewModel.getTenants());
  }
  public void onBackToMain(ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }


  public void onCreateTenant(ActionEvent actionEvent)
  {
    viewHandler.openAddTenantView();
  }

  public void onEditTenants(ActionEvent actionEvent)
  {
    tenantTable.getSelectionModel().getSelectedItem();
    updateSelectedTenant();
    viewHandler.openSeeAllTenants();
  }

  public void onRemoveTenant(ActionEvent actionEvent)
  {
    tenantTable.getItems().removeAll(tenantTable.getSelectionModel().getSelectedItem());
  }

  private void updateSelectedTenant() {
    if (tenantTable.getSelectionModel().getSelectedItem() != null) {
      String cpr = tenantTable.getSelectionModel().getSelectedItem().getCpr();
     /* String firstName = tenantTable.getSelectionModel().getSelectedItem().getFirstName();
      String lastName = tenantTable.getSelectionModel().getSelectedItem().getLastName();
      String municipality = tenantTable.getSelectionModel().getSelectedItem().getMunicipality();
      String regAdminID = tenantTable.getSelectionModel().getSelectedItem().getRegionalAdminID();
            ViewModelFactory.getInstance().getTenantDetailsViewModel().setCpr(cpr);
            ViewModelFactory.getInstance().getTenantDetailsViewModel().setFirstName(firstName);
            ViewModelFactory.getInstance().getTenantDetailsViewModel().setLastName(lastName);*/
      ViewModelFactory.getInstance().getTenantDetailsViewModel().getTenants();
    }
  }
}
