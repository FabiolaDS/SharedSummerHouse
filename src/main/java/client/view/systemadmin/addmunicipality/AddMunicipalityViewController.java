package client.view.systemadmin.addmunicipality;


import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMunicipalityViewController implements ViewController {
    @FXML
    public TextField muniNameLabel;
    @FXML
    public TextField muniRegionLabel;

    private SAViewHandler viewHandler;
    private AddMunicipalityViewModel addMunicipalityViewModel;

    @Override
    public void init() throws IOException {
        this.viewHandler = SAViewHandler.getInstance();
        this.addMunicipalityViewModel = ViewModelFactory.getInstance().addMunicipalityViewModel();
    }

    public void onCreateMuni(ActionEvent actionEvent) {

        addMunicipalityViewModel.addMunicipality(muniNameLabel.getText(), muniRegionLabel.getText());
        reset();

    }


    public void onBackToMain(ActionEvent actionEvent) throws IOException {
        viewHandler.openMainView();
    }

    private void reset() {
        muniNameLabel.clear();
        muniRegionLabel.clear();
    }
}
