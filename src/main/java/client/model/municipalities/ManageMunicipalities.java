package client.model.municipalities;

import shared.domain.Municipality;

import java.util.ArrayList;

public interface ManageMunicipalities
{
  public void addMunicipality(Municipality municipality);
  public void addRegionalAdmin(RegionalAdmin regionalAdmin, Municipality municipality);
  public ArrayList<Municipality> getMunicipalities();
  public Municipality getMunicipality(Long id);
}
