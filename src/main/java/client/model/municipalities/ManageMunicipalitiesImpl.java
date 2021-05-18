package client.model.municipalities;

import client.core.ClientFactory;
import client.network.Client;
import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;
import shared.transferobjects.EventType;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ManageMunicipalitiesImpl implements ManageMunicipalities, PropertyChangeSubject {
    private PropertyChangeSupport support;
    private MunicipalityList municipalityList;
    private Client client;


    public ManageMunicipalitiesImpl() {
        support = new PropertyChangeSupport(this);
        municipalityList = new MunicipalityList();
        client = ClientFactory.getClientFactory().getClient();
        client.addPropertyChangeListener(EventType.MUNICIPALITY.toString(), this::getMunicipalities);
    }

    @Override
    public void addMunicipality(Municipality municipality) {
        client.addMunicipality(municipality);
    }


    @Override
    public void getMunicipalities(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    @Override
    public Municipality getMunicipality(Long id) {
        return null;
    }

    @Override
    public void addRegionalAdmin(RegionalAdmin regionalAdmin,
                                 Municipality municipality) {

    }

    @Override
    public void addPropertyChangeListener(String name,
                                          PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(
            PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name,
                                             PropertyChangeListener listener) {
        support.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(
            PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


}
