package client.network;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject
{
  void login(User user);
  void addMunicipality(Municipality municipality);
  void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);
  void unregisterClient();
  Municipality getMunicipality(String id);
  void startClient();
}
