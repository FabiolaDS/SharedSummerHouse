package client.view.regionaladmin.managebookings;

import client.core.viewhandler.RAViewHandler;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ManageBookingsViewController implements ViewController
{
   private RAViewHandler viewHandler;
    @FXML
    private TableView<?> currentBookings;

    @FXML
    private TableView<?> pastBookings;

    @FXML
    void cancelBooking(ActionEvent event) {

    }

    @FXML
    void reviewBooking(ActionEvent event) {

    }

    @Override public void init() throws IOException
    {
        viewHandler = RAViewHandler.getInstance();

    }
}
