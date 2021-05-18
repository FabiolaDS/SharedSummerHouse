package server.dataaccess;

import shared.transferobjects.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO
{
  private static UserDAOImpl instance;

  private UserDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized UserDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new UserDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(
        "jdbc:postgresql://hattie.db.elephantsql.com:5432/widfgedd?currentSchema=shared_summerhouse",
        "widfgedd", "eNK-T2F9iLzSsnM_49VIlSkM_qHsQ2nC");
  }

  @Override public String validateUser(User user) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM \"shared_summerhouse\".\"system_admin\" WHERE system_admin_cpr = ?");
      statement.setString(1, user.getUsername());
      ResultSet resultSet = statement.executeQuery();
      String result = "User not found";
      if (resultSet.next())
      {
        String cpr = resultSet.getString("system_admin_cpr");
        String password = resultSet.getString("password");

        // TODO: Maybe this logic should be in the model

        boolean userFound = false;
        System.out.println(cpr + password);
        System.out.println(user.getUsername() + user.getPassword());
        if (cpr.equals(user.getUsername()))
        {
          if (password.equals(user.getPassword()))
          {
            result = "OK";
          }
          else
          {
            result = "Incorrect password";
          }
          userFound = true;
        }
        if (!userFound)
        {
          result = "User not found";
        }
      }
      return result;
    }
  }
}
