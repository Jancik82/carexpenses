package pl.edu.wszib.ce.carexpenses.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ce.carexpenses.model.ConstantCosts;

@Repository
public interface ConstantCostsDao extends CrudRepository<ConstantCosts, Long> {

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts")
    public Float sumCostConst();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Rata kredytu/leasingu'")
    public Float sumInstallment();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Wynajem długoterminowy'")
    public Float sumRent();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Okresowe badanie techniczne'")
    public Float sumTechExem();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Ubezpieczenie (OC)'")
    public Float sumInsuranceOC();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Ubezpieczenie (inne)'")
    public Float sumInsuranceOther();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Płatne miejsce parkowania'")
    public Float sumPark();

    @Query(value = "SELECT SUM(constantCost) FROM ConstantCosts WHERE description = 'Inne'")
    public Float sumOther();
}
