package client.model.summerhouses;

import client.core.ClientFactory;
import client.network.Client;
import shared.domain.SummerHouse;
import shared.domain.SummerHouseList;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ManageSummerHousesImpl implements ManageSummerHouses{

  private PropertyChangeSupport support;
  private SummerHouseList summerHouseList;
  private Client client;

  public  ManageSummerHousesImpl()
  {
    support = new PropertyChangeSupport(this);
    summerHouseList = new SummerHouseList();
    client = ClientFactory.getClientFactory().getClient();
    client.addPropertyChangeListener(EventType.SUMMERHOUSE.toString(), this::getSummerHouse);

  }

  private void getSummerHouse(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void addSummerHouse(SummerHouse summerHouse)
  {
    client.addSummerHouse(summerHouse);

  }

  @Override public void getSummerHouses(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public ArrayList<SummerHouse> getAllSummerHouses()
  {
    return null;
  }

  @Override public SummerHouse getSummerHouse(int id)
  {
return null;
  }
}
