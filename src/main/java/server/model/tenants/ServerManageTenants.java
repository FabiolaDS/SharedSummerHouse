package server.model.tenants;

import shared.domain.Tenant;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for ManageTenants server
 * @author alina
 */

public interface ServerManageTenants extends PropertyChangeSubject
    /**
     * create a tenant in the system
     */
{
  Tenant addTenant(Tenant tenant) throws SQLException;
  /**
   * get all the registered tenants
   * @return a list of tenants
   * @throws SQLException from the DAO class connecting to the database
   */
  List<Tenant> getAllTenants() throws SQLException;


}
