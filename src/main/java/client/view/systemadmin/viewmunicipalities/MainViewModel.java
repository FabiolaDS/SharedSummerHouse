package client.view.systemadmin.viewmunicipalities;

import client.model.municipalities.ManageMunicipalities;
import javafx.application.Platform;
import javafx.collections.*;
import shared.domain.Municipality;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 * MainViewModel class listening to events in the model
 */
public class MainViewModel
{
  private ManageMunicipalities model;
  private ObservableList<Municipality> municipalities;

  /**
   * 1-argument constructor associating the class with the model and
   * subscribing two methods as listeners of the model
   * @param manageMunicipalities
   */
  public MainViewModel(ManageMunicipalities manageMunicipalities)
  {
    model = manageMunicipalities;
    model.addPropertyChangeListener(EventType.MUNICIPALITY.toString(),
        this::newMunicipality);
    model.addPropertyChangeListener(EventType.REGIONALADMIN.toString(),
        this::updateRegionalAdmin);
    municipalities = FXCollections.observableArrayList();
    municipalities.setAll(model.setMunicipalityList());
  }

  public void setMunicipalityList()
  {
    municipalities.setAll(model.setMunicipalityList());
  }

  private void updateRegionalAdmin(PropertyChangeEvent propertyChangeEvent)
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
