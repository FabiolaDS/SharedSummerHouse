package shared.domain;

import shared.domain.Municipality;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityList implements Serializable
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

  public void setRegionalAdministrator(RegionalAdmin regionalAdmin, String id)
  {
    Municipality municipality = getMunicipalityById(id);
    municipality.setRegionalAdmin(regionalAdmin);
  }

  public Municipality getMunicipalityById(String id)
  {
    Municipality municipality = null;

    for (int i = 0; i < municipalities.size(); i++)
    {
      if (municipalities.get(i).getId().equals(id))
      {
        municipality = municipalities.get(i);
      }

    }
    return municipality;
  }

  public List<Municipality> getMunicipalities() {
    return municipalities;
  }

  public void remove(Municipality municipality)
  {
    municipalities.remove(municipality);
  }

  public Municipality getMunicipalityByIndex(int index)
  {
    return  municipalities.get(index);
  }



}
