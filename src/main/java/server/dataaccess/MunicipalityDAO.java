package server.dataaccess;

import shared.domain.Municipality;

import java.sql.SQLException;
import java.util.List;

/**
 * public interface for access to the database and create get and remove municipalities
 * @author Agostina Mezzabotta
 */
public interface MunicipalityDAO {
    /**
     * creates a municipality in the database
     * @param name of the municipality
     * @param region of the municipality
     * @param id to identify the municipality
     * @return the Municipality created
     * @throws SQLException from database
     */
    Municipality create(String name, String region, String id) throws SQLException;
    /**
     * gets a municipalityu existent in the system by id or a null object if the municipality does not exist
     * @param id to seach for the municipality
     * @return the Municipality object
     * @throws SQLException from the database
     */
    Municipality getById(String id) throws SQLException;
    /**
     * resturns a list of all the municipalities included in the system
     * @return a List object with municipalities
     * @throws SQLException from the database
     */
    List<Municipality> getAll() throws SQLException;
    /**
     * updates a municipality already existen in the system
     * @param municipality Municipality object to be updated
     * @throws SQLException from the database
     */
    void update(Municipality municipality) throws SQLException;
    /**
     * deletes a municipality object existent in the system
     * @param municipality Municipality object to be deleted
     * @throws SQLException from the database
     */
    void delete(Municipality municipality) throws SQLException;

}
