package client.core.viewhandler;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.regionaladmin.managesummerhouse.viewsummerhouse.ManageSummerHouseModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SAViewHandler implements ViewHandler
{
  private static SAViewHandler saViewHandler;
  public Stage stage;
  private ViewModelFactory vmf;
  private HashMap<String, ViewController> controllers;


  private SAViewHandler()
  {
    this.controllers = new HashMap<>();
  }

  public static SAViewHandler getInstance(){
    if (saViewHandler == null)
    {
      saViewHandler = new SAViewHandler();
    }

    return saViewHandler;
  }

  @Override public void start(Stage stage) throws IOException {
    vmf = ViewModelFactory.getInstance();
    this.stage = stage;

     openMainView();

  }
/*
   Views for System administrator
 */
  public void openMainView()
  {
    Scene scene;
    stage.setTitle("Main View for System Admin");
    scene = new Scene(loadFXML("/MainView.fxml"));
    stage.setScene(scene);
    stage.show();
  }

  public void openSeeMunicipalityDetailsView()
  {
    Scene scene;
   // Parent root = getRoot("/MunicipalityDetailsView.fxml");
    stage.setTitle("Municipality details");
    scene = new Scene(loadFXML("/MunicipalityDetailsView.fxml"));
    stage.setScene(scene);
    stage.show();
  }

  public void openAddMunicipalityView()
  {
    Scene scene;
    Parent root = loadFXML("/AddMunicipalityView.fxml");
    stage.setTitle("Add Municipality");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAddRegionalAdminView()
  {
    Scene scene;
    Parent root = loadFXML("/AddRegionalAdminView.fxml");
    stage.setTitle("Add Regional Admin");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  // views for regional adm

  public void openManageSummerHouseView()
  {
    Scene scene;
    Parent root = loadFXML("/ManageSummerHouse.fxml");
    stage.setTitle("Manage Summerhouses");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  public void openAddTenantsView()
  {
    Scene scene;
    Parent root = loadFXML("/SeeAllTenantsView.fxml");
    stage.setTitle("Registered tenants");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }



   public Parent loadFXML(String s) {
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
