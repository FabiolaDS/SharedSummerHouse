package shared.network;

import java.beans.PropertyChangeEvent;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Base interface for listener in observer pattern implemented over RMI
 *
 * @author Fabiola
 */
public interface RemoteChangeListener extends Remote
{

    /**
     * Method to be called on state change
     *
     * @param evt       event object containing info about the state change
     *
     * @throws RemoteException  Remote interface
     */
    void propertyChange(PropertyChangeEvent evt) throws RemoteException;
}
