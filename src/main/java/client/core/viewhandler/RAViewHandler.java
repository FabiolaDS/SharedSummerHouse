package client.core.viewhandler;

import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RAViewHandler implements ViewHandler
{

  public Stage stage;
  private ViewModelFactory vmf;
  private static RAViewHandler raViewHandler;

  private RAViewHandler()
  {

  }

  public static RAViewHandler getInstance()
  {
    if (raViewHandler == null)
    {
      raViewHandler = new RAViewHandler();
    }
    return raViewHandler;
  }

  @Override public void start(Stage stage) throws IOException
  {
    vmf = ViewModelFactory.getInstance();
    this.stage = stage;
    openMainView();
  }

  public void openMainView()
  {
    Scene scene;
    stage.setTitle("Regional Admin Main View ");
    scene = new Scene(loadFXML("/RegionalAdminMainView.fxml"));
    stage.setScene(scene);
    stage.show();
  }


  public void openAddSummerHousesView()
  {
    Scene scene;
    stage.setTitle("Add Summer houses ");
    scene = new Scene(loadFXML("/AddSummerhouse.fxml"));
    stage.setScene(scene);
    stage.show();
  }

  public void openManageSummerHouseView()
  {
    Scene scene;
    stage.setTitle("Main View for System Admin");
    scene = new Scene(loadFXML("/ManageSummerHouse.fxml"));
    stage.setScene(scene);
    stage.show();
  }

  public void openAddTenantView()
  {
    Scene scene;
    stage.setTitle("Add Tenants view");
    scene = new Scene(loadFXML("/AddTenantView.fxml"));
    stage.setScene(scene);
    stage.show();
  }
  public void openSeeAllTenants()
  {
    Scene scene;
    stage.setTitle("See all tenants");
    scene = new Scene(loadFXML("/SeeAllTenantsView.fxml"));
    stage.setScene(scene);
    stage.show();
  }

  public void openManageBookings()
  {

    Scene scene;
    stage.setTitle("Bookings");
    scene = new Scene(loadFXML("/ManageBookings.fxml"));
    stage.setScene(scene);
    stage.show();
  }

  @Override public Parent loadFXML(String s)
  {
    Parent root = null;
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(s));
      root = loader.load();
      ViewController ctrl = loader.getController();

      ctrl.init();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return root;
  }
}
