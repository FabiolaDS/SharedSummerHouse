package shared.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Base interface for observables over RMI
 *
 * @author Fabiola
 */
public interface RemoteChangeSubject extends Remote
{

    /**
     * Adds remote listener to be triggered on state change
     *
     * @param rcl       remote listener to be notified on state change
     *
     * @throws RemoteException  Remote interface
     */
    void addListener(RemoteChangeListener rcl) throws RemoteException;

    /**
     * Stop remote listener from being notified on state change
     *
     * @param rcl   remote listener to remove
     *
     * @throws RemoteException  Remote interface
     */
    void removeListener(RemoteChangeListener rcl) throws RemoteException;
}
