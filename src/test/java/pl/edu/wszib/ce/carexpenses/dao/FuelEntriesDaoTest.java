package pl.edu.wszib.ce.carexpenses.dao;

import com.sun.istack.NotNull;
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
    public static final float VALUE1 = 246.00F;
    public static final float FUELED_FUEL2 = 35F;
    public static final float VALUE2 = 199.50F;

    public static final int TOTAL_FUELS = 2;

    @Autowired
    FuelEntriesDao fuelEntriesDao;

    @BeforeEach
    void setUp() {
        FuelEntries fuelEntries1 = new FuelEntries(new Date(), FUELED_FUEL1, VALUE1);
        FuelEntries fuelEntries2 = new FuelEntries(new Date(), FUELED_FUEL2, VALUE2);

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
