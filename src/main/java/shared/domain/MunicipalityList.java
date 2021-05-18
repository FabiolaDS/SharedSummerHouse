package shared.domain;

import shared.domain.Municipality;

import java.util.ArrayList;
import java.util.List;

public class MunicipalityList
{
  private List<Municipality> municipalities;

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
