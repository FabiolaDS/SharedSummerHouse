package client.model.tenants;

import client.core.ClientFactory;
import client.network.Client;
import shared.domain.TenantsList;
import shared.domain.Tenant;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ManageTenantsModelImpl implements TenantsModel
{

  private PropertyChangeSupport support;
  private TenantsList tenantsList;
  private Client client;

  public ManageTenantsModelImpl()
  {
    support = new PropertyChangeSupport(this);
    tenantsList = new TenantsList();
    client = ClientFactory.getClientFactory().getClient();
    client.addPropertyChangeListener(EventType.TENANTS.toString(),
        this::getTenants);
  }

  @Override public void addTenant(Tenant tenants)
  {
    try
    {
      client.addTenant(tenants);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }

  }

  @Override public ArrayList<Tenant> getTenants()
  {
    return null;
  }


  @Override public void getTenants(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }
   @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

    @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

   @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

   @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

   /*public void propertyChange(PropertyChangeEvent evt)
  {

  }*/
}
