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

public class ViewHandler
{
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf, Stage primaryStage)
    {
        this.vmf = vmf;
        stage = primaryStage;

        stage.show();
    }

    public void openSummerHouseList()
    {
        stage.setScene(new Scene(load("/summerhouseList.fxml",
                new SummerHousesListView(this, vmf.getSummerHousesListVM()))));
    }

    public void openSummerHouseDetails(SummerHouse sh)
    {
        SummerHouseEditViewModel vm = vmf.getSummerHouseEditVM();
        vm.setSelected(sh);

        stage.setScene(new Scene(load("/editSummerHouse.fxml",
                new SummerHouseEditView(this, vm))));
    }

    public void openSummerHouseAdd()
    {
        openSummerHouseDetails(null);
    }

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
