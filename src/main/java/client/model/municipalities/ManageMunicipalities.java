package client.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.util.List;

public interface ManageMunicipalities extends PropertyChangeSubject {
    public void addMunicipality(Municipality municipality);

    public void addRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId);

    //public ArrayList<Municipality> getMunicipalities();
    void getMunicipalities(PropertyChangeEvent event);

    public Municipality getMunicipality(String id);

    List<Municipality> getMunicipalitiesStart();

    RegionalAdmin getRegionalAdminByCPR(String regionalAdminCPR);
}
