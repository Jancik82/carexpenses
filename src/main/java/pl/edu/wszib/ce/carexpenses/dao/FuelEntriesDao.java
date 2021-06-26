package pl.edu.wszib.ce.carexpenses.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ce.carexpenses.model.FuelEntries;

@Repository
public interface FuelEntriesDao extends CrudRepository<FuelEntries, Long> {

    @Query(value = "SELECT SUM(cost) FROM FuelEntries")
    public Float sumCostFuel();

    @Query(value = "SELECT SUM(distance) FROM FuelEntries")
    public Float sumDistFuel();

    @Query(value = "SELECT MIN(cost) FROM FuelEntries")
    public Float minCostFuel();

    @Query(value = "SELECT MAX(cost) FROM FuelEntries")
    public Float maxCostFuel();

    @Query(value = "SELECT AVG(cost) FROM FuelEntries")
    public Float avgCostFuel();

    @Query(value = "SELECT MIN(distance) FROM FuelEntries")
    public Float minDistFuel();

    @Query(value = "SELECT MAX(distance) FROM FuelEntries")
    public Float maxDistFuel();

    @Query(value = "SELECT AVG(distance) FROM FuelEntries")
    public Float avgDistFuel();

    @Query(value = "SELECT ((SUM(fueledFuel) / SUM(distance))*100) FROM FuelEntries")
    public Float avgFuelDist();

    @Query(value = "SELECT ((SUM(cost) * 100) / SUM(distance)) FROM FuelEntries")
    public Float avgFuelConsupt();
}
