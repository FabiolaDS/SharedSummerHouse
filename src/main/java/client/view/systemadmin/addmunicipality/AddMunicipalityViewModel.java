package client.view.systemadmin.addmunicipality;

import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import shared.domain.Municipality;

/**
 * Receives the information to create a new municipality.
 * Validates the input to avoid exceptions in the classes related
 * @author Agostina Mezzabotta
 */
public class AddMunicipalityViewModel
{
  private ManageMunicipalities municipalitiesModel;
  private StringProperty name, region, id;
  private StringProperty warning;

  /**
   * 1-argument constructor setting the ManageMunicipalities class as a model
   * and initializing String properties
   * @param manageMunicipalities model
   */
  public AddMunicipalityViewModel(ManageMunicipalities manageMunicipalities)
  {
    this.municipalitiesModel = manageMunicipalities;
    warning = new SimpleStringProperty("");
    name = new SimpleStringProperty("");
    region = new SimpleStringProperty("");
    id = new SimpleStringProperty("");

  }

  public String getId()
  {
    return id.get();
  }

  public StringProperty idProperty()
  {
    return id;
  }

  public String getName()
  {
    return name.get();
  }

  public StringProperty nameProperty()
  {
    return name;
  }

  public String getRegion()
  {
    return region.get();
  }

  public StringProperty regionProperty()
  {
    return region;
  }

  /**
   * Input validation before trying to add a municipality.
   * If the user does not insert a valid id, the municipality will not be created.
   * Different messages guide the user to a proper input
   */
  public void addMunicipality()
  {
    //input validation

    if (id.get().length() != 3)
    {
      warning.setValue("ID must be contain 3 characters");

    }
    else if (!id.get().matches("[0-9]+"))
    {
      warning.setValue("ID must contain only numbers");
    }

    else if (isAvailable())
    {
      municipalitiesModel
          .addMunicipality(new Municipality(getName(), getRegion(), getId()));
      warning.setValue("Municipality has been created");
    }
    else
    {
      warning.setValue("Id not available");
    }
  }
  public ObservableValue<String> getWarningProperty()
  {
    return warning;
  }

  /**
   * private method used to check if a id is available to be used
   * @return true if there is not a municipality registered with that id
   */
  private boolean isAvailable()
  {
    Municipality municipality = municipalitiesModel.getMunicipality(id.get());

    return municipality == null;
  }

}
