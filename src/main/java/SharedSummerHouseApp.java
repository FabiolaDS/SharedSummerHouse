import client.core.ClientFactory;
import client.core.viewhandler.LoginViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class SharedSummerHouseApp extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        LoginViewHandler.getInstance().start(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ClientFactory.getClientFactory().getClient().unregisterClient();
    }
}
