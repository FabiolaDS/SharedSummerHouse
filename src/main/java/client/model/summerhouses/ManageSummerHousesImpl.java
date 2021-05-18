package client.model.summerhouses;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ManageSummerHousesImpl implements ManageSummerHouses{

  private PropertyChangeSupport support;
  private SummerHouse summerHouse;

  public  ManageSummerHousesImpl()
  {
    support = new PropertyChangeSupport(this);

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
