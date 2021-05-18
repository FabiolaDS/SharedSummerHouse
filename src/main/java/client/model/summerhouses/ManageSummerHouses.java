package client.model.summerhouses;

import java.util.ArrayList;

public interface ManageSummerHouses
{

  public void addSummerHouse(SummerHouse summerHouse);
  public ArrayList<SummerHouse> getAllSummerHouses();
  public SummerHouse getSummerHouse(int id);
}
