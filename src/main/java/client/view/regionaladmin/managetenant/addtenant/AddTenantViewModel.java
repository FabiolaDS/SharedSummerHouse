package client.view.regionaladmin.managetenant.addtenant;

import client.model.tenants.TenantsModel;
import javafx.beans.property.StringProperty;
import shared.domain.Tenant;

import java.rmi.RemoteException;

public class AddTenantViewModel
{
  private TenantsModel tenantModel;
  private StringProperty cpr, firstName, lastName, municipality, email, type;

  public AddTenantViewModel(TenantsModel tenantsModel) {
    this.tenantModel = tenantsModel;
  }

  public AddTenantViewModel()
  {

  }

  public void addTenant(String cpr, String firstName, String lastName, String municipality, String email)
      throws RemoteException
  {
    tenantModel.addTenant(new Tenant(cpr, firstName, lastName, municipality, email, type));
  }
}
