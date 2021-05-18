package client.network;

import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;
import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface Client extends PropertyChangeSubject
{
  void login(User user);
  void addMunicipality(Municipality municipality);
  void addRegionalAdmin(RegionalAdmin regionalAdmin);
  void unregisterClient();
  ArrayList<MunicipalityList> getMunicipalities();
  Municipality getMunicipality();
  void startClient();
}
