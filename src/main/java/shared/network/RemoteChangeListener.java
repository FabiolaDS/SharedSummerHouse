package shared.network;

import java.beans.PropertyChangeEvent;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteChangeListener extends Remote
{
    void propertyChange(PropertyChangeEvent evt) throws RemoteException;
}
