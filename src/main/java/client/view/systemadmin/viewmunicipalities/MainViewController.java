package client.view.systemadmin.viewmunicipalities;


import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class MainViewController
{
    public TableColumn muniColumn;
    public TableColumn regionColumn;
    public TableColumn idColumn;
    public TableColumn rAlminColumn;

    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private MainViewModel mainViewModel;


    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = vmf;
      //  this.mainViewModel = viewModelFactory.getMainViewModel();
    }

    public void onCreatMunicipality(ActionEvent actionEvent) throws IOException {
       // viewHandler.openAddMunicipalitiesView();
    }


    public void onSeeDetails(ActionEvent actionEvent) {
    }


    public void onAddRegionalAdmin(ActionEvent actionEvent) {
    }
}
