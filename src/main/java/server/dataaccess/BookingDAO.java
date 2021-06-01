package server.dataaccess;

import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.domain.Tenant;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface for Data Access Object for the bookings
 *
 * @author Fabiola
 */
public interface BookingDAO
{

    /**
     * Persists new booking
     *
     * @param b     booking object to persist
     */
    void save(Booking b);

    /**
     * Returns all the bookings for given summerhouse
     *
     * @param house     summerhouse to find bookings for
     *
     * @return          list of bookings for summerhouse
     */
    List<Booking> getFor(SummerHouse house);

    /**
     * Returns all the bookings made by given tenant
     *
     * @param tenant    tenant to search bookings by
     *
     * @return          list of bookings made by tenant
     */
    List<Booking> getFor(Tenant tenant);

    /**
     * Deletes given booking
     *
     * @param b     booking to delete
     */
    void delete(Booking b);

    /**
     * Checks if there are any bookings for given summerhouse from {@code from} to {@code to}
     *
     * @param sh        summerhouse to search by
     * @param from      start date
     * @param to        end date
     *
     * @return          true if found any bookings matching criteria; false otherwise
     */
    boolean isBookedBetween(SummerHouse sh, LocalDate from, LocalDate to);
}
