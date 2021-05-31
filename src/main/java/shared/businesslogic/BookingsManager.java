package shared.businesslogic;

import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeSubject;
import shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface to encapsulate business logic for bookings
 *
 * @author Fabiola
 */
public interface BookingsManager extends RemoteChangeSubject, Remote // to be able to use from client side via RMI
{

    /**
     * Books a summerhouse {@code house} for the tenant {@code tenant} from date {@code from} to date {@code to}
     *
     * @param house         summerhouse to book
     * @param tenant        booking tenant
     * @param from          start date of the booking
     * @param to            end date of the booking
     *
     * @throws RemoteException  Remote interface
     */
    void book(SummerHouse house, User tenant, LocalDate from, LocalDate to)
        throws RemoteException, SQLException;

    /**
     * Returns all bookings for given summerhouse
     *
     * @param sh    summerhouse to search by
     * @return      List containing all the bookings for given summerhouse
     *
     * @throws RemoteException  Remote interface
     */
    List<Booking> getBookingsFor(SummerHouse sh)
            throws RemoteException;
}
