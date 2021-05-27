package server.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.dataaccess.DummySummerHousesDAO;
import shared.businesslogic.SummerHousesManager;
import shared.domain.SummerHouse;
import shared.network.RemoteChangeListener;
import util.Counter;

import java.rmi.RemoteException;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SummerHousesManagerTest
{
    private SummerHousesManager shman;

    private DummySummerHousesDAO dao;

    private final Random rand = new Random();

    @BeforeEach
    void setUp() throws RemoteException
    {
        dao = new DummySummerHousesDAO();
        shman = new SummerHousesManagerImpl(dao);
    }

    @Test
    void registerTest() throws RemoteException
    {
        SummerHouse newSh = randomSummerHouse();

        Counter c = new Counter();      // count NEW_HOUSE events
        shman.addListener(e -> {
            if(e.getPropertyName().equals("NEW_HOUSE")) {
                c.inc();
            }
        });

        assertNull(newSh.getId());

        shman.register(newSh);

        assertNotNull(newSh.getId());   // ID should be assigned
        assertEquals(newSh, dao.get(newSh.getId()));

        assertTrue(0 < c.getCount());
    }

    @Test
    void getAllSummerHousesTest() throws RemoteException
    {
        int samples = 10;
        for(int i = 0; i < samples; i++) {
            dao.save(randomSummerHouse());
        }

        for(SummerHouse sh: dao.getAllSummerHouses()) {
            assertTrue(shman.getAllSummerHouses().contains(sh));
        }
    }

    @Test
    void updateSummerHouseTest() throws RemoteException
    {
        SummerHouse sh = randomSummerHouse();
        shman.register(sh);

        Counter c = new Counter();      // count HOUSE_UPDATED events
        shman.addListener(e -> {
            if(e.getPropertyName().equals("HOUSE_UPDATED")) {
                c.inc();
            }
        });

        SummerHouse updated = randomSummerHouse();

        assertNotEquals(sh, updated);

        updated.setId(sh.getId());
        shman.updateSummerHouse(updated);
        sh = dao.get(sh.getId());

        assertEquals(sh, updated);

        assertTrue(0 < c.getCount());
    }

    @Test
    void addListenerTest() throws RemoteException
    {
        Counter c = new Counter();

        shman.addListener(e -> c.inc());

        int samples = 10;
        for(int i = 0; i < samples; i++) {
            shman.register(randomSummerHouse());
        }

        assertEquals(samples, c.getCount());
    }

    @Test
    void removeListenerTest() throws RemoteException
    {
        Counter c = new Counter();

        RemoteChangeListener l = e -> c.inc();
        shman.addListener(l);

        shman.removeListener(l);

        int samples = 10;
        for(int i = 0; i < samples; i++) {
            shman.register(randomSummerHouse());
        }

        assertEquals(0, c.getCount());
    }


    private SummerHouse randomSummerHouse() {
        SummerHouse res = new SummerHouse();

        res.setStreet(UUID.randomUUID().toString());
        res.setHouseNumber(rand.nextInt(100));
        res.setPostCode(rand.nextInt(100));
        res.setRegion(UUID.randomUUID().toString());

        res.setTitle(UUID.randomUUID().toString());
        res.setDescription(UUID.randomUUID().toString());
        res.setPricePerNight(rand.nextDouble() * 100);
        res.setCapacity(rand.nextInt(20));

        return res;
    }
}