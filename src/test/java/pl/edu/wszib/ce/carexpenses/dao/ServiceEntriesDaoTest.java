package pl.edu.wszib.ce.carexpenses.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.model.ServiceEntries;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ServiceEntriesDaoTest {

    public static final String DESCRIPTION1 = "Wymiana opon";
    public static final float COST1 = 90.00F;

    public static final String DESCRIPTION2 = "Naprawa układu hamulcowego";
    public static final float COST2 = 1300.00F;

    public static final int TOTAL_SERVICE = 2;

    @Autowired
    ServiceEntriesDao serviceEntriesDao;

    @BeforeEach
    void setUp() {
        ServiceEntries serviceEntries1 = new ServiceEntries(new Date(), DESCRIPTION1, COST1);
        ServiceEntries serviceEntries2 = new ServiceEntries(new Date(), DESCRIPTION2, COST2);


        assertNull(serviceEntries1.getId());
        assertNull(serviceEntries2.getId());

        serviceEntriesDao.save(serviceEntries1);
        serviceEntriesDao.save(serviceEntries2);

        assertNotNull(serviceEntries1.getId());
        assertNotNull(serviceEntries2.getId());
    }

    @Test
    void testFetchAllData() {
        Collection fuelEntries = (Collection) serviceEntriesDao.findAll();
        assertEquals(TOTAL_SERVICE, fuelEntries.size(), "Nieprawidłowa liczba wpisów");
        System.out.println("Znaleziona ilość obiektów: " + fuelEntries.size());
    }
}
