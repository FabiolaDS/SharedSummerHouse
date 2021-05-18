package client.core;

import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.municipalities.ManageMunicipalities;
import client.model.municipalities.ManageMunicipalitiesImpl;
import client.model.summerhouses.ManageSummerHouses;
import client.model.summerhouses.ManageSummerHousesImpl;
import client.model.tenants.ManageTenants;
import client.model.tenants.ManageTenantsImpl;

public class ModelFactory
{
  private static ModelFactory modelFactory;
  private ManageMunicipalities manageMunicipalities;
  private ManageSummerHouses manageSummerHouses;
  private ManageTenants manageTenants;
  private LoginModel loginModel;

  private ModelFactory()
  {

  }
  public static ModelFactory getInstance()
  {
    if (modelFactory == null)
    {
      modelFactory = new ModelFactory();
    }
    return modelFactory;
  }

  public ManageMunicipalities getMunicipalitiesModel()
  {
    if (manageMunicipalities == null)
    {
      manageMunicipalities = new ManageMunicipalitiesImpl();
    }
    return manageMunicipalities;
  }

  public ManageSummerHouses getSummerHousesModel()
  {
    if (manageSummerHouses == null)
    {
      manageSummerHouses = new ManageSummerHousesImpl();
    }
    return manageSummerHouses;
  }

  public ManageTenants getTenantsModel()
  {
    if (manageTenants == null)
    {
      manageTenants = new ManageTenantsImpl();
    }
    return manageTenants;
  }

  public LoginModel getLoginModel()
  {
    if (loginModel == null)
    {
      loginModel = new LoginModelManager(ClientFactory.getClientFactory()
          .getClient());
    }
    return loginModel;
  }
}
