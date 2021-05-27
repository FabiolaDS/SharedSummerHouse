package shared.businesslogic;

import shared.domain.SummerHouse;
import shared.network.RemoteChangeSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface to encapsulate business logic for summerhouses
 *
 * @author Fabiola
 */
public interface SummerHousesManager extends RemoteChangeSubject, Remote
{

    /**
     * Registers new summerhouse in the system
     *
     * @param house     summerhouse to register
     *
     * @throws RemoteException  Remote interface
     */
    void register(SummerHouse house) throws RemoteException;

    /**
     * Returns list of all summerhouses registered in the system
     *
     * @return  list of registered summerhouses
     *
     * @throws RemoteException  Remote interface
     */
    List<SummerHouse> getAllSummerHouses() throws RemoteException;

    /**
     * Updates summerhouse date in the system
     *
     * @param sh    summerhouse to update
     *
     * @throws RemoteException  Remote interface
     */
    void updateSummerHouse(SummerHouse sh) throws RemoteException;
}
