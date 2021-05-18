package client.view.systemadmin.addmunicipality;


import client.model.municipalities.ManageMunicipalities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.domain.Municipality;

public class AddMunicipalityViewModel {
    private ManageMunicipalities municipalitiesModel;
    private StringProperty name, region, id;

    public AddMunicipalityViewModel(ManageMunicipalities manageMunicipalities) {

        this.municipalitiesModel = manageMunicipalities;
        name = new SimpleStringProperty();
        region = new SimpleStringProperty();
        id = new SimpleStringProperty();

    }

    public void addMunicipality(String name, String region)
    {
        municipalitiesModel.addMunicipality(new Municipality(name, region ));
    }
}
