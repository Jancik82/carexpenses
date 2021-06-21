package pl.edu.wszib.ce.carexpenses.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ce.carexpenses.model.ServiceEntries;

@Repository
public interface ServiceEntriesDao extends CrudRepository<ServiceEntries, Long> {

/*    @Query(value = "SELECT SUM (cost) FROM ServiceEntries")
    public Float sumCostService();

    @Query(value = "SELECT MIN(cost) FROM ServiceEntries")
    public Float minCostService();

    @Query(value = "SELECT AVG(cost) FROM ServiceEntries")
    public Float avgCostService();*/

}
