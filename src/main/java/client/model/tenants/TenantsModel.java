package client.model.tenants;

import shared.domain.Tenant;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface for TenantsModel. It's create and get all Tenants
 * @author alina
 */

public interface TenantsModel extends PropertyChangeSubject
{
  /**
   * method sending the Tenant object to the client
   * @param tenant new tenant to register in the system
   */
  public void addTenant(Tenant tenant);
  ArrayList<Tenant> getTenants();
  /**
   * method listening to an event happening in the client side and notifying to other classes
   * @param propertyChangeEvent listened from the client
   */
  public void getTenants(PropertyChangeEvent propertyChangeEvent);
  /**
   * method getting all the tenants existent in the system
   * @return a list of Tenants
   */
  List<Tenant> getAllTenants();

}
