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

public class ServerManageMunicipalitiesImp implements ServerManageMunicipalities
{
  private MunicipalityDAO municipalityDAO;
  private RegionalAdminDAO regionalAdminDAO;
  PropertyChangeSupport support;

  public ServerManageMunicipalitiesImp(MunicipalityDAO municipalityDAO, RegionalAdminDAO regionalAdminDAO)
  {
    this.municipalityDAO = municipalityDAO;
    this.regionalAdminDAO = regionalAdminDAO;
    support = new PropertyChangeSupport(this);
  }

  @Override public List<Municipality> addMunicipality(Municipality municipality)
      throws SQLException
  {
    try
    {
      municipalityDAO
          .create(municipality.getId(), municipality.getName(),
              municipality.getRegion());
    }
    catch (SQLException throwable)
    {
      throwable.printStackTrace();
    }
    return getAllMunicipalities();
  }

  @Override public List<Municipality> setRegionalAdmin(
      RegionalAdmin regionalAdmin, String municipalityId)
  {
    List<Municipality> municipalities = null;
    try
    {
      //FIRST: Create Regional Administrator
      RegionalAdmin regionalAdmin1 = regionalAdminDAO
          .create(regionalAdmin.getCpr(), regionalAdmin.getFirstname(),
              regionalAdmin.getMName(), regionalAdmin.getLastname(),
              regionalAdmin.getPassword(), municipalityId);
      System.out.println(regionalAdmin);

      //SECOND: update municipality
      Municipality municipality = municipalityDAO
          .getById(municipalityId);
      municipality.setRegionalAdmin(regionalAdmin1);
      System.out.println(municipality.getRegionalAdminCPR());
      MunicipalityDAOImpl.getInstance().update(municipality);

      //THIRD: update list of municipalities with the changes
      municipalities = municipalityDAO.getAll();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return municipalities;
  }

  public void deleteRegionalAdmin(RegionalAdmin regionalAdmin){
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

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(listener);
    }
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
