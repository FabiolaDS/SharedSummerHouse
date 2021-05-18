package server.model.municipalities;

import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ServerManageMunicipalitiesImp implements ServerManageMunicipalities {

    private static ServerManageMunicipalitiesImp serverManageMunicipalities;
    private MunicipalityList municipalityList;
    PropertyChangeSupport support;

    private ServerManageMunicipalitiesImp() {

        support = new PropertyChangeSupport(this);
    }

    public static ServerManageMunicipalitiesImp getInstance() {

        if (serverManageMunicipalities == null) {
            serverManageMunicipalities = new ServerManageMunicipalitiesImp();
        }
        return serverManageMunicipalities;
    }

    @Override
    public MunicipalityList addMunicipality(Municipality municipality) {

      municipalityList.add(municipality);
      return municipalityList;
    }

    @Override public void addPropertyChangeListener(String name,
                                                    PropertyChangeListener listener)
    {
        if (name == null) {
            addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(name, listener);
        }
    }

    @Override public void addPropertyChangeListener(
            PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override public void removePropertyChangeListener(String name,
                                                       PropertyChangeListener listener)
    {
        if (name == null)
        {
            removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(listener);
        }
    }

    @Override public void removePropertyChangeListener(
            PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }
}
