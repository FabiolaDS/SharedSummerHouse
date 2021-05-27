package server.dataaccess;

import shared.domain.Tenant;

import java.sql.SQLException;

public interface TenantDAO
{
  void createTenant(Tenant tenant) throws SQLException;

  Tenant get(String cpr);
}
