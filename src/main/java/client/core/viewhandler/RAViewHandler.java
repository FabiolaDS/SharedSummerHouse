package client.core.viewhandler;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class RAViewHandler implements ViewHandler
{

  public Stage stage;
  private ViewModelFactory vmf;

  @Override public void start(Stage stage) throws IOException
  {
    vmf = ViewModelFactory.getInstance();
    this.stage = stage;
  }

  @Override public Parent loadFXML(String s)
  {
    return null;
  }
}
