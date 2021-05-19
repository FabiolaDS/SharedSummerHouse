package client.view.systemadmin.addRAmin;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddRegionalAdminViewController implements ViewController
{

    public Label municipalityLabel;
    private AddRegionalAdministratorViewModel addRegionalAdministratorVM;
    public TextField cprField;
    public TextField fnameField;
    public TextField lnameField;
    public TextField emailField;
    public TextField passwordField;



    @Override public void init() throws IOException
    {
       addRegionalAdministratorVM = ViewModelFactory.getInstance()
           .getAddRegionalAdministratorViewModel();
       municipalityLabel.textProperty().bindBidirectional(
           addRegionalAdministratorVM.getMunicipalityId());
       cprField.textProperty().bindBidirectional(addRegionalAdministratorVM.cprNrProperty());
       fnameField.textProperty().bindBidirectional(addRegionalAdministratorVM.nameProperty());
       lnameField.textProperty().bindBidirectional(addRegionalAdministratorVM.lastNameProperty());
       emailField.textProperty().bindBidirectional(addRegionalAdministratorVM.emailProperty());
       passwordField.textProperty().bindBidirectional(addRegionalAdministratorVM.passwordProperty());

    }

    public void onCreateRadmin(ActionEvent actionEvent) {
        addRegionalAdministratorVM.addRegionalAdmin();
    }

    public void onBack(ActionEvent actionEvent)
    {
        SAViewHandler.getInstance().openSeeMunicipalityDetailsView();
    }

}
