package client.core;

import client.network.RMIClient;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClientFactoryClass
 */
public class ClientFactory
{
  private static ClientFactory clientFactory;
  private RMIClient rmiClient;
  private static Lock lock = new ReentrantLock();

  /**
   * 0-argument private constructor
   */
  private ClientFactory()
  {

  }

  /**
   * static method. Returns a single instance of the ClientFactory class
   * @return ClientFactory
   */
  public static ClientFactory getClientFactory()
  {
    if (clientFactory == null)
    {
      synchronized (lock)
      {
        if (clientFactory == null)
        {
          clientFactory = new ClientFactory();

        }
      }
    }
    return clientFactory;
  }

  /**
   * get a unique instance of the RMIClient class
   * @return
   */
  public RMIClient getClient() {
    if (rmiClient == null)
    {
      rmiClient = new RMIClient();
    }
    return rmiClient;
  }
}
