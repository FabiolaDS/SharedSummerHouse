package shared.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface extending Remote and implemented by the RMIClient so that it can
 * be called from the server.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public interface ClientCallback extends Remote
{
  /**
   * Listens to the server, receiving updates from it.
   * @param eventType type of event the client listens to
   * @param update type of object it sends
   * @throws RemoteException connection error
   */
  void updates(String eventType, Object update) throws RemoteException;
}
