package server.model.municipalities;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;
import shared.util.PropertyChangeSubject;

import java.sql.SQLException;
import java.util.List;

public interface ServerManageMunicipalities extends PropertyChangeSubject
{
  List<Municipality> addMunicipality(Municipality municipality) throws SQLException;
  List<Municipality> setRegionalAdmin(RegionalAdmin regionalAdmin,
                                      String municipalityId) throws SQLException;
  Municipality getMunicipality(String id) throws SQLException;
  List<Municipality> getAllMunicipalities() throws SQLException;

  RegionalAdmin getRegioinalAdminCPR(String regionalAdminCPR) throws SQLException;
  void deleteRegionalAdmin(RegionalAdmin regionalAdmin) throws SQLException;
}
