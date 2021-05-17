package client.view.systemadmin.viewmunicipalities;


import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class MainViewController implements ViewController
{
    public TableColumn muniColumn;
    public TableColumn regionColumn;
    public TableColumn idColumn;
    public TableColumn rAlminColumn;


    private SAViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private MainViewModel mainViewModel;


    public void init() {

        this.viewModelFactory = ViewModelFactory.getInstance();
        this.mainViewModel = viewModelFactory.getMainViewModel();
        viewHandler = SAViewHandler.getInstance();
    }

    public void onCreatMunicipality(ActionEvent actionEvent) throws IOException {
        viewHandler.openAddMunicipalityView();
    }


    public void onSeeDetails(ActionEvent actionEvent) {
        viewHandler.openSeeMunicipalityDetailsView();
    }



}
