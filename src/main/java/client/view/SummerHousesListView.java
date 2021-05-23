package client.view;

import client.viewmodel.SummerHousesListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<SummerHouse, Double> avgRatingColumn;

    @FXML
    private HBox editBar;


    private SummerHousesListViewModel vm;

    public SummerHousesListView(SummerHousesListViewModel vm) {
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
        avgRatingColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));

        summerhouses.setItems(vm.getSummerHouses());

        editBar.visibleProperty().bind(vm.canEditProperty());
    }


    @FXML
    void onAddSummerHouse()
    {}

    @FXML
    void onBackToMain()
    {}

    @FXML
    void onEditSummerHouse()
    {}
}
