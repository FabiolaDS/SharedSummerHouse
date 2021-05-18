package client.core.viewhandler;

import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewHandler implements ViewHandler {

    public Stage stage;
    private ViewModelFactory vmf;
    private static LoginViewHandler loginViewHandler;

    private LoginViewHandler() {

        vmf = ViewModelFactory.getInstance();
    }

    public static LoginViewHandler getInstance() {
        if (loginViewHandler == null) {
            loginViewHandler = new LoginViewHandler();
        }
        return loginViewHandler;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        openLoginView();
    }

    public void openLoginView() {
        Scene scene;
        stage.setTitle("Login");
        scene = new Scene(loadFXML("/LoginView.fxml"));
        stage.setScene(scene);
        stage.show();
    }

    @Override
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
