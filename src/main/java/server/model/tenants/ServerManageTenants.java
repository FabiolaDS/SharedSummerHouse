package server.model.tenants;

import shared.domain.Tenant;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;

public interface ServerManageTenants extends PropertyChangeSubject
{
  Tenant addTenant(Tenant tenant) throws SQLException;
}
