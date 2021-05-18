package client.view.systemadmin.seedetails;


import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;

public class MunicipalityDetailsViewModel {
    private ManageMunicipalities model;
    private StringProperty name, region,id;
    public MunicipalityDetailsViewModel(ManageMunicipalities manageMunicipalities) {

        this.model = manageMunicipalities;

        name = new SimpleStringProperty("");
        region = new SimpleStringProperty("");
        id = new SimpleStringProperty("");
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
