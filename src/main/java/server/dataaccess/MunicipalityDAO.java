package server.dataaccess;

import shared.domain.Municipality;

import java.sql.SQLException;
import java.util.List;

public interface MunicipalityDAO {

    Municipality create(String name, String region, String id) throws SQLException;
    Municipality getById(String id) throws SQLException;
    List<Municipality> getAll() throws SQLException;
    void update(Municipality municipality) throws SQLException;
    void delete(Municipality municipality) throws SQLException;

}
