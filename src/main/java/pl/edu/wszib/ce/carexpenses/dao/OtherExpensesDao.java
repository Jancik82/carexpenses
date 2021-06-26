package pl.edu.wszib.ce.carexpenses.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ce.carexpenses.model.OtherExpenses;

@Repository
public interface OtherExpensesDao extends CrudRepository<OtherExpenses, Long> {

    @Query(value = "SELECT SUM(cost) FROM OtherExpenses ")
    public Float sumCostOther();

    @Query(value = "SELECT MIN(cost) FROM OtherExpenses ")
    public Float minCostOther();

    @Query(value = "SELECT(description) FROM OtherExpenses WHERE cost = (SELECT MIN(cost) FROM OtherExpenses )")
    public String minDescriptionOther();

    @Query(value = "SELECT MAX(cost) FROM OtherExpenses ")
    public Float maxCostOther();

    @Query(value = "SELECT(description) FROM OtherExpenses WHERE cost = (SELECT MAX(cost) FROM OtherExpenses )")
    public String maxDescriptionOther();

    @Query(value = "SELECT AVG(cost) FROM OtherExpenses ")
    public Float avgCostOther();
}
