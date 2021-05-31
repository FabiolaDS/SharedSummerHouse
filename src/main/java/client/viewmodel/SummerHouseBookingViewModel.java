package client.viewmodel;

import client.model.login.LoginModel;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.businesslogic.BookingsManager;
import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeListener;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDate;

public class SummerHouseBookingViewModel extends UnicastRemoteObject implements RemoteChangeListener
{
    private ObjectProperty<SummerHouse> selected = new SimpleObjectProperty<>();

    private ObjectProperty<LocalDate> dateFrom = new SimpleObjectProperty<>(),
            dateTo = new SimpleObjectProperty<>();

    private ObservableList<Booking> bookings;

    private BookingsManager bman;
    private LoginModel lm;

    public SummerHouseBookingViewModel(BookingsManager bman, LoginModel lm) throws RemoteException
    {
        super(0);

        this.bman = bman;
        this.lm = lm;

        this.bookings = FXCollections.observableArrayList();

        selected.addListener((obs, o, n) -> updateBookings());

        bman.addListener(this);
    }

    public void book()
    {
        try {
            bman.book(selected.get(), lm.getCurrentUser(), dateFrom.get(), dateTo.get());
        } catch (RemoteException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectProperty<LocalDate> dateFromProperty()
    {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> dateToProperty()
    {
        return dateTo;
    }

    public ObjectProperty<SummerHouse> selectedProperty()
    {
        return selected;
    }

    public void setSelected(SummerHouse sh)
    {
        selected.set(sh);
    }

    public ObservableList<Booking> getBookings()
    {
        return bookings;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException
    {
        updateBookings();
    }

    private void updateBookings()
    {
        try {
            bookings.setAll(bman.getBookingsFor(selected.get()));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
