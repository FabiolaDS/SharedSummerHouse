package client.view.systemadmin.viewmunicipalities;


import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.domain.Municipality;

import java.io.IOException;

public class MainViewController implements ViewController
{
    public TableColumn<Municipality, String> muniColumn;
    public TableColumn<Municipality, String> regionColumn;
    public TableColumn<Municipality, String> idColumn;
    public TableColumn<Municipality, String> rAdminColumn;
    public TableView<Municipality> municipalityTable;


    private SAViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private MainViewModel mainViewModel;


    public void init() {

        this.viewModelFactory = ViewModelFactory.getInstance();
        this.mainViewModel = viewModelFactory.getMainViewModel();
        viewHandler = SAViewHandler.getInstance();

        muniColumn.setCellValueFactory(new PropertyValueFactory<Municipality, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Municipality, String>("id"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<Municipality, String>("region"));
        tableViewLoad();

    }
     private void tableViewLoad()
     {
         municipalityTable.setItems(mainViewModel.getMunicipalities());
     }
    public void onCreatMunicipality(ActionEvent actionEvent) throws IOException {
        viewHandler.openAddMunicipalityView();
    }


    public void onSeeDetails(ActionEvent actionEvent) {
        viewHandler.openSeeMunicipalityDetailsView();
    }



}
