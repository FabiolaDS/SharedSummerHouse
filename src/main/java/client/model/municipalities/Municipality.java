package client.model.municipalities;

import java.util.ArrayList;

public class Municipality
{


  private int id;
  private String name;
  private String region;

  public Municipality(int id, String name, String region)
  {
    this.id = id;
    this.name = name;
    this.region = region;
  }

  public void addRegionalAdmin(RegionalAdmin regionalAdmin)
  {}
  public ArrayList<Municipality> getMunicipalities;

  public int getMunicipality(int id)
  {
    return id;
  }
}
