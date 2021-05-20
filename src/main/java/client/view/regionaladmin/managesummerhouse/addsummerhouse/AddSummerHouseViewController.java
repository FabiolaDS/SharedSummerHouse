package client.view.regionaladmin.managesummerhouse.addsummerhouse;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class AddSummerHouseViewController implements ViewController
{
  public TextField regionField;
  public TextField streetField;
  public TextField titleField;
  public TextField descriptionField;
  public TextField pricePrNightField;
  public TextField postCodeField;
  public TextField houseNumberField;


  private SAViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private AddSummerHouseViewModel addSummerHouseViewModel;

  @Override public void init() throws IOException
  {
    this.viewHandler = SAViewHandler.getInstance();
    this.addSummerHouseViewModel = ViewModelFactory.getInstance().addSummerHouseViewModel();
  }

  public void onCreateSummerHouse(ActionEvent actionEvent) {
    addSummerHouseViewModel.addSummerHouse(regionField.getText(),streetField.getText(),
        titleField.getText(), descriptionField.getText(), pricePrNightField.getColumns(),
        postCodeField.getColumns(), houseNumberField.getColumns());
   reset();
  }




  public void onBackToMain(javafx.event.ActionEvent actionEvent) throws
      IOException
  {
      viewHandler.openMainView();
  }
  public void reset(){
    /*regionField.clear();
    streetField.clear();
    titleField.clear();
    descriptionField.clear();
    pricePrNightField.clear();*/
  }


}