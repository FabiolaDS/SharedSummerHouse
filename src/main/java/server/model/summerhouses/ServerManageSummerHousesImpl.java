package server.model.summerhouses;

import shared.domain.SummerHouse;
import shared.domain.SummerHouseList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ServerManageSummerHousesImpl implements ServerManageSummerhouses
{
  private static ServerManageSummerHousesImpl serverManageSummerHouses;
  private SummerHouseList summerHouseList;
  PropertyChangeSupport support;

  private ServerManageSummerHousesImpl(){
    support = new PropertyChangeSupport(this);
    summerHouseList = new SummerHouseList();
  }

  public static ServerManageSummerHousesImpl getInstance(){
    if (serverManageSummerHouses == null){
      serverManageSummerHouses = new ServerManageSummerHousesImpl();
    }
    return serverManageSummerHouses;
  }


  @Override public SummerHouse addSummerHouse(SummerHouse summerHouse)
  {
    summerHouseList.addSummerHouse(summerHouse);

    return summerHouse;
  }

  @Override public ArrayList<SummerHouse> getSummerHouses()
  {
    return summerHouseList.getSummerHouses();
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null) {
      addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(name, listener);
    }

  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);

  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      removePropertyChangeListener(listener);
    } else {
      support.removePropertyChangeListener(listener);
    }

  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);

  }


}
