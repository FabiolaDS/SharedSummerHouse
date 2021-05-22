package server.dataaccess;

import shared.domain.Municipality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityDAOImpl extends DatabaseDAO implements MunicipalityDAO{

    private static MunicipalityDAOImpl instance;

    private MunicipalityDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized MunicipalityDAOImpl getInstance() throws SQLException {
        if (instance == null)
        {
            instance = new MunicipalityDAOImpl();
        }
        return instance;
    }
    @Override
    public Municipality create(String municipality_id, String name, String region) throws SQLException {

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"shared_summerhouse\".\"municipality\" VALUES (?, ?, ?, ?, null)");
            statement.setString(1, municipality_id);
            statement.setString(2, name);
            statement.setString(3, region);
            statement.setString(4, "180576-2412");
            statement.executeUpdate();
             return new Municipality(name, region, municipality_id);
        }

    }

    @Override
    public Municipality getById(String id) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"shared_summerhouse\".\"municipality\" WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String region = resultSet.getString("region");
                return new Municipality(name, region, id);
            } else {
                return null;
            }
        }
    }

    @Override
    public List<Municipality> getAll() throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"shared_summerhouse\".\"municipality\" LIMIT 100");

            ResultSet resultSet = statement.executeQuery();
            ArrayList<Municipality> result = new ArrayList<>();
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String region = resultSet.getString("region");
                String municipality_id = resultSet.getString("municipality_id");

                Municipality municipality = new Municipality(name, region, municipality_id);
                result.add(municipality);
            }
            return result;

        }
    }

    @Override
    public void update(Municipality municipality) throws SQLException {

    }
}
