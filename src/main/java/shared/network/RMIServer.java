package shared.network;


import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;
import shared.domain.*;
import shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RMIServer extends Remote {
    String validateUser(User request) throws RemoteException, SQLException;

    List<Municipality> addMunicipality(Municipality municipality) throws RemoteException;

    Municipality getMunicipality(String id) throws RemoteException;

    List<Municipality> addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId) throws RemoteException;

    List<Municipality> getAllMunicipalities() throws RemoteException;

    void registerClient(ClientCallback clientCallback) throws RemoteException;

    void unregisterClient(ClientCallback clientCallback) throws RemoteException;

    //ArrayList<MunicipalityList> getMunicipalities() throws RemoteException;
    Municipality getMunicipality(Long id) throws RemoteException;// what does that do(return one munip)So which one(need argthen) - yes that is why it isnt compling

    SummerHouse addSummerHouse(SummerHouse summerHouse) throws RemoteException;

    Tenant addTenant(Tenant tenant) throws RemoteException;

    ArrayList<SummerHouse> getSummerHouses() throws RemoteException;


    BookingsManager getBookingsManager() throws RemoteException;

    SummerHousesManager getSummerHousesManager() throws RemoteException;

    ArrayList<Tenant> getTenants() throws RemoteException;


    RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR) throws RemoteException;
}
