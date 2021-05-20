package client.view.regionaladmin.managetenant.addtenant;

import client.core.ViewModelFactory;
import client.core.viewhandler.RAViewHandler;
import client.core.viewhandler.SAViewHandler;
import client.view.ViewController;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;

public class AddTenantViewController implements ViewController
{
  public TextField cprNrLabel;
  public TextField firstNameLabel;
  public TextField lastnameLabel;
  public TextField municipalityLabel;
  public TextField emailLabel;

  private RAViewHandler viewHandler;
  private AddTenantViewModel addTenantViewModel;

  @Override public void init() throws IOException
  {
    this.viewHandler = RAViewHandler.getInstance();
    this.addTenantViewModel = ViewModelFactory.getInstance().addTenantViewModel();

  }

  public void onCreateTenants(ActionEvent actionEvent) throws RemoteException
  {
    addTenantViewModel.addTenant(cprNrLabel.getText(), firstNameLabel.getText(),
        lastnameLabel.getText(), municipalityLabel.getText(), emailLabel.getText());
    reset();
  }

  public void onEditTenants(ActionEvent actionEvent){}

  public void onBackToMain(ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }

  private void reset(){
    cprNrLabel.clear();
    firstNameLabel.clear();
    lastnameLabel.clear();
    municipalityLabel.clear();
    emailLabel.clear();
  }
}
