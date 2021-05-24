package client.view.regionaladmin.managetenant.viewtenantdetail;


import client.model.tenants.TenantsModel;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import shared.domain.Tenant;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;

public class TenantDetailsViewModel
{

  private TenantsModel model;
  private ObservableList<Tenant> tenants;
  private ObservableSet<Tenant> selectedTenant;



  public TenantDetailsViewModel(TenantsModel tenantsModel) {
    model = tenantsModel;
    model.addPropertyChangeListener(EventType.TENANTS.toString(), this::newTenant);
    tenants = FXCollections.observableArrayList();
    selectedTenant = FXCollections.observableSet();
  }



  public ObservableList<Tenant> getTenants()

  {
    return tenants;
  }
  private void newTenant(PropertyChangeEvent propertyChangeEvent){
    Platform.runLater(() -> tenants.add((Tenant) propertyChangeEvent.getNewValue()));
  }
}
