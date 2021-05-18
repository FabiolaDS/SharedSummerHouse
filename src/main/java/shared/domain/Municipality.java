package shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Municipality implements Serializable
{
  //made by database
  private String id;
  private String name;
  private String region;
  private ArrayList<SummerHouse> summerhouses;
  private User regionalAdmin;



  public Municipality(String name, String region, String id)
  {
    this.name = name;
    this.region = region;
    this.id = id;
    summerhouses = new ArrayList<>();
    System.out.println("New Municipality has been created");
  }

  public void addSummerHouse(SummerHouse house) {
    summerhouses.add(house);
  }

  public void removeSummerHouse(SummerHouse house) {
    summerhouses.remove(house);
  }

  public ArrayList<SummerHouse> getSummerhouses() {
    return summerhouses;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getRegion()
  {
    return region;
  }

  public void setRegion(String region)
  {
    this.region = region;
  }

  public User getRegionalAdmin()
  {
    return regionalAdmin;
  }

  public void setRegionalAdmin(User regionalAdmin)
  {
    this.regionalAdmin = regionalAdmin;
  }
}
