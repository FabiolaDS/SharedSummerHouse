package client.view.regionaladmin.managesummerhouse.addsummerhouse;

import client.core.viewhandler.RAViewHandler;
import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import shared.domain.SummerHouse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class AddSummerHouseViewController implements ViewController
{
  @FXML public TextField regionField;
  @FXML public TextField streetField;
  @FXML public TextField titleField;
  @FXML public TextField descriptionField;
  @FXML public TextField pricePrNightField;
  @FXML public TextField postCodeField;
  @FXML public TextField houseNumberField;


  private RAViewHandler viewHandler;
  //private ViewModelFactory viewModelFactory;
  private AddSummerHouseViewModel addSummerHouseViewModel;

  @Override public void init() throws IOException
  {
    this.viewHandler = RAViewHandler.getInstance();
    this.addSummerHouseViewModel = ViewModelFactory.getInstance().addSummerHouseViewModel();
  }

  public void onCreateSummerHouse(javafx.event.ActionEvent actionEvent)
  {
    addSummerHouseViewModel.addSummerHouse();   // no args should be passed to viewmodel method call, everything should be taken from bound properties

    viewHandler.openAddSummerHousesView();
    reset();
  }


  public void onBackToMain(javafx.event.ActionEvent actionEvent) throws
      IOException
  {
      viewHandler.openManageSummerHouseView();
  }
  public void reset(){
    /*regionField.clear;
    streetField.clear();
    titleField.clear();
    descriptionField.clear();
    pricePrNightField.clear();*/
  }


}