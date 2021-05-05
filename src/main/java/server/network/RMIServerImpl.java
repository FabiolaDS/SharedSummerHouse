package server.network;

import server.model.municipalities.Municipality;
import server.model.municipalities.MunicipalityList;
import server.model.municipalities.RegionalAdmin;
import shared.network.ClientCallback;
import shared.network.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIServerImpl implements RMIServer
{

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

  }

  @Override public void unregisterClient(ClientCallback clientCallback)
      throws RemoteException
  {

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
