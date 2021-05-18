package client.core;

import client.network.RMIClient;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientFactory
{
  private static ClientFactory clientFactory;
  private RMIClient rmiClient;
  private static Lock lock = new ReentrantLock();


  private ClientFactory()
  {

  }
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

  public RMIClient getClient() {
    if (rmiClient == null)
    {
      rmiClient = new RMIClient();
    }
    return rmiClient;
  }
}
