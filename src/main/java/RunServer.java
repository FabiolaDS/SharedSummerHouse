import client.core.ClientFactory;

import server.dataaccess.*;
import server.model.BookingsManagerImpl;
import server.model.SummerHousesManagerImpl;
import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import server.network.RMIServerImpl;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RunServer
{
    public static void main(String[] args)
            throws IOException, AlreadyBoundException, SQLException
    {
        UserDAO userDAO = UserDAOImpl.getInstance();
        LoginModelManager loginModel = new LoginModelManager(userDAO);

        SummerHousesDAO shdao = new JdbcSummerHouseDAO();
        TenantDAO tdao = TenantDAOImpl.getInstance();
        BookingDAO bdao = new JdbcBookingsDAO(shdao, tdao);

        RMIServerImpl server = new RMIServerImpl(loginModel,
                new BookingsManagerImpl(bdao, tdao),
                new SummerHousesManagerImpl(shdao));
        server.startServer();
    }
}
