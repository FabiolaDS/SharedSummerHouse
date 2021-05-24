package client.view;


import client.viewmodel.SummerHouseEditViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class SummerHouseEditView
{
    // address
    @FXML private TextField street;
    @FXML private TextField houseNo;
    @FXML private TextField postCode;
    @FXML private TextField region;

    @FXML private TextField title;
    @FXML private TextArea description;
    @FXML private TextField price;
    @FXML private TextField capacity;
    @FXML private TextField admin;

    @FXML private Button saveChangesButton;

    private SummerHouseEditViewModel vm;

    private ViewHandler vh;

    public SummerHouseEditView(ViewHandler vh, SummerHouseEditViewModel vm) {
        this.vh = vh;
        this.vm = vm;
    }

    @FXML
    private void initialize() {

        // disable editing for tenant
        street.editableProperty().bind(vm.canEditProperty());
        houseNo.editableProperty().bind(vm.canEditProperty());
        postCode.editableProperty().bind(vm.canEditProperty());
        region.editableProperty().bind(vm.canEditProperty());

        title.editableProperty().bind(vm.canEditProperty());
        description.editableProperty().bind(vm.canEditProperty());
        price.editableProperty().bind(vm.canEditProperty());
        capacity.editableProperty().bind(vm.canEditProperty());
        admin.editableProperty().bind(vm.canEditProperty());

        // hide button for tenant
        saveChangesButton.visibleProperty().bind(vm.canEditProperty());


        // bind values
        street.textProperty().bindBidirectional(vm.streetProperty());
        houseNo.textProperty().bindBidirectional(vm.houseNoProperty(), new NumberStringConverter());
        postCode.textProperty().bindBidirectional(vm.postCodeProperty(), new NumberStringConverter());
        region.textProperty().bindBidirectional(vm.regionProperty());

        title.textProperty().bindBidirectional(vm.titleProperty());
        description.textProperty().bindBidirectional(vm.descriptionProperty());
        price.textProperty().bindBidirectional(vm.priceProperty(), new NumberStringConverter());
        capacity.textProperty().bindBidirectional(vm.capacityProperty(), new NumberStringConverter());
        admin.textProperty().bindBidirectional(vm.adminNameProperty());
    }

    @FXML
    private void back() {
        vh.openSummerHouseList();
    }

    @FXML
    private void book() {
        vm.book();
    }

    @FXML
    private void saveChanges() {
        vm.saveChanges();
        vh.openSummerHouseList();
    }
}
