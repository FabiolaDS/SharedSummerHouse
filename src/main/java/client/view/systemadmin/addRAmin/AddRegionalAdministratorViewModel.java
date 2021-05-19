package client.view.systemadmin.addRAmin;

import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.domain.RegionalAdmin;

import java.rmi.RemoteException;

public class AddRegionalAdministratorViewModel
{

  private ManageMunicipalities municipalitiesModel;
  private StringProperty municipalityId,cprNr,name, lastName,email,password;

  public AddRegionalAdministratorViewModel(
      ManageMunicipalities manageMunicipalities)
  {

    this.municipalitiesModel = manageMunicipalities;
    municipalityId = new SimpleStringProperty();
    cprNr = new SimpleStringProperty();
    name = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    email = new SimpleStringProperty();
    password = new SimpleStringProperty();
  }

  public StringProperty getMunicipalityId()
  {
    return municipalityId;
  }
  public String getMunicipalityIdString()
  {
    return municipalityId.get();
  }

  public void setMunicipalityId(String municipalityId)
  {
    this.municipalityId.set(municipalityId);
  }

  public StringProperty municipalityIdProperty()
  {
    return municipalityId;
  }

  public String getCprNr()
  {
    return cprNr.get();
  }

  public StringProperty cprNrProperty()
  {
    return cprNr;
  }

  public String getName()
  {
    return name.get();
  }

  public StringProperty nameProperty()
  {
    return name;
  }

  public String getLastName()
  {
    return lastName.get();
  }

  public StringProperty lastNameProperty()
  {
    return lastName;
  }

  public String getEmail()
  {
    return email.get();
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public String getPassword()
  {
    return password.get();
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public void addRegionalAdmin()
  {
    municipalitiesModel.addRegionalAdmin(new RegionalAdmin(getCprNr(),getName(),getLastName(),getEmail(),getPassword()), getMunicipalityIdString());
  }

}
