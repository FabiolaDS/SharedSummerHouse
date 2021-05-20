package client.core.viewhandler;

import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public interface ViewHandler
{
  void start(Stage stage)throws IOException;
  Parent loadFXML(String s);//TODO: it would be really nice to find the way this method can be private or protected

}
