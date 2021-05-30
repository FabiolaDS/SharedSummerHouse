package server.model.tenants;

import shared.domain.Tenant;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;
import java.util.List;

public interface ServerManageTenants extends PropertyChangeSubject
{
  Tenant addTenant(Tenant tenant) throws SQLException;

  List<Tenant> getAllTenants() throws SQLException;


}
