package client.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.businesslogic.SummerHousesManager;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeListener;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SummerHousesListViewModel extends UnicastRemoteObject implements RemoteChangeListener
{
    private SummerHousesManager manager;

    private ObservableList<SummerHouse> summerhouses;
    private User currentUser;

    private BooleanProperty canEdit = new SimpleBooleanProperty();

    public SummerHousesListViewModel(SummerHousesManager manager, User currentUser) throws RemoteException
    {
        super(0);

        this.manager = manager;
        this.currentUser = currentUser;

        canEdit.set(!currentUser.getUserType().equals("Tenant"));

        try {
            this.summerhouses = FXCollections.observableArrayList(manager.getAllSummerHouses());
            manager.addListener(this);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<SummerHouse> getSummerHouses()
    {
        return summerhouses;
    }

    public ReadOnlyBooleanProperty canEditProperty() {
        return canEdit;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException
    {
        summerhouses.setAll(manager.getAllSummerHouses());
    }
}
