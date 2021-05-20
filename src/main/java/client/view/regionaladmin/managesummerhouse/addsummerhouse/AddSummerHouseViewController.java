package client.view.regionaladmin.managesummerhouse.addsummerhouse;

import client.core.viewhandler.RAViewHandler;
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

  private RAViewHandler viewHandler;
 private ViewModelFactory vmf;
  private AddSummerHouseViewModel addSummerHouseViewModel;

  public void init()
  {
    this.viewHandler = RAViewHandler.getInstance();
    this.vmf = ViewModelFactory.getInstance().addMunicipalityViewModel();
   //this.viewModelFactory = ViewModelFactory.getInstance().getAddRegionalAdministratorViewModel();
  }

  public void onCreateSummerHouse(ActionEvent actionEvent) {
}
  public void onBackToMain(javafx.event.ActionEvent actionEvent) throws
      IOException
  {
    // viewHandler.openMainView();
  }
  public void addSummerHouse(ActionEvent event) {

  }
  }