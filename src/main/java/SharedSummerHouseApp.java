import client.core.ClientFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class SharedSummerHouseApp extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ViewHandler viewHandler = new ViewHandler(ViewModelFactory.getInstance(), primaryStage);
        viewHandler.openLoginView();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ClientFactory.getClientFactory().getClient().unregisterClient();
    }
}
