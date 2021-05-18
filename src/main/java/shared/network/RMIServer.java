package shared.network;


import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;
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
  Municipality getMunicipality(Long id) throws RemoteException;// what does that do(return one munip)So which one(need argthen) - yes that is why it isnt compling
}
