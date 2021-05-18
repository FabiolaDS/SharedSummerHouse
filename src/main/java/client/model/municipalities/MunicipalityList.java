package client.model.municipalities;

import shared.domain.Municipality;

import java.util.ArrayList;

public class MunicipalityList
{
  private ArrayList<Municipality> municipalities;

  public MunicipalityList()
  {
    this.municipalities = new ArrayList<>();
  }

  public void add(Municipality municipality)
  {
    municipalities.add(municipality);
    System.out.println("Municipality added to the list");
  }

  public void remove(Municipality municipality)
  {
    municipalities.remove(municipality);
  }


}
