package server.dataaccess;

import shared.domain.RegionalAdmin;
import shared.domain.SummerHouse;

import java.sql.*;
import java.util.ArrayList;

public class JdbcSummerHouseDAO extends DatabaseDAO implements SummerHousesDAO
{
    private RegionalAdminDAO radao;

    public JdbcSummerHouseDAO(RegionalAdminDAO radao)
    {
        super("summerhouse");
        this.radao = radao;
    }

    @Override
    public void save(SummerHouse h)
    {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO " + getFullTableName() + " (street, house_no, post_code, region, title, description, price, capacity, reg_admin)"
                            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, h.getStreet());
            ps.setInt(2, h.getHouseNumber());
            ps.setInt(3, h.getPostCode());
            ps.setString(4, h.getRegion());
            ps.setString(5, h.getTitle());
            ps.setString(6, h.getDescription());
            ps.setDouble(7, h.getPricePerNight());
            ps.setInt(8, h.getCapacity());
            ps.setString(9, h.getAdmin().getCpr());

            ps.executeUpdate();

            ResultSet key = ps.getGeneratedKeys();
            if (key.next()) {
                h.setId(key.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SummerHouse get(Long id)
    {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM " + getFullTableName() + " WHERE id = ?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return parseSummerHouse(rs);
            }

            throw new IllegalArgumentException("No summerhouse with id " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<SummerHouse> getAllSummerHouses()
    {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM " + getFullTableName());

            ResultSet rs = ps.executeQuery();

            ArrayList<SummerHouse> res = new ArrayList<>();
            while (rs.next()) {
                SummerHouse result = parseSummerHouse(rs);
                res.add(result);
            }

            return res;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id, SummerHouse h)
    {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE " + getFullTableName() + " SET"
                            + " street = ?,"
                            + " house_no = ?,"
                            + " post_code = ?,"
                            + " region = ?,"
                            + " title = ?,"
                            + " description = ?,"
                            + " price = ?,"
                            + " capacity = ?"
//                            + " reg_admin = ?"
                            + " WHERE id = ?");

            ps.setLong(10, id);

            ps.setString(1, h.getStreet());
            ps.setInt(2, h.getHouseNumber());
            ps.setInt(3, h.getPostCode());
            ps.setString(4, h.getRegion());
            ps.setString(5, h.getTitle());
            ps.setString(6, h.getDescription());
            ps.setDouble(7, h.getPricePerNight());
            ps.setInt(8, h.getCapacity());
            ps.setString(9, h.getAdmin().getCpr());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new IllegalArgumentException("No summerhouse with id " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private SummerHouse parseSummerHouse(ResultSet rs) throws SQLException
    {
        RegionalAdmin admin = radao.getById(rs.getString("reg_admin"));

        SummerHouse res = new SummerHouse(
                rs.getString("street"),
                rs.getInt("house_no"),
                rs.getInt("post_code"),
                rs.getString("region"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getInt("capacity"),
                admin);

        res.setId(rs.getLong(1));

        return res;
    }
}