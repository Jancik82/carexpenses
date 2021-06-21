package pl.edu.wszib.ce.carexpenses.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.model.FuelEntries;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FuelEntriesDaoTest {

    public static final float FUELED_FUEL1 = 43F;
    public static final float COST1 = 246.00F;
    public static final float DIST1 = 1200.00F;

    public static final float FUELED_FUEL2 = 35F;
    public static final float COST2 = 199.50F;
    public static final float DIST2 = 920.00F;

    public static final int TOTAL_FUELS = 2;

    @Autowired
    FuelEntriesDao fuelEntriesDao;

    @BeforeEach
    void setUp() {
        FuelEntries fuelEntries1 = new FuelEntries(new Date(), FUELED_FUEL1, COST1, DIST1);
        FuelEntries fuelEntries2 = new FuelEntries(new Date(), FUELED_FUEL2, COST2, DIST2);

        assertNull(fuelEntries1.getId());
        assertNull(fuelEntries2.getId());

        fuelEntriesDao.save(fuelEntries1);
        fuelEntriesDao.save(fuelEntries2);

        assertNotNull(fuelEntries1.getId());
        assertNotNull(fuelEntries2.getId());
    }

    @Test
    void testFetchAllData() {
        Collection fuelEntries = (Collection) fuelEntriesDao.findAll();
        assertEquals(TOTAL_FUELS, fuelEntries.size(), "Nieprawidłowa liczba wpisów");
        System.out.println("Znaleziona ilość obiektów: " + fuelEntries.size());
    }
}
