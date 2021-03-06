package server.network;

import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import server.model.municipalities.ServerManageMunicipalities;
import server.model.municipalities.ServerManageMunicipalitiesImp;
import server.model.tenants.ServerManageTenants;
import server.model.tenants.ServerManageTenantsImpl;
import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;
import shared.domain.*;
import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferobjects.EventType;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIServerImpl implements RMIServer {

    private LoginModel loginModel;
    private ServerManageMunicipalities municipalitiesModel;
    private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();
    private ServerManageTenants tenantsModel;

    private BookingsManager bookings;
    private SummerHousesManager summerhouses;

    public RMIServerImpl(LoginModel loginModel,
                         ServerManageMunicipalities manageMunicipalities,
                         ServerManageTenants manageTenants,
                         BookingsManager bookings,
                         SummerHousesManager houses) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.loginModel = loginModel;
        this.municipalitiesModel = manageMunicipalities;
        this.tenantsModel = manageTenants;

        this.bookings = bookings;
        this.summerhouses = houses;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
    }

    @Override
    public String validateUser(User user) throws SQLException {
        return loginModel.validateUser(user);
    }

    @Override
    public List<Municipality> addMunicipality(Municipality municipality)
            throws RemoteException {
        List<Municipality> municipalities = null;
        try {
            municipalities = municipalitiesModel.addMunicipality(municipality);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return municipalities;
    }

    @Override
    public Municipality getMunicipality(String id)
            throws RemoteException {
        Municipality municipality = null;
        try {
            municipality = municipalitiesModel.getMunicipality(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return municipality;
    }

    @Override
    public List<Municipality> addRegionalAdmin(RegionalAdmin regionalAdmin,
                                               String municipalityID) {
        System.out.println("SERVER calling server model to add RA");
        List<Municipality> municipalities = null;
        try {
            municipalities = municipalitiesModel.setRegionalAdmin(regionalAdmin, municipalityID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return municipalities;
    }

    @Override public void deleteRegionalAdmin(RegionalAdmin regionalAdmin)
    {
        try
        {
            municipalitiesModel.deleteRegionalAdmin(regionalAdmin);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }


    @Override
    public void registerClient(ClientCallback clientCallback)
            throws RemoteException {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    clientCallback
                            .updates(EventType.UPDATE.toString(), evt.getNewValue());
                } catch (RemoteException e) {
                    loginModel
                            .removePropertyChangeListener(EventType.UPDATE.toString(), this);
                }
            }
        };
        listeners.put(clientCallback, listener);
        loginModel.addPropertyChangeListener(EventType.UPDATE.toString(), listener);
    }

    @Override
    public void unregisterClient(ClientCallback clientCallback)
            throws RemoteException {
        PropertyChangeListener listener = listeners.get(clientCallback);
        if (listener != null) {
            listeners.remove(clientCallback, listener);
            loginModel.removePropertyChangeListener(listener);
        }
    }


    @Override
    public Tenant addTenant(Tenant tenant) throws SQLException
    {
        tenantsModel.addTenant(tenant);
        return tenant;
    }


    @Override
    public BookingsManager getBookingsManager() {
        return bookings;
    }

    @Override
    public SummerHousesManager getSummerHousesManager() throws RemoteException {
        return summerhouses;
    }

    @Override
    public ArrayList<Tenant> getTenants() throws RemoteException {
        return null;
    }

    @Override
    public RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR) throws RemoteException {
        RegionalAdmin regionalAdmin = null;
        try {
            regionalAdmin = municipalitiesModel.getRegionalAdmin(regionalAdminCPR);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regionalAdmin;
    }

    @Override public void deleteMunicipality(String id)
    {
        try
        {
            municipalitiesModel.deleteMunicipality(id);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Override public List<Tenant> getAllTenants()
    {
        List<Tenant> tenants = null;
        try
        {
            tenants = tenantsModel.getAllTenants();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return tenants;
    }

    @Override
    public List<Municipality> getAllMunicipalities() {
        List<Municipality> municipalities = null;
        try {
            municipalities = municipalitiesModel.getAllMunicipalities();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return municipalities;
    }
}
