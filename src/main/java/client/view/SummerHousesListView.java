package client.view;

import client.viewmodel.SummerHousesListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import shared.domain.SummerHouse;

public class SummerHousesListView
{
    @FXML
    private TableView<SummerHouse> summerhouses;

    @FXML
    private TableColumn<SummerHouse, String> regionColumn;

    @FXML
    private TableColumn<SummerHouse, String> streetColumn;

    @FXML
    private TableColumn<SummerHouse, Integer> houseNumberColumn;

    @FXML
    private TableColumn<SummerHouse, Integer> guestsColumn;

    @FXML
    private TableColumn<SummerHouse, Double> pricePerNightColumn;

    @FXML
    private HBox editBar;

    private ViewHandler vh;
    private SummerHousesListViewModel vm;

    public SummerHousesListView(ViewHandler vh, SummerHousesListViewModel vm) {
        this.vh = vh;
        this.vm = vm;
    }

    @FXML
    private void initialize() {
        // retrieves the value of a field region from summerhouse object
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        houseNumberColumn.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
        guestsColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        pricePerNightColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));

        summerhouses.setItems(vm.getSummerHouses());

        editBar.visibleProperty().bind(vm.canEditProperty());
    }


    @FXML
    private void onAddSummerHouse() {
        vh.openSummerHouseAdd();
    }

    @FXML
    private void onBackToMain()
    {}

    @FXML
    private void showSummerHouse(MouseEvent e) {
        if(e.getClickCount() == 2) {
            if(summerhouses.getSelectionModel().getSelectedItem() != null) {
                vh.openSummerHouseDetails(
                        summerhouses.getSelectionModel().getSelectedItem());
            }
        }
    }
}
