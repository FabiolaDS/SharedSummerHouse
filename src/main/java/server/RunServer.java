package server;

import client.core.ClientFactory;

import server.dataaccess.UserDAO;
import server.dataaccess.UserDAOImpl;
import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import server.network.RMIServerImpl;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args)
            throws IOException, AlreadyBoundException, SQLException {
        UserDAO userDAO = UserDAOImpl.getInstance();
       LoginModelManager loginModel = new LoginModelManager(userDAO);
        RMIServerImpl server = new RMIServerImpl(loginModel);
        server.startServer();
    }
}
