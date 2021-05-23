package client.view.systemadmin.seedetails;


import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.domain.Municipality;

public class MunicipalityDetailsViewModel {
    private ManageMunicipalities model;
    private StringProperty name, region,id;
    private StringProperty cpr, firstName, lastName, email;

    public MunicipalityDetailsViewModel(ManageMunicipalities manageMunicipalities) {

        this.model = manageMunicipalities;

        name = new SimpleStringProperty("");
        region = new SimpleStringProperty("");
        id = new SimpleStringProperty("");

        cpr = new SimpleStringProperty("");
        firstName = new SimpleStringProperty("");
        lastName = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
    }

    public void getMunicipalityDetailsId(String id)
    {
        Municipality municipality = model.getMunicipality(id);
        setName(municipality.getName());
        setId(municipality.getId());
        setRegion(municipality.getRegion());

        if (municipality.getRegionalAdmin() != null)
        {
            setCpr(municipality.getRegionalAdmin().getCpr());
            setEmail(municipality.getRegionalAdmin().getMName());
            setFirstName(municipality.getRegionalAdmin().getFirstname());
            setLastName(municipality.getRegionalAdmin().getLastname());
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
