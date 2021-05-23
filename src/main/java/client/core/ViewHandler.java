package client.core;

import client.view.SummerHousesListView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf, Stage primaryStage) {
        this.vmf = vmf;
        stage = primaryStage;

        stage.show();
    }

    public void openSummerHouseList() {
        stage.setScene(new Scene(load("/summerhouseList.fxml",
                new SummerHousesListView(vmf.getSummerHousesListVM()))));
    }

    protected Parent load(String path, Object controller) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        loader.setController(controller);

        try {
            return loader.load();
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load FXML: " + e);
            alert.showAndWait();

            throw new RuntimeException(e);
        }
    }
}
