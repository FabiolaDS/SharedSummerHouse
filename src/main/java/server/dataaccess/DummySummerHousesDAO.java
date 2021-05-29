package server.dataaccess;

import shared.domain.SummerHouse;

import java.util.ArrayList;
import java.util.List;

public class DummySummerHousesDAO implements SummerHousesDAO
{
    private List<SummerHouse> storage;
    private long idCnt;

    public DummySummerHousesDAO() {
        storage = new ArrayList<>();
        idCnt = 1;  // start id's from 1
    }

    @Override
    public void save(SummerHouse house)
    {
        storage.add(house);
        house.setId(idCnt++);
    }

    @Override
    public SummerHouse get(Long id)
    {
        for(SummerHouse sh: storage) {
            if(sh.getId().equals(id)) {
                return sh;
            }
        }

        throw new IllegalArgumentException("No such summerhouse");
    }

    @Override
    public List<SummerHouse> getAllSummerHouses()
    {
        return storage;
    }

    @Override
    public void update(Long id, SummerHouse c)
    {
        SummerHouse sh = get(id);

        sh.setStreet(c.getStreet());
        sh.setHouseNumber(c.getHouseNumber());
        sh.setPostCode(c.getPostCode());
        sh.setRegion(c.getRegion());

        sh.setTitle(c.getTitle());
        sh.setDescription(c.getDescription());
        sh.setPricePerNight(c.getPricePerNight());
        sh.setCapacity(c.getCapacity());
    }
}
