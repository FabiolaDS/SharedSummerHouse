package client.view.regionaladmin.managesummerhouse.viewsummerhouse;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Municipality;
import shared.domain.SummerHouse;

import java.io.IOException;

public class ManageSummerHouseController
{
  public TableColumn<SummerHouse, String> titleColumn;
  public TableColumn<SummerHouse, String> regionColumn;
  public TableColumn<SummerHouse, String> streetColumn;
  public TableColumn<SummerHouse, Integer> postCodeColumn;
  public TableColumn<SummerHouse, String> descriptionColumn;
  public TableColumn <SummerHouse, Integer> houseNrColumn;
  public TableColumn<SummerHouse, Integer> priceNightColumn;
  public TableColumn<SummerHouse, Integer> avgRatingColumn;
  public DatePicker isAvailableDate;
  public ListView<Municipality> sharedWithList;
  public TableView<SummerHouse> summerHouseTableView;

  private SAViewHandler viewHandler;
  private ViewModelFactory vmf;
  private ManageSummerHouseModel mvm;

  public ManageSummerHouseController(){}

  public void init()
  {
    this.vmf = ViewModelFactory.getInstance();
    this.mvm = vmf.getManageSummerHouseModel();
    viewHandler = SAViewHandler.getInstance();

    titleColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Title"));
    regionColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Region"));
    streetColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Street"));
    postCodeColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Integer>("Post code"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Description"));
    houseNrColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Integer>("House number"));
    priceNightColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Integer>("Price per night"));
    avgRatingColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Integer>("Avg rating"));
    isAvailableDate.getChronology();



    sharedWithList = new ListView<>();
    sharedWithList.getItems().addAll();
    sharedWithList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    tableViewLoad();

  }
  private void tableViewLoad()
  {
    summerHouseTableView.setItems(mvm.getSummerHouses());
  }

  public void onCreateSummerHouse(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openManageSummerHouseView();

  }

  public void onViewDetails(ActionEvent actionEvent) {
    summerHouseTableView.getSelectionModel().getSelectedItem();

    viewHandler.openManageSummerHouseView();

  }

  public void onAddSummerHouse(ActionEvent actionEvent) {
  }
  public void onBackToMain(ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }

  public void onRemoveSummerHouse(ActionEvent actionEvent){}
}
