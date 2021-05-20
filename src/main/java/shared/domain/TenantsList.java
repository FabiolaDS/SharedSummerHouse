package shared.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class TenantsList implements Serializable
{
  private ArrayList<Tenant> tenants;

  public TenantsList(){
    this.tenants = new ArrayList<>();
  }
  public void add(Tenant tenant)
  {
    tenants.add(tenant);
    System.out.println("Tenant added to the list");
  }

  public ArrayList<Tenant> getTenants(){
    return tenants;
  }
  public void remove(Tenant tenant){
    tenants.remove(tenant);
  }

}
