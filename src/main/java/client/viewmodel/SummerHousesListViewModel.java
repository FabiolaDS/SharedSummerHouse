package client.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.businesslogic.SummerHousesManager;
import shared.domain.SummerHouse;
import shared.transferobjects.User;

import java.rmi.RemoteException;
import java.util.List;

public class SummerHousesListViewModel
{
    private SummerHousesManager manager;

    private ObservableList<SummerHouse> summerhouses;
    private User currentUser;

    private BooleanProperty canEdit = new SimpleBooleanProperty();

    public SummerHousesListViewModel(SummerHousesManager manager, User currentUser)
    {
        this.manager = manager;
        this.currentUser = currentUser;

        canEdit.set(!currentUser.getUserType().equals("Tenant"));

        try {
            this.summerhouses = FXCollections.observableArrayList(manager.getAllSummerHouses());
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
}
