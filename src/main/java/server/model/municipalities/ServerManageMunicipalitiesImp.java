package server.model.municipalities;

import server.dataaccess.MunicipalityDAOImpl;
import server.dataaccess.RegionalAdminDAOImpl;
import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.List;

public class ServerManageMunicipalitiesImp implements ServerManageMunicipalities {

    private static ServerManageMunicipalitiesImp serverManageMunicipalities;
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

    /*
    DUMMY DATA TO SIMULATE DATABASE
     */
    MunicipalityList municipalityList = new MunicipalityList();

    @Override
    public List<Municipality> addMunicipality(Municipality municipality) throws SQLException {
        //TODO: CONNECT TO DATABASE
        try {
            MunicipalityDAOImpl.getInstance().create(municipality.getId(), municipality.getName(), municipality.getRegion());
        } catch (SQLException throwable) {
            System.out.println("Not possible to insert Municipality into DATABASE");
            throwable.printStackTrace();
        }
        return getAllMunicipalities();
    }

    @Override
    public List<Municipality> setRegionalAdmin(RegionalAdmin regionalAdmin, String municipalityId) {
        System.out.println("-----------------> Server model ");
        List<Municipality> municipalities = null;
        try {
            //FIRST: Create Regional Administrator
           RegionalAdmin regionalAdmin1 = RegionalAdminDAOImpl.getInstance().create(regionalAdmin.getCpr(), regionalAdmin.getFirstname(),
                    regionalAdmin.getMName(), regionalAdmin.getLastname(), regionalAdmin.getPassword(),
                    municipalityId);
            System.out.println(regionalAdmin);


            //SECOND: update municipality
            Municipality municipality = MunicipalityDAOImpl.getInstance().getById(municipalityId);
            municipality.setRegionalAdmin(regionalAdmin1);
            System.out.println(municipality.getRegionalAdminCPR());
            MunicipalityDAOImpl.getInstance().update(municipality);

            //THIRD: update list of municipalities with the changes
            municipalities = MunicipalityDAOImpl.getInstance().getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return municipalities;
    }

    @Override
    public Municipality getMunicipality(String id) {

        Municipality municipality = null;
        try {
            municipality = MunicipalityDAOImpl.getInstance().getById(id);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return municipality;
    }

    @Override
    public List<Municipality> getAllMunicipalities() throws SQLException {

        return MunicipalityDAOImpl.getInstance().getAll();
    }

    @Override
    public void addPropertyChangeListener(String name,
                                          PropertyChangeListener listener) {
        if (name == null) {
            addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(name, listener);
        }
    }

    @Override
    public void addPropertyChangeListener(
            PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name,
                                             PropertyChangeListener listener) {
        if (name == null) {
            removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(listener);
        }
    }

    @Override
    public void removePropertyChangeListener(
            PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
