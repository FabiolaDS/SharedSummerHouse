package server.model;

import server.dataaccess.BookingDAO;
import server.dataaccess.TenantDAO;
import shared.businesslogic.BookingsManager;
import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeListener;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingsManagerImpl extends UnicastRemoteObject implements BookingsManager
{
    private BookingDAO bdao;
    private TenantDAO tdao;

    private List<RemoteChangeListener> listeners;

    public BookingsManagerImpl(BookingDAO bdao, TenantDAO tdao) throws RemoteException
    {
        super(0);   //call  super constructor form Uni to export to RMI

        this.bdao = bdao;
        this.tdao = tdao;

        listeners = new ArrayList<>();
    }


    @Override
    public void book(SummerHouse house, User tenant, LocalDate from,
                     LocalDate to) throws RemoteException
    {
        if(bdao.isBookedBetween(house, from, to)) {
            throw new IllegalArgumentException("Summerhouse is already booked at that time");
        }

        Booking booking = new Booking(tdao.get(tenant.getCpr()), house, from, to);
        bdao.save(booking);

        for(RemoteChangeListener l: listeners) {
            l.propertyChange(new PropertyChangeEvent(this, "NEW_BOOKING", null, booking));
        }
    }

    @Override
    public List<Booking> getBookingsFor(SummerHouse sh)
    {
        return bdao.getFor(sh);
    }

    @Override
    public void addListener(RemoteChangeListener rcl) throws RemoteException
    {
        listeners.add(rcl);
    }

    @Override
    public void removeListener(RemoteChangeListener rcl) throws RemoteException
    {
        listeners.remove(rcl);
    }
}
