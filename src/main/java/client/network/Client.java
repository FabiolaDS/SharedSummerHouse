package client.network;

import client.model.municipalities.Municipality;
import client.model.municipalities.MunicipalityList;
import client.model.municipalities.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface Client extends PropertyChangeSubject
{
  void addMunicipality(Municipality municipality);
  void addRegionalAdmin(RegionalAdmin regionalAdmin);
  void unregisterClient();
  ArrayList<MunicipalityList> getMunicipalities();
  Municipality getMunicipality();
  void startClient();
}