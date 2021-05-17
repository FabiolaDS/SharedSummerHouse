package client.core;

import client.model.municipalities.ManageMunicipalities;
import client.view.login.LoginViewModel;
import client.view.regionaladmin.managetenant.addtenant.AddTenantViewModel;
import client.view.regionaladmin.managetenant.seetenants.SeeAllTenantsViewModel;
import client.view.systemadmin.addRAmin.AddRegionalAdministratorViewModel;
import client.view.systemadmin.addmunicipality.AddMunicipalityViewModel;
import client.view.systemadmin.seedetails.MunicipalityDetailsViewModel;
import client.view.systemadmin.viewmunicipalities.MainViewModel;
import javafx.beans.property.Property;

public class ViewModelFactory
{
  private static ViewModelFactory vmf;
  private AddTenantViewModel addTenantViewModel;
  private SeeAllTenantsViewModel seeAllTenantsViewModel;
  private AddMunicipalityViewModel addMunicipalityViewModel;
  private AddRegionalAdministratorViewModel addRegionalAdministratorViewModel;
  private MunicipalityDetailsViewModel municipalityDetailsViewModel;
  private MainViewModel mainViewModel;
  private LoginViewModel loginViewModel;

  private ViewModelFactory()
  {

  }

  public static ViewModelFactory getInstance(){
    if (vmf == null)
    {
      vmf = new ViewModelFactory();
    }
    return vmf;
  }

  public AddTenantViewModel getAddTenantViewModel()
  {
    if (addTenantViewModel == null)
    {
    addTenantViewModel = new AddTenantViewModel();
    }
    return addTenantViewModel;
  }

  public SeeAllTenantsViewModel getSeeAllTenantsViewModel()
  {
    if (seeAllTenantsViewModel == null)
    {
      seeAllTenantsViewModel = new SeeAllTenantsViewModel();
    }
    return seeAllTenantsViewModel;
  }

  public AddMunicipalityViewModel addMunicipalityViewModel()
  {
    if (addMunicipalityViewModel == null)
    {
      addMunicipalityViewModel = new AddMunicipalityViewModel(ModelFactory.getInstance()
          .getMunicipalitiesModel());
    }
    return addMunicipalityViewModel;
  }

  public AddRegionalAdministratorViewModel getAddRegionalAdministratorViewModel()
  {
    if (addRegionalAdministratorViewModel == null)
    {
      addRegionalAdministratorViewModel = new AddRegionalAdministratorViewModel(ModelFactory.getInstance()
          .getMunicipalitiesModel());
    }
    return addRegionalAdministratorViewModel;
  }

  public MunicipalityDetailsViewModel getMunicipalityDetailsViewModel()
  {
    if (municipalityDetailsViewModel == null)
    {
      municipalityDetailsViewModel = new MunicipalityDetailsViewModel(ModelFactory.getInstance()
          .getMunicipalitiesModel());
    }
    return municipalityDetailsViewModel;
  }

  public MainViewModel getMainViewModel()
  {
    if (mainViewModel == null)
    {
      mainViewModel = new MainViewModel(ModelFactory.getInstance().getMunicipalitiesModel());
    }
    return mainViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    if (loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(ModelFactory.getInstance().getLoginModel());
    }
    return loginViewModel;
  }
}
