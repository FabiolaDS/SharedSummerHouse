package client.view.regionaladmin.managesummerhouse.viewsummerhouse;

import client.model.summerhouses.ManageSummerHouses;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import shared.domain.SummerHouse;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;

public class ManageSummerHouseModel
{

  private ManageSummerHouses model;
  private ObservableList<SummerHouse> summerHouses;
  private ObservableSet<SummerHouse> selectedSummerHouse;


  public ManageSummerHouseModel(ManageSummerHouses manageSummerHouses){
    model = manageSummerHouses;
    model.addPropertyChangeListener(EventType.SUMMERHOUSE.toString(), this::newSummerHouse);
    summerHouses = FXCollections.observableArrayList();
    selectedSummerHouse = FXCollections.observableSet();

  }

  public ObservableList<SummerHouse> getSummerHouses()
  {
    return summerHouses;
  }

  private void newSummerHouse(PropertyChangeEvent propertyChangeEvent){
    Platform.runLater(() -> summerHouses.add((SummerHouse) propertyChangeEvent.getNewValue()));
  }
}
