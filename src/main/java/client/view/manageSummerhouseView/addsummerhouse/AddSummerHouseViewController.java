package client.view.manageSummerhouseView.addsummerhouse;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.systemadmin.addmunicipality.AddMunicipalityViewModel;

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

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private AddSummerHouseViewModel addSummerHouseViewModel;

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
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