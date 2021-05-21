package client.view.regionaladmin.managetenant.addtenant;

import client.model.tenants.TenantsModel;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.domain.Tenant;

import java.rmi.RemoteException;

public class AddTenantViewModel
{
  private TenantsModel tenantModel;
  private StringProperty cpr, firstName, lastName, municipality, email;

  public AddTenantViewModel(TenantsModel tenantsModel) {
    this.tenantModel = tenantsModel;
    cpr = new SimpleStringProperty();
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    municipality = new SimpleStringProperty();
    email = new SimpleStringProperty();
  }

  //public AddTenantViewModel() {}


  public StringProperty cprProperty()
  {
    return cpr;
  }



  public StringProperty firstNameProperty()
  {
    return firstName;
  }



  public StringProperty lastNameProperty()
  {
    return lastName;
  }


  public StringProperty municipalityProperty()
  {
    return municipality;
  }


  public StringProperty emailProperty()
  {
    return email;
  }

  public void addTenant(String cpr, String firstName, String lastName, String municipality, String email)
      throws RemoteException
  {
    tenantModel.addTenant(new Tenant(cpr, firstName, lastName, municipality, email));
  }
}
