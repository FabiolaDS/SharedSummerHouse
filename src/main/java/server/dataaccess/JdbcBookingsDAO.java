package server.dataaccess;

import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.domain.Tenant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookingsDAO extends DatabaseDAO implements BookingDAO
{

    public JdbcBookingsDAO() {
        super("booking");
    }

    @Override
    public void save(Booking b)
    {
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + getFullTableName() + " (date_from, date_to, total_price, summerhouse_id, tenant_cpr)" +
                            "VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, b.getDateFrom());
            ps.setObject(2, b.getDateTo());
            ps.setDouble(3, b.getTotalPrice());
            ps.setLong(4, b.getSummerHouse().getId());
            ps.setString(5, b.getTenant().getCpr());

            ps.executeUpdate();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getFor(SummerHouse house)
    {
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT date_from, date_to, summerhouse_id, tenant_cpr FROM " + getFullTableName() +
                            " WHERE b.summerhouse_id = ?");
            ps.setObject(1, house.getId());

            ResultSet rs = ps.executeQuery();

            List<Booking> res = new ArrayList<>();
            while(rs.next()) {
                Booking b = new Booking();
                b.setDateFrom(rs.getObject(1, LocalDate.class));
                b.setDateFrom(rs.getObject(2, LocalDate.class));

                // needs DAO for summerhouses and tenants

                res.add(b);
            }

            return res;

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getFor(Tenant tenant)
    {
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT date_from, date_to, summerhouse_id, tenant_cpr FROM " + getFullTableName() +
                            " WHERE b.tenant_cpr = ?");
            ps.setObject(1, tenant.getCpr());

            ResultSet rs = ps.executeQuery();

            List<Booking> res = new ArrayList<>();
            while(rs.next()) {
                Booking b = new Booking();
                b.setDateFrom(rs.getObject(1, LocalDate.class));
                b.setDateFrom(rs.getObject(2, LocalDate.class));

                // needs DAO for summerhouses and tenants

                res.add(b);
            }

            return res;

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Booking b)
    {
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + getFullTableName() + " WHERE summerhouse_id = ? AND date_from = ? AND date_to = ?");
            ps.setObject(1, b.getSummerHouse().getId());
            ps.setObject(2, b.getDateFrom());
            ps.setObject(3, b.getDateTo());

            ps.executeUpdate();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
