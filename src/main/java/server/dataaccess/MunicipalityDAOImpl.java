package server.dataaccess;

import shared.domain.Municipality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityDAOImpl extends DatabaseDAO implements MunicipalityDAO
{

  private static MunicipalityDAOImpl instance;

  private MunicipalityDAOImpl() throws SQLException
  {
    super("municipality");
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized MunicipalityDAOImpl getInstance()
      throws SQLException
  {
    if (instance == null)
    {
      instance = new MunicipalityDAOImpl();
    }
    return instance;
  }

  @Override public Municipality create(String municipality_id, String name,
      String region) throws SQLException
  {

    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO \"shared_summerhouse\".\"municipality\" VALUES (?, ?, ?, ?, ?)");
      statement.setString(1, municipality_id);
      statement.setString(2, name);
      statement.setString(3, region);
      statement.setString(4, "180576-2412");
      statement.setString(5, null);
      statement.executeUpdate();
      return new Municipality(name, region, municipality_id);
    }

  }

  @Override public Municipality getById(String municipality_id)
      throws SQLException
  {
    Municipality municipality = null;
    try (Connection connection = getConnection())
    {

      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"shared_summerhouse\".\"municipality\" WHERE municipality_id = ?");
      statement.setString(1, municipality_id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String name = resultSet.getString("name");
        String region = resultSet.getString("region");
        String regional_admin_cpr = resultSet.getString("regional_admin_cpr");

        if (regional_admin_cpr == null)
        {
          municipality = new Municipality(name, region, municipality_id);
        }
               else if (municipality_id != null)
                {
                    municipality = new Municipality(name,region,municipality_id,regional_admin_cpr);
                }
      }

            /* else if  (municipality_id != null)
             {
                municipality = new Municipality("-", "-", "-");
            }*/
    }
    return municipality;
  }

  @Override public List<Municipality> getAll() throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"shared_summerhouse\".\"municipality\" LIMIT 100");

      ResultSet resultSet = statement.executeQuery();
      ArrayList<Municipality> result = new ArrayList<>();
      while (resultSet.next())
      {
        String name = resultSet.getString("name");
        String region = resultSet.getString("region");
        String municipality_id = resultSet.getString("municipality_id");
        String regional_admin_cpr = resultSet.getString("regional_admin_cpr");

        Municipality municipality = null;
        if (regional_admin_cpr == null)
        {
          municipality = new Municipality(name, region, municipality_id);
        }
        else
        {
          municipality = new Municipality(name, region, municipality_id,
              regional_admin_cpr);
        }

        result.add(municipality);
      }
      return result;

    }
  }

  @Override public void update(Municipality municipality) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE \"shared_summerhouse\".\"municipality\" SET regional_admin_cpr = ? WHERE municipality_id = ?");
      statement.setString(1, municipality.getRegionalAdminCPR());
      statement.setString(2, municipality.getId());
      statement.executeUpdate();
    }
  }
  @Override public void delete(Municipality municipality) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "DELETE FROM \"shared_summerhouse\".\"municipality\" WHERE municipality_id = ?");
      statement.setString(1, municipality.getId());
      statement.executeUpdate();
    }
  }
}

