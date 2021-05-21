package shared.businesslogic;

import shared.domain.SummerHouse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SummerHousesManager extends Remote
{

    void register(SummerHouse house) throws RemoteException;

    List<SummerHouse> getAllSummerHouses() throws RemoteException;
}
