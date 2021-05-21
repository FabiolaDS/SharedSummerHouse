package client.view.regionaladmin.managetenant.viewtenantdetail;

import client.core.ViewModelFactory;
import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

  private RAViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private TenantDetailsViewModel tenantDetailsViewModel;

  public TenantDetailsViewController(){}

  @Override public void init() throws IOException
  {
    this.viewModelFactory = ViewModelFactory.getInstance();
    this.tenantDetailsViewModel = viewModelFactory.getTenantDetailsViewModel();

    viewHandler = RAViewHandler.getInstance();

    //cprColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("cpr"));
  //  firstNameColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("firstname"));
 //   lastNameColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("lastname"));
 //   municipalityColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("Municipality Name"));
    //emailColumn.setCellValueFactory(new PropertyValueFactory<Tenant, String>("email"));
    //tableViewLoad();

  }
  @FXML
  private void tableViewLoad(){
    tenantTable.setItems(tenantDetailsViewModel.getTenants());
  }
  @FXML public void onBackToMain(javafx.event.ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }


  public void onCreateTenant(javafx.event.ActionEvent actionEvent)
  {
    viewHandler.openAddTenantView();
  }

  public void onEditTenants(javafx.event.ActionEvent actionEvent)
  {
  }

  public void onRemoveTenant(javafx.event.ActionEvent actionEvent)
  {
    tenantTable.getItems().removeAll(tenantTable.getSelectionModel().getSelectedItem());
  }
}
