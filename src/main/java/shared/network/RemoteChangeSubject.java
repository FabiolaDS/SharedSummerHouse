package shared.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

// observable via RMI
public interface RemoteChangeSubject extends Remote
{
    void addListener(RemoteChangeListener rcl) throws RemoteException;

    void removeListener(RemoteChangeListener rcl) throws RemoteException;
}
