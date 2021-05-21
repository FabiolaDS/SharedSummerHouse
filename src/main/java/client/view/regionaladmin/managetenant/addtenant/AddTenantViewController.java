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
  public TextField cprLabel;
  public TextField firstNameLabel;
  public TextField lastnameLabel;
  public TextField municipalityLabel;
  public TextField emailLabel;
  public TextField passwordLabel;
  public TextField typeLabel;

  private RAViewHandler viewHandler;
  private AddTenantViewModel addTenantViewModel;

  @Override public void init() throws IOException
  {
    this.viewHandler = RAViewHandler.getInstance();
    this.addTenantViewModel = ViewModelFactory.getInstance().getAddTenantViewModel();
    cprLabel.textProperty().bindBidirectional(addTenantViewModel.cprProperty());
    firstNameLabel.textProperty().bindBidirectional(addTenantViewModel.firstNameProperty());
    lastnameLabel.textProperty().bindBidirectional(addTenantViewModel.lastNameProperty());
    municipalityLabel.textProperty().bindBidirectional(addTenantViewModel.municipalityProperty());
    emailLabel.textProperty().bindBidirectional(addTenantViewModel.emailProperty());


  }
  public void onCreateTenants(javafx.event.ActionEvent actionEvent)
  {
    try
    {
      addTenantViewModel.addTenant(cprLabel.getText(), firstNameLabel.getText(),
          lastnameLabel.getText(), municipalityLabel.getText(),
          emailLabel.getText());
          //passwordLabel.getSelectedText(), typeLabel.textProperty());
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    reset();
  }

  public void onEditTenants(javafx.event.ActionEvent actionEvent)
  {
  }

  public void onBackToMain(ActionEvent actionEvent) throws IOException {
    viewHandler.openMainView();
  }

  private void reset(){
    cprLabel.clear();
    firstNameLabel.clear();
    lastnameLabel.clear();
    municipalityLabel.clear();
    emailLabel.clear();
    passwordLabel.clear();
    typeLabel.clear();
  }


}
