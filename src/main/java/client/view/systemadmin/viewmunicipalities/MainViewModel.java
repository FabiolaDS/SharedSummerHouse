package client.view.systemadmin.viewmunicipalities;


import client.model.municipalities.ManageMunicipalities;
import javafx.application.Platform;
import javafx.collections.*;
import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.transferobjects.EventType;

import javax.swing.plaf.basic.BasicListUI;
import java.beans.PropertyChangeEvent;
import java.util.Collection;

public class MainViewModel
{
  private ManageMunicipalities model;
  private ObservableList<Municipality> municipalities;

  public MainViewModel(ManageMunicipalities manageMunicipalities)
  {
    model = manageMunicipalities;
    model.addPropertyChangeListener(EventType.MUNICIPALITY.toString(), this::newMunicipality);
    model.addPropertyChangeListener(EventType.REGIONALADMIN.toString(), this::updateMunicipalities);
    municipalities = FXCollections.observableArrayList();
  }

  private void updateMunicipalities(PropertyChangeEvent propertyChangeEvent)
  {
       Platform.runLater(() -> municipalities.add((Municipality) propertyChangeEvent.getNewValue()));
       municipalities.removeIf(municipality -> equals(propertyChangeEvent.getNewValue()));
  }
  private void newMunicipality(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> municipalities.add((Municipality) propertyChangeEvent.getNewValue()));
  }
  public ObservableList<Municipality> getMunicipalities() {
    return municipalities;
  }


}
