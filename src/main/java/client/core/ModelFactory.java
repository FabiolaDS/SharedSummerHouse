package client.core;

import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.municipalities.ManageMunicipalities;
import client.model.municipalities.ManageMunicipalitiesImpl;
import client.model.summerhouses.ManageSummerHouses;
import client.model.summerhouses.ManageSummerHousesImpl;
import client.model.tenants.TenantsModel;
import client.model.tenants.ManageTenantsModelImpl;
import shared.businesslogic.SummerHousesManager;

public class ModelFactory
{
    private static ModelFactory modelFactory;
    private ManageMunicipalities manageMunicipalities;
    private ManageSummerHouses manageSummerHouses;
    private TenantsModel tenantsModel;
    private LoginModel loginModel;

    private ModelFactory() {}

    public static ModelFactory getInstance()
    {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public ManageMunicipalities getMunicipalitiesModel()
    {
        if (manageMunicipalities == null) {
            manageMunicipalities = new ManageMunicipalitiesImpl();
        }
        return manageMunicipalities;
    }

    public ManageSummerHouses getSummerHousesModel()
    {
        if (manageSummerHouses == null) {
            manageSummerHouses = new ManageSummerHousesImpl();
        }
        return manageSummerHouses;
    }

    public TenantsModel getTenantsModel()
    {
        if (tenantsModel == null) {
            tenantsModel = new ManageTenantsModelImpl();
        }
        return tenantsModel;
    }

    public LoginModel getLoginModel()
    {
        if (loginModel == null) {
            loginModel = new LoginModelManager(ClientFactory.getClientFactory()
                    .getClient());
        }
        return loginModel;
    }

    public SummerHousesManager getSummerHousesManager() {
        return ClientFactory.getClientFactory().getClient().getSummerHousesManager();
    }
}
