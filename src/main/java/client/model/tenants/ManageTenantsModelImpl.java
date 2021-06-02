package client.model.tenants;

import client.core.ClientFactory;
import client.network.Client;
import shared.domain.SummerHouse;

import shared.domain.Tenant;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing ManageTenants
 *
 * @author alina
 */

public class ManageTenantsModelImpl implements TenantsModel
{

  private PropertyChangeSupport support;
  private Client client;

  /**
   * constructers setting the client and PropertyChangeSupport
   * adding subscribers to events happening in the client
   */
  public ManageTenantsModelImpl()
  {
    support = new PropertyChangeSupport(this);

    client = ClientFactory.getClientFactory().getClient();
    client.addPropertyChangeListener(EventType.TENANTS.toString(),
        this::getTenants);
  }

  @Override public void addTenant(Tenant tenant)
  {
      client.addTenant(tenant);

  }

  @Override public ArrayList<Tenant> getTenants()

  {
    ArrayList<Tenant> tenants = new ArrayList<>();
    tenants = client.getTenants();
    return tenants;
  }


  @Override public void getTenants(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public List<Tenant> getAllTenants()
  {
    return client.getAllTenants();
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
