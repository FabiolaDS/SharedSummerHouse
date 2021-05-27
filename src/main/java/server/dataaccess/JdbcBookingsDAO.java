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

    private SummerHousesDAO shdao;
    private TenantDAO tdao;

    public JdbcBookingsDAO(SummerHousesDAO shdao, TenantDAO tdao)
    {
        super("booking");

        this.shdao = shdao;
        this.tdao = tdao;
    }

    @Override
    public void save(Booking b)
    {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + getFullTableName() + " (summerhouse_id, tenant_cpr, date_from, date_to)" +
                            "VALUES (?, ?, ?, ?)");
            ps.setLong(1, b.getSummerHouse().getId());
            ps.setString(2, b.getTenant().getCpr());
            ps.setObject(3, b.getDateFrom());
            ps.setObject(4, b.getDateTo());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getFor(SummerHouse house)
    {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT date_from, date_to, summerhouse_id, tenant_cpr FROM " + getFullTableName() +
                            " WHERE summerhouse_id = ?");
            ps.setObject(1, house.getId());

            ResultSet rs = ps.executeQuery();

            List<Booking> res = new ArrayList<>();
            while (rs.next()) {
                res.add(parseBooking(rs));
            }
            return res;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getFor(Tenant tenant)
    {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT date_from, date_to, summerhouse_id, tenant_cpr FROM " + getFullTableName() +
                            " WHERE tenant_cpr = ?");
            ps.setObject(1, tenant.getCpr());

            ResultSet rs = ps.executeQuery();

            List<Booking> res = new ArrayList<>();
            while (rs.next()) {
                res.add(parseBooking(rs));
            }
            return res;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Booking b)
    {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + getFullTableName() + " WHERE summerhouse_id = ? AND date_from = ? AND date_to = ?");
            ps.setObject(1, b.getSummerHouse().getId());
            ps.setObject(2, b.getDateFrom());
            ps.setObject(3, b.getDateTo());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isBookedBetween(SummerHouse sh, LocalDate from, LocalDate to)
    {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM " + getFullTableName() + " WHERE summerhouse_id = ?" +
                            " AND ((date_from < ? AND date_to > ?) OR (date_to > ? AND date_from < ?))");

            ps.setLong(1, sh.getId());

            ps.setObject(2, to);
            ps.setObject(3, from);
            ps.setObject(4, from);
            ps.setObject(5, to);

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();
            rs.next();
            long res = rs.getLong(1);

            return res > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Booking parseBooking(ResultSet rs) throws SQLException
    {
        Booking b = new Booking();

        b.setSummerHouse(shdao.get(rs.getLong("summerhouse_id")));
        b.setTenant(tdao.get(rs.getString("tenant_cpr")));
        b.setDateFrom(rs.getObject("date_from", LocalDate.class));
        b.setDateTo(rs.getObject("date_to", LocalDate.class));

        return b;
    }
}
