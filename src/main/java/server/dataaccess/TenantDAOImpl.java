package server.dataaccess;

import shared.domain.Tenant;

import java.sql.*;

public class TenantDAOImpl extends DatabaseDAO implements TenantDAO
{
    private static TenantDAOImpl instance;

    private TenantDAOImpl() throws SQLException
    {
        super("tenant");
    }

    public static synchronized TenantDAOImpl getInstance() throws SQLException
    {
        if (instance == null) {
            instance = new TenantDAOImpl();
        }
        return instance;
    }

    @Override
    public void createTenant(Tenant tenant) throws SQLException
    {
        try (Connection connection = getConnection()) {
            System.out.println("Connected");

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO " + getFullTableName() + " VALUES (?,?,?,?,?,?,?)");

            statement.setString(1, tenant.getCpr());
            statement.setString(2, tenant.getFirstName());
            statement.setString(3, null);
            statement.setString(4, tenant.getLastName());
            statement.setString(5, tenant.getPassword());
            statement.setString(6, "230689-6323"); //should be changed to getRegionalAdmin
            statement.setString(7, "101"); // should be changed to getMunicipality
            statement.executeUpdate();
        }
    }

    @Override
    public Tenant get(String cpr)
    {
        try (Connection conn = getConnection()) {

            PreparedStatement ps = conn.prepareStatement("SELECT tenant_cpr, fname, mname, lname, password, regional_admin_cpr, municipality_id FROM "
                    + getFullTableName()
                    + " WHERE tenant_cpr = ?");

            ps.setString(1, cpr);

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Tenant(
                        rs.getString("tenant_cpr"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("municipality_id"),
                        "email");
            } else {
                throw new IllegalArgumentException("No such tenant");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
