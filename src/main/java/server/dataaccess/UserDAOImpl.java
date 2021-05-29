package server.dataaccess;

import shared.transferobjects.User;

import java.sql.*;

/**
 * Class implementing the UserDAO interface and extending the DatabaseDAO class.
 * Accesses the database to find the user trying to log in.
 *
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public class UserDAOImpl extends DatabaseDAO implements UserDAO
{
  private static UserDAOImpl instance;

  /**
   * 0-argument constructor for the UserDAOImpl inheriting from DatabaseDAO and
   * setting the postgresql Driver class.
   *
   * @throws SQLException
   */
  private UserDAOImpl() throws SQLException
  {
    super("");
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  /**
   * Singleton returning an instance of the UserDAOImpl.
   *
   * @return instance of the UserDAOImpl.
   * @throws SQLException exceptions from the database
   */
  public static synchronized UserDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new UserDAOImpl();
    }
    return instance;
  }

  @Override public User validateUser(User user) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = null;
      User foundUser = null;
      ResultSet resultSet = null;
      if ("Tenant".equals(user.getUserType()))
      {
        statement = connection.prepareStatement(
            "SELECT * FROM \"shared_summerhouse\".\"tenant\" WHERE tenant_cpr = ?");
        statement.setString(1, user.getUsername());
        resultSet = statement.executeQuery();
        if (resultSet.next())
        {
          String cpr = resultSet.getString("tenant_cpr");
          String password = resultSet.getString("password");
          foundUser = new User(cpr, password, user.getUserType());

        }
      }
      else if ("Regional Admin".equals(user.getUserType()))
      {
        statement = connection.prepareStatement(
            "SELECT * FROM \"shared_summerhouse\".\"regional_admin\" WHERE regional_admin_cpr = ?");
        statement.setString(1, user.getUsername());
        resultSet = statement.executeQuery();
        if (resultSet.next())
        {
          String cpr = resultSet.getString("regional_admin_cpr");
          String password = resultSet.getString("password");
          foundUser = new User(cpr, password, user.getUserType());

        }
      }
      else if ("System Admin".equals(user.getUserType()))
      {
        statement = connection.prepareStatement(
            "SELECT * FROM \"shared_summerhouse\".\"system_admin\" WHERE system_admin_cpr = ?");
        statement.setString(1, user.getUsername());
        resultSet = statement.executeQuery();
        if (resultSet.next())
        {
          String cpr = resultSet.getString("system_admin_cpr");
          String password = resultSet.getString("password");
          foundUser = new User(cpr, password, user.getUserType());
        }
      }

      return foundUser;
    }
  }
}
