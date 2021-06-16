package pl.edu.wszib.ce.carexpenses.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.model.OtherExpenses;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OtherExpensesDaoTest {

    public static final String DESCRIPTION1 = "Myjnia";
    public static final float COST1 = 25.00F;

    public static final String DESCRIPTION2 = "Zakup kompletu żarówek";
    public static final float COST2 = 210.00F;

    public static final int TOTAL_OTHER = 2;

    @Autowired
    OtherExpensesDao otherExpensesDao;

    @BeforeEach
    void setUp() {
        OtherExpenses otherExpenses1 = new OtherExpenses(new Date(), DESCRIPTION1, COST1);
        OtherExpenses otherExpenses2 = new OtherExpenses(new Date(), DESCRIPTION2, COST2);

        assertNull(otherExpenses1.getId());
        assertNull(otherExpenses2.getId());

        otherExpensesDao.save(otherExpenses1);
        otherExpensesDao.save(otherExpenses2);

        assertNotNull(otherExpenses1.getId());
        assertNotNull(otherExpenses2.getId());
    }

    @Test
    void testFetchAllData() {
        Collection otherExpenses = (Collection) otherExpensesDao.findAll();
        assertEquals(TOTAL_OTHER, otherExpenses.size(), "Nieprawidłowa liczba wpisów");
        System.out.println("Znaleziona ilość obiektów: " + otherExpenses.size());
    }
}
