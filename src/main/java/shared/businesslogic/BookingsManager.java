package shared.businesslogic;

import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeSubject;
import shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

public interface BookingsManager extends RemoteChangeSubject, Remote // to be able to use from client side
{

    void book(SummerHouse house, User tenant, LocalDate from, LocalDate to)
            throws RemoteException;

    List<Booking> getBookingsFor(SummerHouse sh)
            throws RemoteException;
}
