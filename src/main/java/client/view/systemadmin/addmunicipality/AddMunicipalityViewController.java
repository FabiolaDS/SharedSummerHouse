package client.view.systemadmin.addmunicipality;


import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMunicipalityViewController implements ViewController
{
    public TextField muniNameLabel;
    public TextField muniRegionLabel;


    private SAViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private AddMunicipalityViewModel addMunicipalityViewModel;

    @Override public void init() throws IOException
    {
        this.viewHandler = SAViewHandler.getInstance() ;
        this.addMunicipalityViewModel = ViewModelFactory.getInstance().addMunicipalityViewModel();

    }

    public void onCreateMuni(ActionEvent actionEvent) {

    }

    public void onAddRegionalAdmin(ActionEvent actionEvent) {

    }

    public void onBackToMain(ActionEvent actionEvent) throws IOException {
       viewHandler.openMainView();
    }


}
