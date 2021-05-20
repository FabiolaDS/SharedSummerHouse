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
  Municipality addMunicipality(Municipality municipality) throws RemoteException;
  Municipality getMunicipality(String id) throws RemoteException;
  Municipality addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId ) throws RemoteException;
  void registerClient(ClientCallback clientCallback) throws RemoteException;
  void unregisterClient(ClientCallback clientCallback) throws RemoteException;
}
