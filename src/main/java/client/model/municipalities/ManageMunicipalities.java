package client.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 * Interface for ManageMunicpalities. Creates, gets and deletes Municipalities and RegionalAdmins
 * @author Agostina Mezzabotta
 * @version 1.0
 */
public interface ManageMunicipalities extends PropertyChangeSubject
{
  /**
   * method listening to an event happening in the client side and notifying to other classes
   * @param propertyChangeEvent event listened from the client
   */
  void updateRegionalAdmin(PropertyChangeEvent propertyChangeEvent);
  /**
   * method sending the Municipality object to the client
   * @param municipality new Municipality to register in the system
   */
  void addMunicipality(Municipality municipality);
  /**
   * Sets a new regional administrator to a Municipality already existent
   * @param regionalAdmin the employee responsible for the municipality
   * @param municipalityId the municipality to be updated
   */
  void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);
  /**
   * method listening to an event happening in the client side and notifying to other classes
   * @param event event listened from the client
   */
  void getNewMunicipalities(PropertyChangeEvent event);
  /**
   * method retrieving a municipality given and id
   * @param id String representing the Municipality required
   * @return a Municipality object
   */
  Municipality getMunicipality(String id);
  /**
   * method getting all the municipalities existent in the system
   * @return a list of Municipalities
   */
  List<Municipality> setMunicipalityList();
  /**
   * method getting a regional administrator registered in the system
   * @param regionalAdminCPR Regional Administrator's social security number
   * @return a RegionalAdmin object
   */
  RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR);
  /**
   * deletes a regional admin from the system
   * @param regionalAdmin object RegionalAdmin to be deleted
   */
  void deleteRegionalAdmin(RegionalAdmin regionalAdmin);
  /**
   * deletes a municipality from the system.
   * @param id string representing the id og the municipality to be deleted
   */
  void deleteMunicipality(String id);
}
