package server.model.tenants;

import server.dataaccess.TenantDAO;
import server.dataaccess.TenantDAOImpl;
import shared.domain.Tenant;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

public class ServerManageTenantsImpl implements ServerManageTenants
{
  private TenantDAO tenantDAO;
  PropertyChangeSupport support;

  public ServerManageTenantsImpl(TenantDAO tenantDAO){
    this.tenantDAO = tenantDAO;
    support = new PropertyChangeSupport(this);
  }


  @Override public Tenant addTenant(Tenant tenant) throws SQLException
  {
    //tenantsList.add(tenant);
    tenantDAO.createTenant(tenant);
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
