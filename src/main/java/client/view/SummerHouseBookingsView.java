package client.view;

import client.viewmodel.SummerHouseBookingViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Booking;

import java.time.LocalDate;

public class SummerHouseBookingsView
{
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;

    @FXML
    private TableView<Booking> bookings;
    @FXML
    private TableColumn<Booking, LocalDate> fromColumn;
    @FXML
    private TableColumn<Booking, LocalDate> toColumn;

    private ViewHandler vh;
    private SummerHouseBookingViewModel vm;

    public SummerHouseBookingsView(ViewHandler vh, SummerHouseBookingViewModel vm)
    {
        this.vh = vh;
        this.vm = vm;
    }

    @FXML
    private void initialize()
    {
        vm.dateFromProperty().bind(dateFrom.valueProperty());
        vm.dateToProperty().bind(dateTo.valueProperty());

        fromColumn.setCellValueFactory(new PropertyValueFactory<Booking, LocalDate>("dateFrom"));
        toColumn.setCellValueFactory(new PropertyValueFactory<Booking, LocalDate>("dateTo"));

        bookings.setItems(vm.getBookings());
    }

    @FXML
    private void book()
    {
        try {
            vm.book();
        } catch(IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void cancel()
    {
        vh.openSummerHouseDetails(vm.selectedProperty().get());
    }
}
