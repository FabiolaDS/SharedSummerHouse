package server.dataaccess;

import shared.domain.Tenant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TenantDAOImpl extends DatabaseDAO implements TenantDAO
{
  private static TenantDAOImpl instance;

  private TenantDAOImpl() throws SQLException
  {
    super("");
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized TenantDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new TenantDAOImpl();
    }
    return instance;
  }

  @Override public void createTenant(Tenant tenant) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      System.out.println("Connected");

      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO \"shared_summerhouse\".\"tenant\" VALUES (?,?,?,?,?,?,?)");

      statement.setString(1, tenant.getCpr());
      statement.setString(2, tenant.getFirstName());
      statement.setString(3, null);
      statement.setString(4, tenant.getLastName());
      statement.setString(5, tenant.getPassword());
      statement.setString(6, "230689-6323"); //should be changed to getRegionalAdmin
      statement.setString(7, "101"); // should be changed to getMunicipality
      statement.executeUpdate();
    }
  }
}
