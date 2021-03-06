package client.network;

import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;
import shared.domain.*;
import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferobjects.EventType;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * RMIClient class implementing the Client and ClientCallback interfaces. It
 * connects to the server, sending and receiving data to and from it.
 */
public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

  /**
   * 0-argument constructor setting the PropertyChangeSupport and starting the
   * client.
   */
  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
    startClient();
  }


  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("Server");
      server.registerClient(this);
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void login(User user)
  {
    try
    {
      support.firePropertyChange(EventType.LOGIN.toString(), null,
          server.validateUser(user));
    }
    catch (RemoteException | SQLException e)
    {
      support.firePropertyChange(EventType.LOGIN.toString(), null,
          "Connection lost: Restart application");
    }
  }

  @Override public void addMunicipality(Municipality municipality)
  {
    try
    {
      support.firePropertyChange(EventType.MUNICIPALITY.toString(), null,
          server.addMunicipality(municipality));
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Municipality getMunicipality(String id)
  {
    Municipality municipality = null;
    try
    {
      municipality = server.getMunicipality(id);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return municipality;
  }

  @Override public void addRegionalAdmin(RegionalAdmin regionalAdmin,
      String municipalityId)
  {
    try
    {
      support.firePropertyChange(EventType.REGIONALADMIN.toString(), null,
          server.addRegionalAdmin(regionalAdmin, municipalityId));
      System.out.println("client calling server to add RA");
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addTenant(Tenant tenant)
  {
    try
    {
      support.firePropertyChange(EventType.TENANTS.toString(), null,
          server.addTenant(tenant));
    }
    catch (RemoteException | SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public BookingsManager getBookingsManager()
  {
    try
    {
      return server.getBookingsManager();
    }
    catch (RemoteException ex)
    {
      throw new RuntimeException(ex);
    }
  }

  @Override public SummerHousesManager getSummerHousesManager()
  {
    try
    {
      return server.getSummerHousesManager();
    }
    catch (RemoteException e)
    {        // critical error, shutdown
      throw new RuntimeException(e);
    }
  }

  @Override public List<Municipality> getAllMunicipalities()
  {
    List<Municipality> municipalities = null;
    try
    {
      municipalities = server.getAllMunicipalities();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return municipalities;
  }

  @Override public RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR)
  {
    RegionalAdmin regionalAdmin = null;
    try
    {
      regionalAdmin = server.getRegionalAdminByCPR(regionalAdminCPR);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return regionalAdmin;
  }

  @Override public void deleteRegionalAdmin(RegionalAdmin regionalAdmin)
  {
    try
    {
      server.deleteRegionalAdmin(regionalAdmin);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteMunicipality(String id)
  {
    try
    {
      server.deleteMunicipality(id);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    try
    {
      support.firePropertyChange(EventType.REGIONALADMIN.toString(), null,
          server.getAllMunicipalities());
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Tenant> getAllTenants()
  {
    List<Tenant> tenants = null;
    try
    {
      tenants = server.getAllTenants();
    }
    catch (RemoteException e){
      e.printStackTrace();
    }
    return tenants;
  }

  @Override public ArrayList<Tenant> getTenants()
  {
    ArrayList<Tenant> tenants = new ArrayList<>();
    try
    {
      tenants = server.getTenants();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return tenants;
  }


  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      addPropertyChangeListener(listener);
    }
    else
    {
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
    }
    else
    {
      support.removePropertyChangeListener(listener);
    }
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void updates(String eventType, Object update)
      throws RemoteException
  {

  }
  @Override public void unregisterClient()
  {

  }


}
