package shared.businesslogic;

import shared.domain.SummerHouse;
import shared.domain.Tenant;
import shared.domain.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface BookingsManager extends Remote // to be able to use from client side
{

    void book(SummerHouse house, Tenant tenant, LocalDate from, LocalDate to)
            throws RemoteException;
}
