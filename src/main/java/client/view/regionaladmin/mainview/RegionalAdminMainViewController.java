package client.view.regionaladmin.mainview;

import client.core.ViewModelFactory;
import client.core.ViewHandler;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * RegionalAdminMainViewController class, controllers RegionalAdminMainView
 * the unique function is opening different views from the viewHandler
 */
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

  /**
   * opens SeeAllTenantsView
   * @param actionEvent click on the button
   */
  public void onSeeAllTenants(ActionEvent actionEvent)
  {
    viewHandler.openSeeAllTenants();
  }

  /**
   * opens ManageSummerHouse view
   * @param actionEvent click on the button
   */
  public void onManageSummerHouse(ActionEvent actionEvent)
  {

        viewHandler.openSummerHouseList();
  }

}
