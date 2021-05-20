package client.model.summerhouses;

import shared.domain.SummerHouse;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public interface ManageSummerHouses extends PropertyChangeSubject
{

  public void addSummerHouse(SummerHouse summerHouse);
  public ArrayList<SummerHouse> getAllSummerHouses();
  public SummerHouse getSummerHouse(int id);
  void getSummerHouses(PropertyChangeEvent event);

}
