package server.model.tenants;

import shared.domain.Tenant;
import shared.util.PropertyChangeSubject;

public interface ServerManageTenants extends PropertyChangeSubject
{
  Tenant addTenant(Tenant tenants);
}
