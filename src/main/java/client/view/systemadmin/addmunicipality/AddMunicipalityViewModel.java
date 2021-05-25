package client.view.systemadmin.addmunicipality;

import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import shared.domain.Municipality;

public class AddMunicipalityViewModel
{
  private ManageMunicipalities municipalitiesModel;
  private StringProperty name, region, id;
  private StringProperty warning;

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

  public void addMunicipality(String name, String region,
      String municipality_id)
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

    else if (isAvailable(id.get()))
    {
      municipalitiesModel
          .addMunicipality(new Municipality(name, region, municipality_id));
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

  private boolean isAvailable(String id)
  {
    Municipality municipality = municipalitiesModel.getMunicipality(id);

    return municipality == null;
  }

}
