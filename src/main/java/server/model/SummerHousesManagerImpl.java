package server.model;

import server.dataaccess.SummerHousesDAO;
import shared.businesslogic.SummerHousesManager;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeListener;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummerHousesManagerImpl extends UnicastRemoteObject implements SummerHousesManager
{
    private SummerHousesDAO dao;

    private List<RemoteChangeListener> listeners;

    public SummerHousesManagerImpl(SummerHousesDAO dao) throws RemoteException {
        super(0);

        this.dao = dao;

        listeners = new ArrayList<>();
    }

    @Override
    public void register(SummerHouse house) throws RemoteException
    {
        dao.save(house);
        fireChangeEvent("NEW_HOUSE", null, house);
    }

    @Override
    public List<SummerHouse> getAllSummerHouses()
    {
        return dao.getAllSummerHouses();
    }

    @Override
    public void updateSummerHouse(SummerHouse sh) throws RemoteException
    {
        dao.update(sh.getId(), sh);
        fireChangeEvent("HOUSE_UPDATED", null, sh);
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

    private void fireChangeEvent(String prop, Object oldVal, Object newVal) throws RemoteException {
        for(RemoteChangeListener l: listeners) {
            l.propertyChange(new PropertyChangeEvent(this, prop, oldVal, newVal));
        }
    }
}
