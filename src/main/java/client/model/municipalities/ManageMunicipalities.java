package client.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.util.List;

public interface ManageMunicipalities extends PropertyChangeSubject
{
  public void addMunicipality(Municipality municipality);

  public void addRegionalAdmin(RegionalAdmin regionalAdmin,
      String municipalityId);

  void getNewMunicipalities(PropertyChangeEvent event);

  public Municipality getMunicipality(String id);

  List<Municipality> setMunicipalityList();

  RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR);

  void deleteRegionalAdmin(RegionalAdmin regionalAdmin);
  void deleteMunicipality(String id);
}
