package server.model.tenants;

import server.dataaccess.TenantDAO;
import server.dataaccess.TenantDAOImpl;
import shared.domain.Tenant;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

/**
 * class managing the events related to Tenants
 * @author alina
 */

public class ServerManageTenantsImpl implements ServerManageTenants
{
  private TenantDAO tenantDAO;
  PropertyChangeSupport support;

  /**
   * constructor to acces the Data Access Object classes
   * @param tenantDAO DataAccessObject for Municipalities
   */
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

  @Override public List<Tenant> getAllTenants()
  {
    List<Tenant> tenants = null;
    try
    {
      tenants = tenantDAO.getAll();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return tenants;
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
