package client.view.regionaladmin.managesummerhouse.viewsummerhouse;

import client.core.ViewModelFactory;
import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Municipality;
import shared.domain.SummerHouse;

public class ManageSummerHouseController implements ViewController
{
  @FXML private TableColumn<SummerHouse, String> titleColumn;
  @FXML private TableColumn<SummerHouse, String> regionColumn;
  @FXML private TableColumn<SummerHouse, String> streetColumn;
  @FXML private TableColumn<SummerHouse, Integer> postCodeColumn;
  @FXML private TableColumn<SummerHouse, String> descriptionColumn;
  @FXML private TableColumn <SummerHouse, Integer> houseNumberColumn;
  @FXML private TableColumn<SummerHouse, Double> pricePerNightColumn;
 // @FXML private TableColumn<SummerHouse, Double> avgRatingColumn;
  //public DatePicker isAvailableDate;
  @FXML public ListView<Municipality> sharedWithList;
  @FXML public TableView<SummerHouse> summerHouseTableView;
   public TableView pastBookings;

  private RAViewHandler viewHandler;
  private ViewModelFactory vmf;
  private ManageSummerHouseModel mvm;

  public ManageSummerHouseController(){}

  @Override public void init()
  {
    this.vmf = ViewModelFactory.getInstance();
    this.mvm = vmf.getManageSummerHouseModel();
    viewHandler = RAViewHandler.getInstance();
    //summerHouseTableView.setItems(mvm.getSummerHouses());

    titleColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("title"));
    regionColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("region"));
    streetColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("street"));
    postCodeColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Integer>("postCode"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, String>("description"));
    houseNumberColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Integer>("houseNumber"));
    pricePerNightColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Double>("pricePerNight"));
    //avgRatingColumn.setCellValueFactory(new PropertyValueFactory<SummerHouse, Double>("avgRating"));
    //isAvailableDate.getChronology()





     //tableViewLoad();


   /*public void onViewDetails(ActionEvent event) {
    summerHouseTableView.getSelectionModel().getSelectedItem();

    viewHandler.openManageSummerHouseView();

  }*/
}

  /*private void tableViewLoad()
  {
    summerHouseTableView.setItems(mvm.getSummerHouses());
  }*/

  private void tableViewLoad(ObservableList<SummerHouse> summerHouses) throws RuntimeException   // new method
  {
    summerHouseTableView.setItems(mvm.getSummerHouses());

  }


  public void onBackToMain(ActionEvent actionEvent)
  {
    viewHandler.openMainView();
  }

  public void onAddSummerHouse(ActionEvent actionEvent)
  {
    viewHandler.openAddSummerHousesView();

  }

  public void onEditSummerHouse(ActionEvent actionEvent)
  {
    viewHandler.openManageSummerHouseView();

  }

  public void removeSummerhouse(ActionEvent actionEvent)
  {
    summerHouseTableView.getItems().removeAll(summerHouseTableView.getSelectionModel().getSelectedItem());
  }

  public void onSharedWith(ActionEvent actionEvent)
  {
    viewHandler.openMainView();
    sharedWithList = new ListView<>();
    sharedWithList.getItems().addAll();
    sharedWithList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  }

}
