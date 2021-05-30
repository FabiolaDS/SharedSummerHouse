package client.view.regionaladmin.managetenant.viewtenantdetail;


import client.model.tenants.TenantsModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import shared.domain.Tenant;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class TenantDetailsViewModel
{

  private TenantsModel model;
  private ObservableList<Tenant> tenants;
  private ObservableSet<Tenant> selectedTenant;

  // something to try

  private StringProperty cpr, firstName, lastName, municipality, regAdminID;





  public TenantDetailsViewModel(TenantsModel tenantsModel) {
    model = tenantsModel;
    model.addPropertyChangeListener(EventType.TENANTS.toString(), this::newTenant);
    tenants = FXCollections.observableArrayList();
    selectedTenant = FXCollections.observableSet();
    tenants.setAll(model.getAllTenants());



    // constructor
    cpr = new SimpleStringProperty("");
    firstName = new SimpleStringProperty("");
    lastName = new SimpleStringProperty("");
    municipality = new SimpleStringProperty("");
    regAdminID = new SimpleStringProperty("");

  }

  public String getCpr()
  {
    return cpr.get();
  }

  public StringProperty cprProperty()
  {
    return cpr;
  }

  public void setCpr(String cpr)
  {
    this.cpr.set(cpr);
  }

  public String getFirstName()
  {
    return firstName.get();
  }

  public StringProperty firstNameProperty()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName.set(firstName);
  }

  public String getLastName()
  {
    return lastName.get();
  }

  public StringProperty lastNameProperty()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName.set(lastName);
  }

  public String getMunicipality()
  {
    return municipality.get();
  }

  public StringProperty municipalityProperty()
  {
    return municipality;
  }

  public void setMunicipality(String municipality)
  {
    this.municipality.set(municipality);
  }

  public String getRegAdminID()
  {
    return regAdminID.get();
  }

  public StringProperty regAdminIDProperty()
  {
    return regAdminID;
  }

  public void setRegAdminID(String regAdminID)
  {
    this.regAdminID.set(regAdminID);
  }

  public ObservableList<Tenant> getTenants()
  {
    return tenants;
  }

  public void setTenants(ObservableList<Tenant> tenants)
  {
    this.tenants = tenants;
  }

  private void updateTenants(PropertyChangeEvent propertyChangeEvent){
    tenants.clear();
   // Platform.runLater(() -> tenants.setAll(ObservableList<Tenant>) propertyChangeEvent.getNewValue());
  }
  private void newTenant(PropertyChangeEvent propertyChangeEvent){
    Platform.runLater(() -> tenants.add((Tenant) propertyChangeEvent.getNewValue()));
  }
}
