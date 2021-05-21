package server.model;

import server.dataaccess.BookingDAO;
import shared.businesslogic.BookingsManager;
import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.domain.Tenant;
import shared.domain.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingsManagerImpl extends UnicastRemoteObject implements BookingsManager
{
    private BookingDAO dao;

    public BookingsManagerImpl(BookingDAO dao) throws RemoteException {
        super(0);   //call  super constructor form Uni to export to RMI

        this.dao = dao;
    }

    @Override
    public void book(SummerHouse house, Tenant tenant, LocalDate from, LocalDate to) throws RemoteException
    {
        Booking booking = new Booking(from, to, tenant, house);
        dao.save(booking);
    }
}
