package client.view.systemadmin.seedetails;

import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

public class MunicipalityDetailsViewModel
{
  private ManageMunicipalities model;
  private StringProperty name, region, id;
  private StringProperty cpr, firstName, lastName, email;

  public MunicipalityDetailsViewModel(ManageMunicipalities manageMunicipalities)
  {
    this.model = manageMunicipalities;
    name = new SimpleStringProperty("");
    region = new SimpleStringProperty("");
    id = new SimpleStringProperty("");

    cpr = new SimpleStringProperty("Not assigned");
    firstName = new SimpleStringProperty("");
    lastName = new SimpleStringProperty("");
    email = new SimpleStringProperty("");
  }

  public void getMunicipalityDetailsId(String id)
  {
    cpr.setValue("Not assigned");
    firstName.setValue("");
    lastName.setValue("");
    email.setValue("");
    Municipality municipality = model.getMunicipality(id);

    setName(municipality.getName());
    setId(municipality.getId());
    setRegion(municipality.getRegion());

    if (municipality.getRegionalAdminCPR() != null)
    {
      //TODO:HIDE RA INFO WHILE IT IS NULL
      RegionalAdmin regionalAdmin = model
          .getRegionalAdminByCPR(municipality.getRegionalAdminCPR());
      setCpr(regionalAdmin.getCpr());
      setEmail(regionalAdmin.getMName());
      setFirstName(regionalAdmin.getFirstname());
      setLastName(regionalAdmin.getLastname());
    }
  }

  public void deleteRegionalAdmin()
  {
    if (!cpr.getValue().equals(""))
    {
      model.deleteRegionalAdmin(model.getRegionalAdminByCPR(cpr.get()));
      cpr.setValue("");
      firstName.setValue("");
      lastName.setValue("");
      email.setValue("");
    }
  }

  public StringProperty cprProperty()
  {
    return cpr;
  }

  public void setCpr(String cpr)
  {
    this.cpr.set(cpr);
  }

  public String getFirstName()
  {
    return firstName.get();
  }

  public StringProperty firstNameProperty()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName.set(firstName);
  }

  public String getLastName()
  {
    return lastName.get();
  }

  public StringProperty lastNameProperty()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName.set(lastName);
  }

  public String getEmail()
  {
    return email.get();
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email.set(email);
  }

  public StringProperty nameProperty()
  {
    return name;
  }

  public StringProperty regionProperty()
  {
    return region;
  }

  public StringProperty idProperty()
  {
    return id;
  }

  public void setName(String name)
  {
    this.name.set(name);
  }

  public void setRegion(String region)
  {
    this.region.set(region);
  }

  public void setId(String id)
  {
    this.id.set(id);
  }

}
