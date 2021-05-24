package shared.businesslogic;

import shared.domain.SummerHouse;
import shared.network.RemoteChangeSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SummerHousesManager extends RemoteChangeSubject, Remote
{

    void register(SummerHouse house) throws RemoteException;

    List<SummerHouse> getAllSummerHouses() throws RemoteException;

    void updateSummerHouse(SummerHouse sh) throws RemoteException;
}
