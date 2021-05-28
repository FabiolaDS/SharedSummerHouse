package client.view.regionaladmin.mainview;

import client.core.ViewModelFactory;
import client.core.viewhandler.LoginViewHandler;
import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RegionalAdminMainViewController implements ViewController
{
  private RAViewHandler raViewHandler;

  @Override public void init() throws IOException
  {
  raViewHandler = RAViewHandler.getInstance();
  }
  public void onSeeAllTenants(ActionEvent actionEvent)
  {
    raViewHandler.openSeeAllTenants();
  }

  public void onManageSummerHouse(ActionEvent actionEvent)
  {
    new client.view.ViewHandler(
        ViewModelFactory.getInstance(),
        LoginViewHandler.getInstance().getStage())
        .openSummerHouseList();
  }

}
