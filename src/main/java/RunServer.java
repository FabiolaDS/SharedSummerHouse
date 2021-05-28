import server.dataaccess.*;
import server.model.BookingsManagerImpl;
import server.model.SummerHousesManagerImpl;
import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import server.model.municipalities.ServerManageMunicipalities;
import server.model.municipalities.ServerManageMunicipalitiesImp;
import server.model.tenants.ServerManageTenants;
import server.model.tenants.ServerManageTenantsImpl;
import server.network.RMIServerImpl;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.sql.SQLException;

public class RunServer
{
    public static void main(String[] args)
            throws IOException, AlreadyBoundException, SQLException
    {
        UserDAO userDAO = UserDAOImpl.getInstance();
        MunicipalityDAO municipalityDAO = MunicipalityDAOImpl.getInstance();
        RegionalAdminDAO regionalAdminDAO = RegionalAdminDAOImpl.getInstance();
        TenantDAO tenantDAO = TenantDAOImpl.getInstance();
        LoginModel loginModel = new LoginModelManager(userDAO);
        ServerManageMunicipalities manageMunicipalities = new ServerManageMunicipalitiesImp(
                municipalityDAO, regionalAdminDAO);
        ServerManageTenants manageTenants = new ServerManageTenantsImpl(tenantDAO);

        SummerHousesDAO shdao = new JdbcSummerHouseDAO();
        TenantDAO tdao = TenantDAOImpl.getInstance();
        BookingDAO bdao = new JdbcBookingDAO(shdao, tdao);

        RMIServerImpl server = new RMIServerImpl(loginModel, manageMunicipalities,
                manageTenants,
                new BookingsManagerImpl(bdao, tdao),
                new SummerHousesManagerImpl(shdao));
        server.startServer();
    }
}
