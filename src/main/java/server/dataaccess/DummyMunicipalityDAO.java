package server.dataaccess;

import shared.domain.Municipality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DummyMunicipalityDAO implements MunicipalityDAO
{

  private List<Municipality> municipalities;

  public DummyMunicipalityDAO()
  {
    municipalities = new ArrayList<>();
  }

  @Override public Municipality create(String id, String name, String region)
      throws SQLException
  {
    if ((id.length() != 3 )|| (!id.matches("[0-9]+"))
        || (!isAvailable(id)))
    {
      throw new IllegalArgumentException();
    }

      Municipality municipality = new Municipality(name, region, id);
      municipalities.add(municipality);
      return municipality;

  }

  @Override public Municipality getById(String id) throws SQLException
  {
    Municipality municipality = null;
    if (id.length() != 3 || !id.matches("[0-9]+"))
    {
      throw new IllegalArgumentException();
    }

    else
    {
      for (int i = 0; i < municipalities.size(); i++)
      {
        if (municipalities.get(i).getId().equals(id))
        {
          municipality = municipalities.get(i);
        }
      }

    }

    return municipality;
  }

  @Override public List<Municipality> getAll() throws SQLException
  {
    return municipalities;
  }

  @Override public void update(Municipality municipality) throws SQLException
  {
    for (int i = 0; i < municipalities.size(); i++)
    {
      if (municipalities.get(i).getId().equals(municipality.getId()))
      {
        municipalities.get(i).setRegionalAdmin(municipality.getRegionalAdmin());
      }
    }

  }

  @Override public void delete(Municipality municipality) throws SQLException
  {
    if (municipality.getRegionalAdmin() == null){

      municipalities.remove(municipality);
    }
    else{
      throw new SQLException();
    }

  }

  private boolean isAvailable(String id) throws SQLException
  {
    Municipality municipality = getById(id);
    return municipality == null;
  }
}
