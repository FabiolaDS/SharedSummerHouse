package client.view.regionaladmin.managebookings;

import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ReviewSummerhouseViewController implements ViewController
{
    private RAViewHandler viewHandler;

    @FXML
    private Slider rating;

    @FXML
    private TextArea comment;

    @FXML private Button deleteButton;

    @FXML private HBox buttonsPane;

    @FXML
    public void initialize() {
        // To remove delete button for tenant
        // if(user.isTenant())
        //    buttonsPane.getChildren().remove(deleteButton);
    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void onSubmit(ActionEvent event) {

    }

    @Override public void init() throws IOException
    {
        viewHandler = RAViewHandler.getInstance();
    }
}

