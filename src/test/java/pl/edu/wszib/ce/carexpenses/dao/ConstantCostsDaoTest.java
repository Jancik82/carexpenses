package pl.edu.wszib.ce.carexpenses.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.model.ConstantCosts;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ConstantCostsDaoTest {

    public static final String DESCRIPTION1 = "Ubezpieczenie (inne)";
    public static final float COST1 = 690.00F;

    public static final String DESCRIPTION2 = "Okresowe badanie techniczne";
    public static final float COST2 = 99.00F;

    public static final int TOTAL_COST = 2;

    @Autowired
    ConstantCostsDao constantCostsDao;

    @BeforeEach
    void setUp() {
        ConstantCosts constantCosts1 = new ConstantCosts(new Date(), DESCRIPTION1, COST1);
        ConstantCosts constantCosts2 = new ConstantCosts(new Date(), DESCRIPTION2, COST2);


        assertNull(constantCosts1.getId());
        assertNull(constantCosts2.getId());

        constantCostsDao.save(constantCosts1);
        constantCostsDao.save(constantCosts2);

        assertNotNull(constantCosts1.getId());
        assertNotNull(constantCosts2.getId());
    }

    @Test
    void testFetchAllData() {
        Collection constantCosts = (Collection) constantCostsDao.findAll();
        assertEquals(TOTAL_COST, constantCosts.size(), "Nieprawidłowa liczba wpisów");
        System.out.println("Znaleziona ilość obiektów: " + constantCosts.size());
    }
}

