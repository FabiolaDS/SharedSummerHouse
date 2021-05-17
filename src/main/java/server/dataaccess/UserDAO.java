package server.dataaccess;

import shared.transferobjects.User;

import java.sql.SQLException;

public interface UserDAO
{
  String validateUser(User user) throws SQLException;
}
