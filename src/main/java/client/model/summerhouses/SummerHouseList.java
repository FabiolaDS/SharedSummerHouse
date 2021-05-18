package client.model.summerhouses;

import java.util.ArrayList;

public class SummerHouseList
{
  private ArrayList<SummerHouse> summerHouses;
  private SummerHouse summerHouse;

  public SummerHouseList(){
    this.summerHouses = new ArrayList<>();
  }

  public void addSummerHouse(SummerHouse summerHouse){
    summerHouses.add(summerHouse);

  }
  public ArrayList<SummerHouse> getSummerHouses(){
    ArrayList<SummerHouse> summerHouses = new ArrayList<>();
    for (int i = 0; i < summerHouses.size(); i++)
    {
      summerHouses.get(i);

    }
    return summerHouses;

  }
  public void removeSummerHouse(int id)
  {
    summerHouses.remove(id);
  }
}
