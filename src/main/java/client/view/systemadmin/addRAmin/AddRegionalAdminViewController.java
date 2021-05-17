package client.view.systemadmin.addRAmin;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddRegionalAdminViewController implements ViewController
{

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

    }

    public void onCreateRadmin(ActionEvent actionEvent) {
    }

    public void onBack(ActionEvent actionEvent)
    {
        SAViewHandler.getInstance().openSeeMunicipalityDetailsView();
    }

}
