package server.network;

import server.model.login.LoginModel;
import server.model.municipalities.Municipality;
import server.model.municipalities.MunicipalityList;
import server.model.municipalities.RegionalAdmin;
import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferobjects.EventType;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RMIServerImpl implements RMIServer
{

  private LoginModel loginModel;
  private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

  public RMIServerImpl(LoginModel loginModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.loginModel = loginModel;
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }
  @Override public String validateUser(User user)
  {
    return loginModel.validateUser(user);
  }

  @Override public void addMunicipality(Municipality municipality)
      throws RemoteException
  {

  }

  @Override public void addRegionalAdmin(RegionalAdmin regionalAdmin)
      throws RemoteException
  {

  }

  @Override public void registerClient(ClientCallback clientCallback)
      throws RemoteException
  {
    PropertyChangeListener listener = new PropertyChangeListener()
    {
      @Override public void propertyChange(PropertyChangeEvent evt)
      {
        try
        {
          clientCallback.updates(EventType.UPDATE.toString(), evt.getNewValue());
        }
        catch (RemoteException e)
        {
          loginModel.removePropertyChangeListener(EventType.UPDATE.toString(), this);
        }
      }
    };
    listeners.put(clientCallback, listener);
    loginModel.addPropertyChangeListener(EventType.UPDATE.toString(), listener);
  }

  @Override public void unregisterClient(ClientCallback clientCallback)
      throws RemoteException
  {
    PropertyChangeListener listener = listeners.get(clientCallback);
    if (listener != null) {
      listeners.remove(clientCallback, listener);
      loginModel.removePropertyChangeListener(listener);
    }
  }

  @Override public ArrayList<MunicipalityList> getMunicipalities()
      throws RemoteException
  {
    return null;
  }

  @Override public Municipality getMunicipality() throws RemoteException
  {
    return null;
  }
}
