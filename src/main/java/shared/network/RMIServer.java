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

/**
 * Interface extending Remote and implemented by the RMIServer so that it can
 * be called from the client.
 *
 * @author Luis Fernandez Ponton
 * @version 1.0
 */
public interface RMIServer extends Remote
{
    /**
     * Validates the user credentials by calling the model in the server.
     *
     * @param user the user trying to log in
     * @return returns a string with a validation message
     * @throws RemoteException error in connection
     * @throws SQLException    errors from the database
     */
    String validateUser(User user) throws RemoteException, SQLException;

    /**
     * Adds a municipality to the database
     *
     * @param municipality the municipality being added
     * @return returns a list of municipalities that will be displayed
     * @throws RemoteException error in connection
     */
    List<Municipality> addMunicipality(Municipality municipality)
        throws RemoteException;

    /**
     * Gets a municipality from the database
     *
     * @param id the id of the municipality
     * @return a municipality with the desired id
     * @throws RemoteException errors in connection
     */
    Municipality getMunicipality(String id) throws RemoteException;

    /**
     * Adds a regional administrator to the database
     *
     * @param regionalAdmin  the regional admin to be added
     * @param municipalityId the regional admin's municipality
     * @return a list of municipalities
     * @throws RemoteException errors in connection
     */
    List<Municipality> addRegionalAdmin(RegionalAdmin regionalAdmin,
        String municipalityId) throws RemoteException;

    /**
     * Gets a list of municipalities from the database.
     *
     * @return a list of municipalities
     * @throws RemoteException errors in connection
     */
    List<Municipality> getAllMunicipalities() throws RemoteException;

    /**
     * Registers a client as a listener to the server
     *
     * @param clientCallback the client to be registered
     * @throws RemoteException errors in connection
     */
    void registerClient(ClientCallback clientCallback) throws RemoteException;

    /**
     * Unregisters a client as a listener from the server
     *
     * @param clientCallback the client to be registered
     * @throws RemoteException errors in connection
     */
    void unregisterClient(ClientCallback clientCallback) throws RemoteException;

    /**
     * Adds a tenant to the database
     *
     * @param tenant the tenant to be added
     * @return the tenant found
     * @throws RemoteException errors in connection
     * @throws SQLException    errors from the database
     */
    Tenant addTenant(Tenant tenant) throws RemoteException, SQLException;

    BookingsManager getBookingsManager() throws RemoteException;

    SummerHousesManager getSummerHousesManager() throws RemoteException;

    /**
     * Gets a list of tenants from the database
     * @return a list of tenants
     * @throws RemoteException errors from the database
     */
    ArrayList<Tenant> getTenants() throws RemoteException;

    /**
     * Deletes a regional admin from the database
     * @param regionalAdmin the regional admin to be deleted
     * @throws RemoteException errors in connection
     */
    void deleteRegionalAdmin(RegionalAdmin regionalAdmin) throws RemoteException;

    /**
     * Gets a regional admin using a cpr
     * @param regionalAdminCPR The regional admin's cpr
     * @return the regional admin with the cpr
     * @throws RemoteException errors in connection
     */
    RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR)
        throws RemoteException;

    /**
     * Deletes a municipality from the database
     * @param id the id of the municipality
     * @throws RemoteException errors in connection
     */
    void deleteMunicipality(String id) throws RemoteException;

    /**
     * Gets a list of tenants
     * @return a list of tenants
     * @throws RemoteException errors in connection
     */
    List<Tenant> getAllTenants() throws RemoteException;
}