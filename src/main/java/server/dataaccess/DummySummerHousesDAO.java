package server.dataaccess;

import shared.domain.SummerHouse;

import java.util.ArrayList;

public class DummySummerHousesDAO implements SummerHousesDAO
{
    @Override
    public void save(SummerHouse house)
    {

    }

    @Override
    public SummerHouse get(Long id)
    {
        return null;
    }

    @Override
    public ArrayList<SummerHouse> getAllSummerHouses()
    {
        return null;
    }

    @Override
    public void update(Long id, SummerHouse house)
    {

    }
}
