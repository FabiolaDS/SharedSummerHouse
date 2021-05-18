package client.view.systemadmin.viewmunicipalities;


import client.model.municipalities.ManageMunicipalities;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.util.Collection;

public class MainViewModel
{
  private ManageMunicipalities model;
  private ObservableList<Municipality> municipalities;
  private ObservableSet<Municipality> selectedMunicipality;


  public MainViewModel(ManageMunicipalities manageMunicipalities)
  {
    model = manageMunicipalities;
    model.addPropertyChangeListener(EventType.MUNICIPALITY.toString(), this::newMunicipality);
    municipalities = FXCollections.observableArrayList();
    selectedMunicipality = FXCollections.observableSet();
  }

  public ObservableList<Municipality> getMunicipalities() {
    return municipalities;
  }

  private void newMunicipality(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> municipalities.add((Municipality) propertyChangeEvent.getNewValue()));
  }

}
