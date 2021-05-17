package client.view.systemadmin.seedetails;

import client.core.viewhandler.SAViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MunicipalityDetailsViewController implements ViewController
{
   private SAViewHandler viewHandler;
   private MunicipalityDetailsViewModel detailsViewModel;


  @Override public void init() throws IOException
  {
    this.viewHandler = SAViewHandler.getInstance();
    detailsViewModel = ViewModelFactory.getInstance()
        .getMunicipalityDetailsViewModel();
  }

  public void onAddRegionalAdmin(ActionEvent actionEvent)
  {
    viewHandler.openAddRegionalAdminView();
  }

  public void onBack(ActionEvent actionEvent)
  {
    viewHandler.openMainView();
  }
}
