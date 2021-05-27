package server.dataaccess;

import shared.domain.SummerHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for Data Access Object for the summerhouses
 *
 * @author Fabiola
 */
public interface SummerHousesDAO
{

    /**
     * Persists given summerhouse
     *
     * @param house     summerhouse to persist
     */
    void save(SummerHouse house);

    /**
     * Finds summerhouse by ID
     *
     * @param id    summerhouse's ID
     *
     * @return      summerhouse with given ID
     *
     * @throws IllegalArgumentException     if no summerhouse with given ID can be found
     */
    SummerHouse get(Long id);

    /**
     * Returns list of all persisted summerhouses
     *
     * @return      list of all persisted summerhouses
     */
    List<SummerHouse> getAllSummerHouses();

    /**
     * Updateds summerhouse data
     *
     * @param id        ID of the summerhouse to update
     * @param house     new data to persist
     *
     * @throws IllegalArgumentException     if no summerhouse with given ID can be found
     */
    void update(Long id, SummerHouse house);
}