package client.network;


import server.model.municipalities.ServerManageMunicipalitiesImp;
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

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

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

  @Override public void addSummerHouse(SummerHouse summerHouse)
  {

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
          "Connection lost: Restart application"); // give feedback to client
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
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void unregisterClient()
  {
    try
    {
      server.unregisterClient(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }



  @Override public void updateMunicipalities() throws RemoteException
  {

  }

  @Override public void updateMunicipality() throws RemoteException
  {

  }
  @Override public ArrayList<SummerHouseList> getSummerHouses()
  {
    return null;
  }

  @Override public void addTenant(Tenant tenants) throws RemoteException
  {
    support.firePropertyChange(EventType.TENANTS.toString(), null,
        server.addTenant(tenants));
  }


  @Override public void updates(String eventType, Object update)
      throws RemoteException
  {
    // Could include different if statements for the different events
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
}
