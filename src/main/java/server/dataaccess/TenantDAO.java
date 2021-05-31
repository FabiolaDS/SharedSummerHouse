package server.dataaccess;

import shared.domain.Tenant;

import java.sql.SQLException;
import java.util.List;

public interface TenantDAO
{
  void createTenant(Tenant tenant) throws SQLException;

  Tenant get(String cpr);
  List<Tenant> getAll() throws SQLException;

}
