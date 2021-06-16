package pl.edu.wszib.ce.carexpenses.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ce.carexpenses.model.OtherExpenses;

@Repository
public interface OtherExpensesDao extends CrudRepository <OtherExpenses, Long> {
}
