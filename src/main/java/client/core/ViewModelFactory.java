package client.core;

import client.network.Client;
import client.network.RMIClient;
import client.view.login.LoginViewModel;
import client.view.regionaladmin.managetenant.addtenant.AddTenantViewModel;
import client.view.regionaladmin.managetenant.viewtenantdetail.TenantDetailsViewModel;
import client.view.systemadmin.addRAmin.AddRegionalAdministratorViewModel;
import client.view.systemadmin.addmunicipality.AddMunicipalityViewModel;
import client.view.systemadmin.seedetails.MunicipalityDetailsViewModel;
import client.view.systemadmin.viewmunicipalities.MainViewModel;
import client.viewmodel.SummerHouseBookingViewModel;
import client.viewmodel.SummerHouseEditViewModel;
import client.viewmodel.SummerHousesListViewModel;

import java.rmi.RemoteException;

/**
 * View Model Factory for accessing view models
 */
public class ViewModelFactory
{
    private static ViewModelFactory vmf;
    private AddTenantViewModel addTenantViewModel;
    private TenantDetailsViewModel tenantDetailsViewModel;
    private AddMunicipalityViewModel addMunicipalityViewModel;
    private AddRegionalAdministratorViewModel addRegionalAdministratorViewModel;
    private MunicipalityDetailsViewModel municipalityDetailsViewModel;
    private MainViewModel mainViewModel;
    private LoginViewModel loginViewModel;
    private ModelFactory modelf;

    /**
     * 1-argument private constructor
     * @param modelf Model Factory
     */
    private ViewModelFactory(ModelFactory modelf)
    {
        this.modelf = modelf;
    }

    /**
     * static method. Gets the unique instance of the ViewModelFactoryClass
     * @return ViewModelFactory instance
     */
    public static ViewModelFactory getInstance()
    {
        if (vmf == null) {
            vmf = new ViewModelFactory(ModelFactory.getInstance());
        }
        return vmf;
    }
    /**
     * gets the AddTenantViewModel
     * @return AddTenantViewModel instance
     */
    public AddTenantViewModel getAddTenantViewModel()
    {
        if (addTenantViewModel == null) {
            addTenantViewModel = new AddTenantViewModel(ModelFactory.getInstance()
                    .getTenantsModel());
        }
        return addTenantViewModel;
    }

    /**
     * gets the TenantDetailsViewModel
     * @return TenantDetailsViewModel
     */
    public TenantDetailsViewModel getTenantDetailsViewModel()
    {
        if (tenantDetailsViewModel == null) {
            tenantDetailsViewModel = new TenantDetailsViewModel(ModelFactory.getInstance().getTenantsModel());
        }
        return tenantDetailsViewModel;
    }

    /**
     * gets the AddMunicipalityViewModel
     * @return AddMunicipalityViewModel
     */
    public AddMunicipalityViewModel addMunicipalityViewModel()
    {
        if (addMunicipalityViewModel == null) {
            addMunicipalityViewModel = new AddMunicipalityViewModel(ModelFactory.getInstance()
                    .getMunicipalitiesModel());
        }
        return addMunicipalityViewModel;
    }

    /**
     * gets AddRegionalAdministratorViewModel
     * @return AddRegionalAdministratorViewModel
     */
    public AddRegionalAdministratorViewModel getAddRegionalAdministratorViewModel()
    {
        if (addRegionalAdministratorViewModel == null) {
            addRegionalAdministratorViewModel = new AddRegionalAdministratorViewModel(ModelFactory.getInstance()
                    .getMunicipalitiesModel());
        }
        return addRegionalAdministratorViewModel;
    }

    /**
     * gets the MunicipalityDetailsViewModel
     * @return MunicipalityDetailsViewModel
     */
    public MunicipalityDetailsViewModel getMunicipalityDetailsViewModel()
    {
        if (municipalityDetailsViewModel == null) {
            municipalityDetailsViewModel = new MunicipalityDetailsViewModel(ModelFactory.getInstance()
                    .getMunicipalitiesModel());
        }
        return municipalityDetailsViewModel;
    }

    /**
     * gets MainViewModel
     * @return MainViewModel
     */
    public MainViewModel getMainViewModel()
    {
        if (mainViewModel == null) {
            mainViewModel = new MainViewModel(ModelFactory.getInstance().getMunicipalitiesModel());
        }
        return mainViewModel;
    }

    /**
     * gets a LoginViewModel
     * @return LoginViewModel
     */
    public LoginViewModel getLoginViewModel()
    {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(ModelFactory.getInstance().getLoginModel());
        }
        return loginViewModel;
    }

    /**
     * gets a AddTenantViewModel
     * @return AddTenantViewModel
     */
    public AddTenantViewModel addTenantViewModel()
    {
        if (addTenantViewModel == null) {
            addTenantViewModel = new AddTenantViewModel(ModelFactory.getInstance()
                    .getTenantsModel());
        }
        return addTenantViewModel;
    }


    private SummerHousesListViewModel shlvm;

    /**
     * gets a SummerHousesListViewModel
     * @return SummerHousesListViewModel
     */
    public SummerHousesListViewModel getSummerHousesListVM()
    {
        try {
            if (shlvm == null) {
                shlvm = new SummerHousesListViewModel(modelf.getSummerHousesManager(),
                        modelf.getLoginModel().getCurrentUser());
            }

            return shlvm;
        } catch(RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    private SummerHouseEditViewModel shevm;

    /**
     * gets a SummerHouseEditViewModel
     * @return SummerHouseEditViewModel
     */
    public SummerHouseEditViewModel getSummerHouseEditVM() {
        if(null == shevm) {
            shevm = new SummerHouseEditViewModel(
                    modelf.getSummerHousesManager(),
                    modelf.getBookingsManager(),
                    modelf.getLoginModel());
        }

        return shevm;
    }

    private SummerHouseBookingViewModel shbvm;

    /**
     * gets a SummerHouseBookingViewModel
     * @return SummerHouseBookingViewModel
     */
    public SummerHouseBookingViewModel getSummerHouseBookingVM() {
        try {
            if (null == shbvm) {
                shbvm = new SummerHouseBookingViewModel(
                        modelf.getBookingsManager(),
                        modelf.getLoginModel());
            }

            return shbvm;
        } catch(RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
