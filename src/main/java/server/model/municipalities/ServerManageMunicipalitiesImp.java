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
        municipalityList = new MunicipalityList();
    }

    public static ServerManageMunicipalitiesImp getInstance() {

        if (serverManageMunicipalities == null) {
            serverManageMunicipalities = new ServerManageMunicipalitiesImp();
        }
        return serverManageMunicipalities;
    }

    @Override
    public Municipality addMunicipality(Municipality municipality) {
//TODO: CONNECT TO DATABASE
      Municipality municipality1 = municipality;
      return municipality1;
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
