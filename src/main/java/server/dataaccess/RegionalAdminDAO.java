package server.dataaccess;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.sql.SQLException;
import java.util.List;

/**
 * Class accessing the database
 * @author Agostina Mezzabotta
 */
public interface RegionalAdminDAO
{
  /**
   * Creates a regional admin in the system
   * @param regional_admin_cpr social security number of the RegionalAdministrator
   * @param fname First Name of the regional administrator
   * @param mname middle name of the regional administrator
   * @param lname last name of the regional administrator
   * @param password password choosen for the regional administrator as a user
   * @param municipality_id string identifying the municipality object to include the regional admin
   * @return RegionalAdmin object created
   * @throws SQLException from the database
   */
  RegionalAdmin create(String regional_admin_cpr, String fname, String mname,
      String lname, String password, String municipality_id)
      throws SQLException;
  /**
   * gets a Regional Admin object existent in the system
   * @param id string identifying the RegionalAdministrator
   * @return RegionalAdministrator found
   * @throws SQLException from the database
   */
  RegionalAdmin getById(String id) throws SQLException;
  /**
   * deletes a RegionalAdministrator from the system
   * @param regionalAdmin RegionalAdmin to be deleted
   * @throws SQLException from the database
   */
  void delete(RegionalAdmin regionalAdmin) throws SQLException;

}

