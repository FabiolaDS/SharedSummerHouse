package client.model.municipalities;

import client.core.ClientFactory;
import client.network.Client;
import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.List;

public class ManageMunicipalitiesImpl implements ManageMunicipalities {
    private PropertyChangeSupport support;
    private MunicipalityList municipalityList;
    private Client client;

    public ManageMunicipalitiesImpl() {
        support = new PropertyChangeSupport(this);
        municipalityList = new MunicipalityList();
        client = ClientFactory.getClientFactory().getClient();
        client.addPropertyChangeListener(EventType.MUNICIPALITY.toString(),
                this::getMunicipalities);
        client.addPropertyChangeListener(EventType.REGIONALADMIN.toString(), this::updateRegionalAdmin);
    }

    private void updateRegionalAdmin(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }

    @Override
    public void addMunicipality(Municipality municipality) {
        /*    try {*/
        client.addMunicipality(municipality);
   /* } catch (RemoteException e) {
      e.printStackTrace();
    }*/
    }

    @Override
    public void getMunicipalities(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    @Override
    public Municipality getMunicipality(String id) {

        /* try {*/
        return client.getMunicipality(id);
   /* } catch (RemoteException e) {
      e.printStackTrace();
    }*/

    }

  @Override
  public List<Municipality> getMunicipalitiesStart() {
    return client.getAllMunicipalities();
  }

  @Override
    public void addRegionalAdmin(RegionalAdmin regionalAdmin,
                                 String municipalityId) {
        /*    try {*/
        client.addRegionalAdmin(regionalAdmin, municipalityId);
        /*} *//*catch (RemoteException e) {
      e.printStackTrace();
    }*/
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
