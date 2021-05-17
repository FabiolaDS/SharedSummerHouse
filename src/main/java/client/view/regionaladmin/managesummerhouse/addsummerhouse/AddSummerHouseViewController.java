package client.view.regionaladmin.managesummerhouse.addsummerhouse;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AddSummerHouseViewController
{
  public TextField regionField;
  public TextField addressField;
  public TextField titleField;
  public TextField descriptionField;
  public TextField nrOfGuestsField;
  public TextField pricePrNightField;

  private SAViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private AddSummerHouseViewModel addSummerHouseViewModel;

  public void init(SAViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    this.viewModelFactory = vmf;
  }

  public void onCreateSummerHouse(ActionEvent actionEvent) {
}
  public void onBackToMain(javafx.event.ActionEvent actionEvent) throws
      IOException
  {
    // viewHandler.openMainView();
  }
  }