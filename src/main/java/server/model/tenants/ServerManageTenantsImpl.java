package server.model.tenants;

import shared.domain.Tenant;
import shared.domain.TenantsList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ServerManageTenantsImpl implements ServerManageTenants
{
  private static ServerManageTenantsImpl serverManageTenants;
  PropertyChangeSupport support;

  private ServerManageTenantsImpl(){
    support = new PropertyChangeSupport(this);
  }

  public static ServerManageTenantsImpl getInstance(){
    if (serverManageTenants == null) {
      serverManageTenants = new ServerManageTenantsImpl();
    }
    return serverManageTenants;
  }

  /* --------

   */
  private TenantsList tenantsList = new TenantsList();

  @Override public Tenant addTenant(Tenant tenant)
  {
    tenantsList.add(tenant);
    System.out.println(tenant.getCpr());
    System.out.println(tenantsList.getTenants());

    return tenant;
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null) {
      addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(name, listener);
    }

  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);

  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      removePropertyChangeListener(listener);
    } else {
      support.removePropertyChangeListener(listener);
    }

  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);

  }
}
