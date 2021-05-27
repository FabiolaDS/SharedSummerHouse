package server.dataaccess;

import shared.transferobjects.User;

import java.sql.SQLException;

/**
 * Interface that accesses the database to look for the user's credentials
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public interface UserDAO
{
  /**
   * Looks for the user in the database using username and checking the password
   * depending on what type of user it is. If it is a tenant it looks in the
   * tenants table, if it is a regional admin, in the regional admins table,
   * if it is a system admin, in the system admins table.
   * @param user user trying to log in.
   * @return the user found
   * @throws SQLException exceptions from the database
   */
  User validateUser(User user) throws SQLException;
}
