package server.model.municipalities;

import server.dataaccess.MunicipalityDAO;
import server.dataaccess.MunicipalityDAOImpl;
import server.dataaccess.RegionalAdminDAO;
import server.dataaccess.RegionalAdminDAOImpl;
import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

/**
 * class Managing all the events related to Municipalities
 *
 * @author Agostina Mezzabotta
 */
public class ServerManageMunicipalitiesImp implements ServerManageMunicipalities
{
  private MunicipalityDAO municipalityDAO;
  private RegionalAdminDAO regionalAdminDAO;

  /**
   * 2-argument constructor allowing the class to acces the Data Access Object classes
   *
   * @param municipalityDAO  DataAccessObject for Municipalities
   * @param regionalAdminDAO DataAccessObject for RegionalAdmins
   */
  public ServerManageMunicipalitiesImp(MunicipalityDAO municipalityDAO,
      RegionalAdminDAO regionalAdminDAO)
  {
    this.municipalityDAO = municipalityDAO;
    this.regionalAdminDAO = regionalAdminDAO;
  }

  @Override public List<Municipality> addMunicipality(Municipality municipality)
  {
    List<Municipality> municipalities = null;

    try
    {
      municipalityDAO.create(municipality.getId(), municipality.getName(),
          municipality.getRegion());
      municipalities = getAllMunicipalities();
    }
    catch (SQLException throwable)
    {
      throwable.printStackTrace();
    }
    return municipalities;
  }

  @Override public List<Municipality> setRegionalAdmin(
      RegionalAdmin regionalAdmin, String municipalityId)
  {
    List<Municipality> municipalities = null;
    try
    {
      RegionalAdmin regionalAdmin1 = regionalAdminDAO
          .create(regionalAdmin.getCpr(), regionalAdmin.getFirstname(),
              regionalAdmin.getMName(), regionalAdmin.getLastname(),
              regionalAdmin.getPassword(), municipalityId);

      Municipality municipality = municipalityDAO.getById(municipalityId);
      municipality.setRegionalAdmin(regionalAdmin1);
      MunicipalityDAOImpl.getInstance().update(municipality);

      municipalities = getAllMunicipalities();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return municipalities;
  }

  public void deleteRegionalAdmin(RegionalAdmin regionalAdmin)
  {
    try
    {
      regionalAdminDAO.delete(regionalAdmin);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void deleteMunicipality(String id) throws SQLException
  {
    Municipality municipality = municipalityDAO.getById(id);
    municipalityDAO.delete(municipality);
  }

  @Override public Municipality getMunicipality(String id)
  {
    Municipality municipality = null;
    try
    {
      municipality = municipalityDAO.getById(id);

    }
    catch (SQLException throwable)
    {
      throwable.printStackTrace();
    }
    return municipality;
  }

  @Override public List<Municipality> getAllMunicipalities() throws SQLException
  {

    return municipalityDAO.getAll();
  }

  @Override public RegionalAdmin getRegionalAdmin(String regionalAdminCPR)
      throws SQLException
  {
    return regionalAdminDAO.getById(regionalAdminCPR);
  }

}
