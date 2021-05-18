package client.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public interface ManageMunicipalities
{
  public void addMunicipality(Municipality municipality);
  public void addRegionalAdmin(RegionalAdmin regionalAdmin, Municipality municipality);
  //public ArrayList<Municipality> getMunicipalities();
  void getMunicipalities(PropertyChangeEvent event);
  public Municipality getMunicipality(Long id);
}
