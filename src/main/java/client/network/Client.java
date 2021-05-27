package client.network;

import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;
import shared.domain.*;
import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Client interface extending PropertyChangeSubject.
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public interface Client extends PropertyChangeSubject
{
  /**
   * Sends the user object ot the server for validation and when validation is
   * received, it fires a property to the model with the result.
   * @param user
   */
  void login(User user);

  void addMunicipality(Municipality municipality);

  void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);

  /**
   * Unregister the client from the server as a listener.
   */
  void unregisterClient();

  Municipality getMunicipality(String id);

  /** Starts the client. Export the client as a remote object, locates the
   * server registry and looks for the server. Finally, it registers the client
   * as a listener of the server.
   */
  void startClient();

  void addTenant(Tenant tenant);

  BookingsManager getBookingsManager();

  ArrayList<Tenant> getTenants();

  SummerHousesManager getSummerHousesManager();

  List<Municipality> getAllMunicipalities();

  RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR);

  void deleteRegionalAdmin(RegionalAdmin regionalAdmin);

  void deleteMunicipality(String id);
}
