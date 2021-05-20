package shared.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class SummerHouseList implements Serializable
{
  private ArrayList<SummerHouse> summerHouses;


  public SummerHouseList(){
    this.summerHouses = new ArrayList<>();
  }

  public void addSummerHouse(SummerHouse summerHouse){
    summerHouses.add(summerHouse);
    System.out.println("Summerhouse added to the list");

  }
  public ArrayList<SummerHouse> getSummerHouses(){
    return summerHouses;

  }
  public void removeSummerHouse(int id)
  {
    summerHouses.remove(id);
  }

  public SummerHouse getSummerHousesIndex(int index)
  {
    return summerHouses.get(index);
  }
}
