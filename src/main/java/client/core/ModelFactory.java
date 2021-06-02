package client.core;

import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.municipalities.ManageMunicipalities;
import client.model.municipalities.ManageMunicipalitiesImpl;
import client.model.tenants.TenantsModel;
import client.model.tenants.ManageTenantsModelImpl;
import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;

/**
 * ModelFactory class creating all the models used in the client side
 */
public class ModelFactory
{
    private static ModelFactory modelFactory;
    private ManageMunicipalities manageMunicipalities;
    private TenantsModel tenantsModel;
    private LoginModel loginModel;

    /**
     * 0-argument private constructor
     */
    private ModelFactory() {}

    /**
     *
     * @return
     */
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
            manageMunicipalities = new ManageMunicipalitiesImpl(ClientFactory.getClientFactory()
                .getClient());
        }
        return manageMunicipalities;
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

    public BookingsManager getBookingsManager() {
        return ClientFactory.getClientFactory().getClient().getBookingsManager();
    }
}
