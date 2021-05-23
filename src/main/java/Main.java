
import javafx.application.Application;
import server.dataaccess.MunicipalityDAOImpl;
import server.dataaccess.RegionalAdminDAOImpl;
import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException {

        Municipality municipality = MunicipalityDAOImpl.getInstance().getById("101");
       // RegionalAdmin regionalAdmin1 = RegionalAdminDAOImpl.getInstance().create("0109881-8116","Agostina","","Mezzabotta", "ahshshs",
       //         municipality.getId() );
        System.out.println("-----------> 1 municipality name: " + municipality.getName());
        System.out.println("-----------> 2 " + municipality.getRegionalAdminCPR());
    }
}
