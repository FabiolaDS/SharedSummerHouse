package client.view.systemadmin.addRAmin;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddRegionalAdminViewController implements ViewController {

    public Label municipalityLabel;
    private AddRegionalAdministratorViewModel addRegionalAdministratorVM;
    public TextField cprField;
    public TextField fnameField;
    public TextField lnameField;
    public TextField emailField;
    public TextField passwordField;


    @Override
    public void init() throws IOException {
        addRegionalAdministratorVM = ViewModelFactory.getInstance()
                .getAddRegionalAdministratorViewModel();
        municipalityLabel.textProperty().bindBidirectional(
                addRegionalAdministratorVM.getMunicipalityId());
        cprField.textProperty().bindBidirectional(addRegionalAdministratorVM.cprNrProperty());
        fnameField.textProperty().bindBidirectional(addRegionalAdministratorVM.nameProperty());
        lnameField.textProperty().bindBidirectional(addRegionalAdministratorVM.lastNameProperty());
        emailField.textProperty().bindBidirectional(addRegionalAdministratorVM.mnameProperty());
        passwordField.textProperty().bindBidirectional(addRegionalAdministratorVM.passwordProperty());

    }

    public void onCreateRadmin(ActionEvent actionEvent) {
        addRegionalAdministratorVM.addRegionalAdmin();
        reset();
    }

    public void onBack(ActionEvent actionEvent) {
        ViewModelFactory.getInstance().getMunicipalityDetailsViewModel().getMunicipalityDetailsId(
                municipalityLabel.getText());
        municipalityLabel.textProperty().setValue("");
        SAViewHandler.getInstance().openSeeMunicipalityDetailsView();
    }

    private void reset() {
        fnameField.textProperty().setValue("");
        cprField.textProperty().setValue("");
        lnameField.textProperty().setValue("");
        emailField.textProperty().setValue("");
        passwordField.textProperty().setValue("");
    }

}
