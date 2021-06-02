package client.core;

import client.core.ViewModelFactory;
import client.view.SummerHouseBookingsView;
import client.view.SummerHouseEditView;
import client.view.SummerHousesListView;
import client.view.login.LoginViewController;
import client.view.regionaladmin.mainview.RegionalAdminMainViewController;
import client.view.regionaladmin.managetenant.addtenant.AddTenantViewController;
import client.view.regionaladmin.managetenant.viewtenantdetail.TenantDetailsViewController;
import client.view.systemadmin.addRAmin.AddRegionalAdminViewController;
import client.view.systemadmin.addmunicipality.AddMunicipalityViewController;
import client.view.systemadmin.seedetails.MunicipalityDetailsViewController;
import client.view.systemadmin.viewmunicipalities.MainViewController;
import client.viewmodel.SummerHouseBookingViewModel;
import client.viewmodel.SummerHouseEditViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import shared.domain.SummerHouse;

import java.io.IOException;

/**
 * Class responsible for managing Views
 * @author Fabiola
 */
public class ViewHandler
{
    private Stage stage;
    private ViewModelFactory vmf;

    /**
     * Constructor to initialize ViewHandler with ViewModelFactory and Stage to display views in.
     *
     * @param vmf               ViewModelFactory to get the viewmodels from
     * @param primaryStage      Stage to show views in
     */
    public ViewHandler(ViewModelFactory vmf, Stage primaryStage)
    {
        this.vmf = vmf;
        stage = primaryStage;

        stage.show();
    }

    /**
     * Shows SummerHouseListView in the stage.
     */
    public void openSummerHouseList()
    {
        stage.setScene(new Scene(load("/summerhouseList.fxml",
                new SummerHousesListView(this, vmf.getSummerHousesListVM()))));
    }

    /**
     * Shows SummerHouse editing/details view for SummerHouse sh in the stage.
     *
     * @param sh    SummerHouse to edit/display
     */
    public void openSummerHouseDetails(SummerHouse sh)
    {
        SummerHouseEditViewModel vm = vmf.getSummerHouseEditVM();
        vm.setSelected(sh);

        stage.setScene(new Scene(load("/editSummerHouse.fxml",
                new SummerHouseEditView(this, vm))));
    }

    /**
     * Shows view to register new SummerHouses in the stage.
     */
    public void openSummerHouseAdd()
    {
        openSummerHouseDetails(null);
    }

    /**
     * Shows bookings list view for given SummerHouse in the stage.
     *
     * @param sh    summerhouse to show bookings for
     */
    public void openSummerHouseBookings(SummerHouse sh)
    {
        SummerHouseBookingViewModel vm = vmf.getSummerHouseBookingVM();
        vm.setSelected(sh);

        stage.setScene(new Scene(load("/bookings.fxml",
                new SummerHouseBookingsView(this, vm))));
    }

    /**
     * Opens the login view
     */

    public void openLoginView() {
        stage.setScene(new Scene(load("/loginView.fxml",
            new LoginViewController(this, vmf.getLoginViewModel()))));
    }

    /**
     * Opens the main view for the Regional Admin
     */
    public void openMainView()
    {stage.setTitle("Main view");
        stage.setScene(new Scene(load("/regionalAdminMainView.fxml",
            new RegionalAdminMainViewController(this, null))));
    }

    /**
     * Opens a view for adding tenants
     */
    public void openAddTenantView()
    {
        stage.setTitle("Add a Tenant");
        stage.setScene(new Scene(load("/addTenantView.fxml",
            new AddTenantViewController(this, vmf.addTenantViewModel()))));
    }

    /**
     * opens a general view for all the tenants
     */
    public void openSeeAllTenants()
    {
        stage.setTitle("See All Registered Tenants");
            stage.setScene(new Scene(load("/seeAllTenantsView.fxml",
            new TenantDetailsViewController(this, vmf.getTenantDetailsViewModel()))));
    }

    //System Administrator views

    public void openMainViewSystemAdmin()
    {
        stage.setTitle("Regional administrator - Main view");
        stage.setScene(new Scene(load("/mainView.fxml",
            new MainViewController(this, vmf.getMainViewModel()))));
    }

    public void openSeeMunicipalityDetailsView()
    {
        stage.setTitle("Municipality Details");
        stage.setScene(new Scene(load("/municipalityDetailsView.fxml",
            new MunicipalityDetailsViewController(this, vmf.getMunicipalityDetailsViewModel()))));
    }

    /**
     * Opens a view for Adding municipalities
     */
    public void openAddMunicipalityView()
    {
        stage.setTitle("Add Municipality");
        stage.setScene(new Scene(load("/addMunicipalityView.fxml",
            new AddMunicipalityViewController(this, vmf.addMunicipalityViewModel()))));
    }

    /**
     * Opens a view for adding regional administrators
     */
    public void openAddRegionalAdminView()
    {
        stage.setTitle("Add Regional Administrator");
        stage.setScene(new Scene(load("/addRegionalAdminView.fxml",
            new AddRegionalAdminViewController(this, vmf.getAddRegionalAdministratorViewModel()))));
    }


    private Parent load(String path, Object controller)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        loader.setController(controller);

        try {
            return loader.load();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load FXML: " + e);
            alert.showAndWait();

            throw new RuntimeException(e);
        }
    }
}
