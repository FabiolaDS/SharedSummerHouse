package client.view.regionaladmin.managetenant.viewtenantdetail;

import client.core.ViewModelFactory;
import client.core.viewhandler.SAViewHandler;
import client.view.ViewController;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Tenant;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class TenantDetailsViewController implements ViewController
{
  public TableColumn<Tenant, String> cprColumn;
  public TableColumn<Tenant, String> firstNameColumn;
  public TableColumn<Tenant, String> lastNameColumn;
  public TableColumn<Tenant, String> municipalityColumn;
  public TableColumn<Tenant, String> emailColumn;
  public TableView<Tenant> tenantTable;

  private SAViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private TenantDetailsViewModel tenantDetailsViewModel;

  @Override public void init() throws IOException
  {
    this.viewModelFactory = ViewModelFactory.getInstance();
    this.tenantDetailsViewModel = viewModelFactory.getTenantDetailsViewModel();

    viewHandler = SAViewHandler.getInstance();

    cprColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("cprNumber"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("First Name"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("Last Name"));
    municipalityColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("Municipality Name"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("email"));
    tableViewLoad();

  }
  private void tableViewLoad(){
    tenantTable.setItems(tenantDetailsViewModel.getTenants());
  }

  public void onCreateTenant(ActionEvent actionEvent){
    viewHandler.openAddTenantsView();
  }

  public void onEditTenants(ActionEvent actionEvent){}

  public void onRemoveTenant(ActionEvent actionEvent){}
  public void onBackToMain(javafx.event.ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }
}
