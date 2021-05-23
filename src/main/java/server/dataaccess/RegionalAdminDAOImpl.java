package server.dataaccess;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.sql.*;
import java.util.List;

public class RegionalAdminDAOImpl extends DatabaseDAO implements RegionalAdminDAO {

    private static RegionalAdminDAOImpl instance;

    private RegionalAdminDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized RegionalAdminDAOImpl getInstance() throws SQLException {
        if (instance == null)
        {
            instance = new RegionalAdminDAOImpl();
        }
        return instance;
    }

    @Override
    public RegionalAdmin create(String regional_admin_cpr, String fname, String mname, String lname, String password, String municipality_id) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"shared_summerhouse\".\"regional_admin\" VALUES (?,?,?,?,?,?,?)");

            statement.setString(1, regional_admin_cpr);
            statement.setString(2, fname);
            statement.setString(3, mname);
            statement.setString(4, lname);
            statement.setString(5, password);
            statement.setString(6, "180576-2412");
            statement.setString(7, municipality_id);
            statement.executeUpdate();

            return new RegionalAdmin(regional_admin_cpr, fname, lname ,mname, password);

        }
    }

    @Override
    public RegionalAdmin getById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<RegionalAdmin> getAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Municipality municipality) throws SQLException {

    }
}
