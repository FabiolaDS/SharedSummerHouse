package client.model.municipalities;

import client.core.ClientFactory;
import client.network.Client;
import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.transferobjects.EventType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * Class implementing ManageMunicipalities.
 *
 * @author Agostina Mezzabotta
 * @version 1.0
 */

public class ManageMunicipalitiesImpl implements ManageMunicipalities
{
  private PropertyChangeSupport support;
  private Client client;
  /**
   * 1-argument constructore setting the client, and PropertyChangeSupport.
   * adding subscribers to events happening in the client
   *
   * @param client the client using the system
   */
  public ManageMunicipalitiesImpl(Client client)
  {

    this.client = client;
    this.client.addPropertyChangeListener(EventType.MUNICIPALITY.toString(),
        this::getNewMunicipalities);
    this.client.addPropertyChangeListener(EventType.REGIONALADMIN.toString(),
        this::updateRegionalAdmin);
    support = new PropertyChangeSupport(this);
  }

  @Override public void updateRegionalAdmin(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  @Override public void addMunicipality(Municipality municipality)
  {
    client.addMunicipality(municipality);
  }

  @Override public void getNewMunicipalities(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public Municipality getMunicipality(String id)
  {
    return client.getMunicipality(id);
  }

  @Override public List<Municipality> setMunicipalityList()
  {
    return client.getAllMunicipalities();
  }

  @Override public RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR)
  {
    return client.getRegionalAdminByCPR(regionalAdminCPR);
  }

  @Override public void deleteRegionalAdmin(RegionalAdmin regionalAdmin)
  {
    client.deleteRegionalAdmin(regionalAdmin);
  }

  @Override public void deleteMunicipality(String id)
  {
    client.deleteMunicipality(id);
  }

  @Override public void addRegionalAdmin(RegionalAdmin regionalAdmin,
      String municipalityId)
  {
    client.addRegionalAdmin(regionalAdmin, municipalityId);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

}
