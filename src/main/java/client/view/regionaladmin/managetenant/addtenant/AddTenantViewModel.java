package client.view.regionaladmin.managetenant.addtenant;

import client.model.tenants.TenantsModel;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.domain.Tenant;

import java.rmi.RemoteException;

/**
 * Receives the information to create a new tenant.
 *  Validates the input to avoid exceptions in the classes related
 * @author alina
 */

public class AddTenantViewModel
{
  private TenantsModel tenantModel;
  private StringProperty cpr, firstName, lastName, municipality, regionalAdminID, password;

  /**
   * argument constructor setting the TenantModel class as a model
   * @param tenantsModel model
   */
  public AddTenantViewModel(TenantsModel tenantsModel) {
    this.tenantModel = tenantsModel;
    cpr = new SimpleStringProperty();
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    municipality = new SimpleStringProperty();
    regionalAdminID = new SimpleStringProperty();
    password = new SimpleStringProperty();
  }


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


  public StringProperty getRegionalAdminIDProperty()
  {
    return regionalAdminID;
  }
  public StringProperty getPasswordProperty()
  {
    return password;
  }

  public String getCpr()
  {
    return cpr.get();
  }

  public String getFirstName()
  {
    return firstName.get();
  }

  public String getLastName()
  {
    return lastName.get();
  }

  public String getMunicipality()
  {
    return municipality.get();
  }

  public String getRegionalAdminID()
  {
    return regionalAdminID.get();
  }

  public String getPassword()
  {
    return password.get();
  }

  /**
   * creating a new tenant
   */
  public void addTenant()

  {
    tenantModel.addTenant(new Tenant(getCpr(), getFirstName(), getLastName(), getMunicipality(), getPassword(), getRegionalAdminID()));
  }
}
