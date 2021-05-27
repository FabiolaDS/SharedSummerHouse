package client.view;

import client.core.ViewModelFactory;
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
