package client.network;

import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;
import shared.domain.*;
import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface Client extends PropertyChangeSubject {
    void login(User user);

    void addMunicipality(Municipality municipality);

    void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);

    void unregisterClient();

    Municipality getMunicipality(String id);

    void startClient();

    void addSummerHouse(SummerHouse summerHouse);

    ArrayList<SummerHouse> getSummerHouses();

    void addTenant(Tenant tenant);

    BookingsManager getBookingsManager();


    ArrayList<Tenant> getTenants();

    SummerHousesManager getSummerHousesManager();

    List<Municipality> getAllMunicipalities();

    RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR);
}
