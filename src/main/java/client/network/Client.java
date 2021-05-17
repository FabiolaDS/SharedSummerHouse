package client.network;

import shared.domain.Municipality;
import client.model.municipalities.MunicipalityList;
import client.model.municipalities.RegionalAdmin;
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
