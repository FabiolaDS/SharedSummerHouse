package client.model.tenants;

import shared.domain.Tenant;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TenantsModel extends PropertyChangeSubject
{
  public void addTenant(Tenant tenants) throws RemoteException;
  ArrayList<Tenant> getTenants();
  public void getTenants(PropertyChangeEvent propertyChangeEvent);

}
