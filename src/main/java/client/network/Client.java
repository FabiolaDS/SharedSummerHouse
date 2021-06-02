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
   * @param user user trying to login
   */
  void login(User user);

  /**
   * Unregister the client from the server as a listener.
   */
  void unregisterClient();

  /** Starts the client. Export the client as a remote object, locates the
   * server registry and looks for the server. Finally, it registers the client
   * as a listener of the server.
   */
  void startClient();
  /**
   *
   * @param tenant - Create a new tenant in the system
   */
  void addTenant(Tenant tenant);

  BookingsManager getBookingsManager();

  ArrayList<Tenant> getTenants();

  SummerHousesManager getSummerHousesManager();
  /**
   * getting all the tenants from the system
   * @return a tenant list
   */
  List<Tenant> getAllTenants();

  /**
   *
   * @param municipality object Municipality to be created in the system
   * @author Agostina Mezzabotta
   */
  void addMunicipality(Municipality municipality);
  /**
   * asks to the server to create a Regional Administrator and assign to a Municipality already existent
   * @param regionalAdmin the municipality's employee to be assigned as administrator
   * @param municipalityId the municipality to be updated
   * @author Agostina Mezzabotta
   */
  void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);
  /**
   * removes a RegionalAdmin object from the system
   * @param regionalAdmin Regional admin object to be deleted from the system
   */
  void deleteRegionalAdmin(RegionalAdmin regionalAdmin);
  /**
   *removes a RegionalAdmin from the system
   * @param id String id to identify the municipality to be deleted
   */
  void deleteMunicipality(String id);
  /**
   * gets a municipality using an id to identify it
   * @param id attribute identifying the Municipality object
   * @return Municipality
   */
  Municipality getMunicipality(String id);
  /**
   * this method gets a list with all the municipalities registered in the system
   * @return a municipality list
   */
  List<Municipality> getAllMunicipalities();
  /**
   * retrieves a RegionalAdministrator using the cpr number to identify it
   * @param regionalAdminCPR employee's social security number
   * @return RegionalAdministrator object
   */
  RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR);

}
