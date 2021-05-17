package shared.network;

import server.model.municipalities.Municipality;
import server.model.municipalities.MunicipalityList;
import server.model.municipalities.RegionalAdmin;
import shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIServer extends Remote
{
  String validateUser(User request) throws RemoteException, SQLException;
  void addMunicipality(Municipality municipality) throws RemoteException;
  void addRegionalAdmin(RegionalAdmin regionalAdmin) throws RemoteException;
  void registerClient(ClientCallback clientCallback) throws RemoteException;
  void unregisterClient(ClientCallback clientCallback) throws RemoteException;
  ArrayList<MunicipalityList> getMunicipalities() throws RemoteException;
  Municipality getMunicipality() throws RemoteException;// what does that do(return one munip)So which one(need argthen)
}
