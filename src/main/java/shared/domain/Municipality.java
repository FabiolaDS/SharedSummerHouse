package shared.domain;

import java.util.ArrayList;

public class Municipality
{
  //made by database
  private Long id;
  private String name;
  private String region;
  private ArrayList<SummerHouse> summerhouses;
  private User regionalAdmin;

  public Municipality(String name, String region, User regionalAdmin)
  {
    this.name = name;
    this.region = region;
    this.regionalAdmin = regionalAdmin;
    summerhouses = new ArrayList<>();
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

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
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