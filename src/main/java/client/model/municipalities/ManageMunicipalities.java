package client.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ManageMunicipalities extends PropertyChangeSubject
{
  public void addMunicipality(Municipality municipality);
  public void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);
  //public ArrayList<Municipality> getMunicipalities();
  void getMunicipalities(PropertyChangeEvent event);
  public Municipality getMunicipality(Long id);
}
