package server.model;

import server.dataaccess.SummerHousesDAO;
import shared.businesslogic.SummerHousesManager;
import shared.domain.SummerHouse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummerHousesManagerImpl extends UnicastRemoteObject implements SummerHousesManager
{
    private SummerHousesDAO dao;

    public SummerHousesManagerImpl(SummerHousesDAO dao) throws RemoteException {
        super(0);

        this.dao = dao;
    }

    @Override
    public void register(SummerHouse house)
    {
        dao.save(house);
    }

    @Override
    public List<SummerHouse> getAllSummerHouses()
    {
        return dao.getAllSummerHouses();
    }
}
