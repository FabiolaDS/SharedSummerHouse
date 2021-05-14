package client.view.manageSummerhouseView.viewsummerhouse;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import javax.swing.table.TableColumn;
import java.io.IOException;

public class MainViewController
{
  public TableColumn titleColumn;
  public TableColumn regionColumn;
  public TableColumn streetColumn;
  public TableColumn postCodeColumn;
  public TableColumn descriptionColumn;
  public TableColumn houseNrColumn;
  public TableColumn priceNightColumn;
  public TableColumn avgRatingColumn;
  public DatePicker isAvailableDate;
  public ListView sharedWithList;

  private ViewHandler viewHandler;
  private ViewModelFactory vmf;
  private  MainViewModel mvm;

  public MainViewController(){}

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    this.vmf = vmf;

  }
  public void onCreateSummerHouse(ActionEvent actionEvent) throws IOException
  {

  }

  public void onViewDetails(ActionEvent actionEvent) {
  }


  public void onAddSummerHouse(ActionEvent actionEvent) {
  }
}
