package server.dataaccess;

import shared.transferobjects.User;

import java.sql.SQLException;

public interface UserDAO
{
  User validateUser(User user) throws SQLException;
}
