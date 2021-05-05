package shared.network;

import server.model.municipalities.Municipality;
import server.model.municipalities.MunicipalityList;
import server.model.municipalities.RegionalAdmin;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIServer extends Remote
{
  void addMunicipality(Municipality municipality) throws RemoteException;
  void addRegionalAdmin(RegionalAdmin regionalAdmin) throws RemoteException;
  void registerClient(ClientCallback clientCallback) throws RemoteException;
  void unregisterClient(ClientCallback clientCallback) throws RemoteException;
  ArrayList<MunicipalityList> getMunicipalities() throws RemoteException;
  Municipality getMunicipality() throws RemoteException;
}
