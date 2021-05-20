package server.dataaccess;

import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.domain.Tenant;

import java.util.ArrayList;
import java.util.List;

public class DummyBookingsDAO implements BookingDAO
{

    private ArrayList<Booking> bookings;

    public DummyBookingsDAO() {
        bookings = new ArrayList<>();
    }

    @Override
    public void save(Booking b)
    {
        bookings.add(b);
    }

    @Override
    public List<Booking> getFor(SummerHouse house)
    {
        ArrayList<Booking> result = new ArrayList<>();

        for(Booking b: bookings) {
            if(b.getSummerHouse().equals(house)) {
                result.add(b);
            }
        }

        return result;
    }

    @Override
    public List<Booking> getFor(Tenant tenant)
    {
        ArrayList<Booking> result = new ArrayList<>();

        for(Booking b: bookings) {
            if(b.getTenants().contains(tenant)) {
                result.add(b);
            }
        }

        return result;
    }

    @Override
    public void delete(Booking b)
    {
        bookings.remove(b);
    }
}
