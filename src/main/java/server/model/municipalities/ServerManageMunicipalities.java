package server.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for ManageMunicipalities server
 * @author Agostina Mezzabotta
 */
public interface ServerManageMunicipalities
{
  /**
   * registers a municipality in the system
   * @param municipality the Municipality to be created
   * @return an updated list of all the municipalities existent
   * @throws SQLException from the DAO classes connecting to the database
   */
  List<Municipality> addMunicipality(Municipality municipality) throws SQLException;
  /**
   * Creates a new RegionalAdministrator and assigns it to a existent municipality
   * @param regionalAdmin Object to be registered in the system
   * @param municipalityId Id used to fetch the right id
   * @return a list with the updated municipalities in the system
   * @throws SQLException from the DAO classes connecting to the database
   */
  List<Municipality> setRegionalAdmin(RegionalAdmin regionalAdmin,
                                      String municipalityId) throws SQLException;
  /**
   * gets a desired id from the system
   * @param id String identifying the municipality
   * @return a municipality Object
   * @throws SQLException from the DAO class connecting to the database
   */
  Municipality getMunicipality(String id) throws SQLException;
  /**
   * gets all the registered municipalities
   * @return a list of municipalities
   * @throws SQLException from the DAO class connecting to the database
   */
  List<Municipality> getAllMunicipalities() throws SQLException;
  /**
   * gets a regional admin using the id
   * @param regionalAdminCPR RegionalAdmin's id
   * @return RegionalAdmin
   * @throws SQLException from the DAO class connecting to the database
   */
  RegionalAdmin getRegionalAdmin(String regionalAdminCPR) throws SQLException;
  /**
   * delete admin from the system
   * @param regionalAdmin the RegionalAdmin to be deleted
   * @throws SQLException from the DAO class connecting to the database
   */
  void deleteRegionalAdmin(RegionalAdmin regionalAdmin) throws SQLException;
  /**
   * delete municipality from the system
   * @param id to identify the municipality
   * @throws SQLException from the DAO class connecting to the database
   */
  void deleteMunicipality(String id) throws SQLException;
}
