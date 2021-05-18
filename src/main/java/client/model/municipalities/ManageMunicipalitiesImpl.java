package client.model.municipalities;

import shared.domain.Municipality;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ManageMunicipalitiesImpl implements ManageMunicipalities
{
  private PropertyChangeSupport support;
  private Municipality municipality;

  @Override public void addRegionalAdmin(RegionalAdmin regionalAdmin,
      Municipality municipality)
  {

  }

  public  ManageMunicipalitiesImpl()
  {

    support = new PropertyChangeSupport(this);

  }
  public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void addMunicipality(Municipality municipality)
  {

  }


  @Override public ArrayList<Municipality> getMunicipalities()
  {
    return null;
  }

  @Override public Municipality getMunicipality(Long id)
  {
    return null;
  }
}
