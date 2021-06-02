package server.dataaccess;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DummyRegionalAdminDAO implements RegionalAdminDAO
{
  private List<RegionalAdmin> regionalAdmins;

  public DummyRegionalAdminDAO()
  {
    regionalAdmins = new ArrayList<>();
  }

  @Override public RegionalAdmin create(String regional_admin_cpr, String fname,
      String mname, String lname, String password, String municipality_id)
      throws SQLException
  {
    RegionalAdmin regionalAdmin = new RegionalAdmin(regional_admin_cpr,fname,lname,mname,password);
    regionalAdmins.add(regionalAdmin);

    return regionalAdmin;
  }

  @Override public RegionalAdmin getById(String id) throws SQLException
  {
    RegionalAdmin regionalAdmin= null;
    for (int i = 0; i < regionalAdmins.size(); i++)
    {
      if (regionalAdmins.get(i).getCpr().equals(id))
      {
        regionalAdmin = regionalAdmins.get(i);
      }
    }
  if (regionalAdmin != null)
  {
    return regionalAdmin;
  }
  else{
    throw new NullPointerException("Regional admin does not exists");
  }
  }

  @Override public void delete(RegionalAdmin regionalAdmin) throws SQLException
  {
   if (regionalAdmin == null)
   {
     throw new IllegalArgumentException("Regional admin does not exist");
   }
   else{
     for (int i = 0; i < regionalAdmins.size(); i++)
     {
       if (regionalAdmins.get(i).getCpr().equals(regionalAdmin.getCpr()))
       {
         regionalAdmins.remove(i);
       }

     }
   }
  }
}
