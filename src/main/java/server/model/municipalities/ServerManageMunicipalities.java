package server.model.municipalities;

import shared.domain.Municipality;
import shared.domain.MunicipalityList;
import shared.util.PropertyChangeSubject;

public interface ServerManageMunicipalities extends PropertyChangeSubject
{
    Municipality addMunicipality(Municipality municipality);
}
