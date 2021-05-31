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
  private StringProperty cpr, firstName, lastName, mName;

  public MunicipalityDetailsViewModel(ManageMunicipalities manageMunicipalities)
  {
    this.model = manageMunicipalities;
    name = new SimpleStringProperty("");
    region = new SimpleStringProperty("");
    id = new SimpleStringProperty("");

    cpr = new SimpleStringProperty("Not assigned");
    firstName = new SimpleStringProperty("");
    lastName = new SimpleStringProperty("");
    mName = new SimpleStringProperty("");
  }

  public void getMunicipalityDetailsId(String id)
  {
    cpr.setValue("Not assigned");
    firstName.setValue("");
    lastName.setValue("");
    mName.setValue("");
    Municipality municipality = model.getMunicipality(id);

    setName(municipality.getName());
    setId(municipality.getId());
    setRegion(municipality.getRegion());

    if (municipality.getRegionalAdminCPR() != null)
    {
      RegionalAdmin regionalAdmin = model
          .getRegionalAdminByCPR(municipality.getRegionalAdminCPR());
      setCpr(regionalAdmin.getCpr());
      setmName(regionalAdmin.getMName());
      setFirstName(regionalAdmin.getFirstname());
      setLastName(regionalAdmin.getLastname());
    }
  }



  public void deleteRegionalAdmin()
  {
    if (!cpr.getValue().equals("Not assigned"))
    {
      model.deleteRegionalAdmin(model.getRegionalAdminByCPR(cpr.get()));
      cpr.setValue("");
      firstName.setValue("");
      lastName.setValue("");
      mName.setValue("");
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

  public StringProperty mNameProperty()
  {
    return mName;
  }

  public void setmName(String mName)
  {
    this.mName.set(mName);
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
