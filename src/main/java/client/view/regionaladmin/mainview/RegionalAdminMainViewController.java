package client.view.regionaladmin.mainview;

import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
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
    raViewHandler.openManageSummerHouseView();
  }

  public void onManageBookings(ActionEvent actionEvent)
  {
    raViewHandler.openManageBookings();
  }

}
