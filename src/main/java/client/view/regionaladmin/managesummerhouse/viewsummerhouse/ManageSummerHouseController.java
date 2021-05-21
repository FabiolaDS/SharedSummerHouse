package client.view.regionaladmin.managesummerhouse.viewsummerhouse;

import client.core.viewhandler.RAViewHandler;
import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Municipality;
import shared.domain.SummerHouse;

import java.io.IOException;

public class ManageSummerHouseController implements ViewController
{
  public TableColumn<SummerHouse, String> titleColumn;
  public TableColumn<SummerHouse, String> regionColumn;
  public TableColumn<SummerHouse, String> streetColumn;
  public TableColumn<SummerHouse, String> postCodeColumn;
  public TableColumn<SummerHouse, String> descriptionColumn;
  public TableColumn <SummerHouse, String> houseNumberColumn;
  public TableColumn<SummerHouse, String> pricePerNightColumn;
  public TableColumn<SummerHouse, String> avgRatingColumn;
  //public DatePicker isAvailableDate;
  public ListView<Municipality> sharedWithList;
  public TableView<SummerHouse> summerHouseTableView;
 // public TableView pastBookings;

  private RAViewHandler viewHandler;
  private ViewModelFactory vmf;
  private ManageSummerHouseModel mvm;

  public ManageSummerHouseController(){}

  @Override public void init()
  {
    this.vmf = ViewModelFactory.getInstance();
    this.mvm = vmf.getManageSummerHouseModel();
    viewHandler = RAViewHandler.getInstance();

    /*titleColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Title"));
    regionColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Region"));
    streetColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Street"));
    postCodeColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("PostCode"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("Description"));
    houseNumberColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("HouseNumber"));
    pricePerNightColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("PricePerNight"));
    avgRatingColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("AvgRating"));
    //isAvailableDate.getChronology();*/



    sharedWithList = new ListView<>();
    sharedWithList.getItems().addAll();
    sharedWithList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    //tableViewLoad();



  }
  private void tableViewLoad()
  {
    summerHouseTableView.setItems(mvm.getSummerHouses());

  }

  public void onAddSummerHouse(ActionEvent actionEvent) throws IOException
  {
    viewHandler.openAddSummerHousesView();
  }
  public void onSharedWith(ActionEvent actionEvent){
    viewHandler.openMainView();
  }

  /*public void onViewDetails(ActionEvent actionEvent) {
    summerHouseTableView.getSelectionModel().getSelectedItem();

    viewHandler.openManageSummerHouseView();

  }*/

  public void onEditSummerHouse(ActionEvent actionEvent) {
    //viewHandler.openManageSummerHouseView();
   // summerHouseTableView.edit(summerHouseTableView.getSelectionModel().getSelectedItem(), );
  }

  public void onBackToMain(ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }



  public void removeSummerhouse(ActionEvent actionEvent)
  {
    summerHouseTableView.getItems().removeAll(summerHouseTableView.getSelectionModel().getSelectedItem());
  }
}
