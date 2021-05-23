package server.dataaccess;

import shared.domain.SummerHouse;

import java.util.ArrayList;

public interface SummerHousesDAO
{
    void save(SummerHouse house);

    SummerHouse get(Long id);
    ArrayList<SummerHouse> getAllSummerHouses();

    void update(Long id, SummerHouse house);
}