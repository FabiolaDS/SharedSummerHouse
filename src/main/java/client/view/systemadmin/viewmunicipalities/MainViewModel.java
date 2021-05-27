package client.view.systemadmin.viewmunicipalities;

import client.model.municipalities.ManageMunicipalities;
import javafx.application.Platform;
import javafx.collections.*;
import shared.domain.Municipality;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class MainViewModel
{
  private ManageMunicipalities model;
  private ObservableList<Municipality> municipalities;

  public MainViewModel(ManageMunicipalities manageMunicipalities)
  {
    model = manageMunicipalities;
    model.addPropertyChangeListener(EventType.MUNICIPALITY.toString(),
        this::newMunicipality);
    model.addPropertyChangeListener(EventType.REGIONALADMIN.toString(),
        this::updateMunicipalities);
    municipalities = FXCollections.observableArrayList();
    municipalities.setAll(model.getMunicipalitiesStart());
  }

  public void municipalityList()
  {
    municipalities.setAll(model.getMunicipalitiesStart());
  }

  private void updateMunicipalities(PropertyChangeEvent propertyChangeEvent)
  {
    municipalities.clear();
    Platform.runLater(() -> municipalities
        .setAll((List<Municipality>) propertyChangeEvent.getNewValue()));
  }

  private void newMunicipality(PropertyChangeEvent propertyChangeEvent)
  {
    municipalities.clear();
    Platform.runLater(() -> municipalities
        .setAll((List<Municipality>) propertyChangeEvent.getNewValue()));
  }

  public ObservableList<Municipality> getMunicipalities()
  {
    return municipalities;
  }

  public void deleteMunicipality(String id)
  {
    model.deleteMunicipality(id);
  }
}
