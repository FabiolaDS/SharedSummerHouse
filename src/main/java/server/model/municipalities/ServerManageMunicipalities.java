package server.model.municipalities;

import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;
import java.util.List;

public interface ServerManageMunicipalities extends PropertyChangeSubject
{
  List<Municipality> addMunicipality(Municipality municipality) throws SQLException;
  Municipality setRegionalAdmin(RegionalAdmin regionalAdmin,
      String municipalityId);
  Municipality getMunicipality(String id);
  List<Municipality> getAllMunicipalities() throws SQLException;
}
