package client.view.regionaladmin.mainview;

import client.core.ViewModelFactory;
import client.core.ViewHandler;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RegionalAdminMainViewController
{
  private ViewHandler viewHandler;

  public RegionalAdminMainViewController(ViewHandler viewHandler, Object o)
  {
    this.viewHandler = viewHandler;
  }

   public void initialize()
  {

  }
  public void onSeeAllTenants(ActionEvent actionEvent)
  {
    viewHandler.openSeeAllTenants();
  }

  public void onManageSummerHouse(ActionEvent actionEvent)
  {

        viewHandler.openSummerHouseList();
  }

}
