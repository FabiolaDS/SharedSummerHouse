package shared.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void updateMunicipalities() throws RemoteException;
  void updateMunicipality() throws RemoteException;
}
