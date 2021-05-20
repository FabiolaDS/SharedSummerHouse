package server.network;

import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import server.model.municipalities.ServerManageMunicipalities;
import server.model.municipalities.ServerManageMunicipalitiesImp;
import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RMIServerImpl implements RMIServer
{

  private LoginModel loginModel;
  private ServerManageMunicipalities municipalitiesModel;
  private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

  public RMIServerImpl(LoginModelManager loginModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.loginModel = loginModel;
    this.municipalitiesModel = ServerManageMunicipalitiesImp.getInstance();
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override public String validateUser(User user) throws SQLException
  {
    return loginModel.validateUser(user);
  }

  @Override public Municipality addMunicipality(Municipality municipality)
      throws RemoteException
  {
    return municipalitiesModel.addMunicipality(municipality);
  }

  @Override public Municipality getMunicipality(String id)
      throws RemoteException
  {
    return municipalitiesModel.getMunicipality(id);
  }

  @Override public Municipality addRegionalAdmin(RegionalAdmin regionalAdmin,
      String municipalityID) throws RemoteException
  {
    return municipalitiesModel.setRegionalAdmin(regionalAdmin, municipalityID);
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
          clientCallback
              .updates(EventType.UPDATE.toString(), evt.getNewValue());
        }
        catch (RemoteException e)
        {
          loginModel
              .removePropertyChangeListener(EventType.UPDATE.toString(), this);
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
    if (listener != null)
    {
      listeners.remove(clientCallback, listener);
      loginModel.removePropertyChangeListener(listener);
    }
  }

}
