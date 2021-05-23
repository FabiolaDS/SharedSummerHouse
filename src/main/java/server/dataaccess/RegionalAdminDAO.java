package server.dataaccess;

import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.sql.SQLException;
import java.util.List;

public interface RegionalAdminDAO {

    RegionalAdmin create(String regional_admin_cpr, String fname, String mname,
                         String lname, String password,
                         String municipality_id) throws SQLException;

    RegionalAdmin getById(String id) throws SQLException;

    List<RegionalAdmin> getAll() throws SQLException;

    void update(Municipality municipality) throws SQLException;

}

