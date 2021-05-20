package server.dataaccess;

import shared.domain.Booking;
import shared.domain.SummerHouse;
import shared.domain.Tenant;
import shared.domain.User;

import java.util.List;

public interface BookingDAO
{

    void save(Booking b);

    List<Booking> getFor(SummerHouse house);
    List<Booking> getFor(Tenant tenant);

    void delete(Booking b);
}
