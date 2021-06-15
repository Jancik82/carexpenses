package pl.edu.wszib.ce.carexpenses.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ce.carexpenses.model.ServiceEntries;

@Repository
public interface ServiceEntriesDao extends CrudRepository<ServiceEntries, Long> {

}
