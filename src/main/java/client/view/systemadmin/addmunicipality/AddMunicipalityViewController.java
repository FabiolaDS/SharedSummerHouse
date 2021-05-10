package client.view.systemadmin.addmunicipality;


import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMunicipalityViewController {
    public TextField muniNameLabel;
    public TextField muniRegionLabel;
    public TextField muniIdLabel;

    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private AddMunicipalityViewModel addMunicipalityViewModel;
    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = vmf;
       // this.addMunicipalityViewModel = viewModelFactory.getAddMunicipalityViewModel();
    }
    public void onCreateMuni(ActionEvent actionEvent) {
    }

    public void onAddRegionalAdmin(ActionEvent actionEvent) {
    }

    public void onBackToMain(ActionEvent actionEvent) throws IOException {
       // viewHandler.openMainView();
    }


}
