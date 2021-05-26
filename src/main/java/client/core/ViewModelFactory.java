package client.core;

import client.network.Client;
import client.network.RMIClient;
import client.view.login.LoginViewModel;
import client.view.regionaladmin.managesummerhouse.addsummerhouse.AddSummerHouseViewModel;
import client.view.regionaladmin.managesummerhouse.viewsummerhouse.ManageSummerHouseModel;
import client.view.regionaladmin.managetenant.addtenant.AddTenantViewModel;
import client.view.regionaladmin.managetenant.viewtenantdetail.TenantDetailsViewModel;
import client.view.systemadmin.addRAmin.AddRegionalAdministratorViewModel;
import client.view.systemadmin.addmunicipality.AddMunicipalityViewModel;
import client.view.systemadmin.seedetails.MunicipalityDetailsViewModel;
import client.view.systemadmin.viewmunicipalities.MainViewModel;
import client.viewmodel.SummerHouseEditViewModel;
import client.viewmodel.SummerHousesListViewModel;

import java.rmi.RemoteException;

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
    private AddSummerHouseViewModel addSummerHouseViewModel;
    private ManageSummerHouseModel manageSummerHouseModel;

    private ModelFactory modelf;

    private ViewModelFactory(ModelFactory modelf)
    {
        this.modelf = modelf;
    }

    public static ViewModelFactory getInstance()
    {
        if (vmf == null) {
            vmf = new ViewModelFactory(ModelFactory.getInstance());    // singleton does not allow for dependency injectioN
        }
        return vmf;
    }

    public AddTenantViewModel getAddTenantViewModel()
    {
        if (addTenantViewModel == null) {
            addTenantViewModel = new AddTenantViewModel(ModelFactory.getInstance()
                    .getTenantsModel());
        }
        return addTenantViewModel;
    }

    public TenantDetailsViewModel getTenantDetailsViewModel()
    {
        if (tenantDetailsViewModel == null) {
            tenantDetailsViewModel = new TenantDetailsViewModel(ModelFactory.getInstance().getTenantsModel());
        }
        return tenantDetailsViewModel;
    }

    public AddMunicipalityViewModel addMunicipalityViewModel()
    {
        if (addMunicipalityViewModel == null) {
            addMunicipalityViewModel = new AddMunicipalityViewModel(ModelFactory.getInstance()
                    .getMunicipalitiesModel());
        }
        return addMunicipalityViewModel;
    }

    public AddRegionalAdministratorViewModel getAddRegionalAdministratorViewModel()
    {
        if (addRegionalAdministratorViewModel == null) {
            addRegionalAdministratorViewModel = new AddRegionalAdministratorViewModel(ModelFactory.getInstance()
                    .getMunicipalitiesModel());
        }
        return addRegionalAdministratorViewModel;
    }

    public MunicipalityDetailsViewModel getMunicipalityDetailsViewModel()
    {
        if (municipalityDetailsViewModel == null) {
            municipalityDetailsViewModel = new MunicipalityDetailsViewModel(ModelFactory.getInstance()
                    .getMunicipalitiesModel());
        }
        return municipalityDetailsViewModel;
    }

    public MainViewModel getMainViewModel()
    {
        if (mainViewModel == null) {
            mainViewModel = new MainViewModel(ModelFactory.getInstance().getMunicipalitiesModel());
        }
        return mainViewModel;
    }

    public LoginViewModel getLoginViewModel()
    {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(ModelFactory.getInstance().getLoginModel());
        }
        return loginViewModel;
    }

    public AddSummerHouseViewModel addSummerHouseViewModel()
    {
        if (addSummerHouseViewModel == null) {
            addSummerHouseViewModel = new AddSummerHouseViewModel(ModelFactory.getInstance()
                    .getSummerHousesModel());
        }
        return addSummerHouseViewModel;
    }

    public ManageSummerHouseModel getManageSummerHouseModel()
    {

        if (manageSummerHouseModel == null) {
            manageSummerHouseModel = new ManageSummerHouseModel(
                    ModelFactory.getInstance().getSummerHousesModel());
        }
        return manageSummerHouseModel;
    }


    public AddTenantViewModel addTenantViewModel()
    {
        if (addTenantViewModel == null) {
            addTenantViewModel = new AddTenantViewModel(ModelFactory.getInstance()
                    .getTenantsModel());
        }
        return addTenantViewModel;
    }


    private SummerHousesListViewModel shlvm;

    public SummerHousesListViewModel getSummerHousesListVM()
    {
        try {
            if (shlvm == null) {
                shlvm = new SummerHousesListViewModel(modelf.getSummerHousesManager(),
                        modelf.getLoginModel().getCurrentUser());
            }
        } catch(RemoteException e) {
            throw new RuntimeException(e);
        }
        return shlvm;
    }

    private SummerHouseEditViewModel shevm;

    public SummerHouseEditViewModel getSummerHouseEditVM() {
        if(null == shevm) {
            shevm = new SummerHouseEditViewModel(
                    modelf.getSummerHousesManager(),
                    modelf.getBookingsManager(),
                    modelf.getLoginModel());
        }

        return shevm;
    }

}
