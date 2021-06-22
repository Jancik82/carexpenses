package pl.edu.wszib.ce.carexpenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.dao.ServiceEntriesDao;

@Transactional
@Service
public class ServiceEntriesServiceImpl implements ServiceEntriesService {

    @Autowired
    ServiceEntriesDao serviceEntriesDao;

    @Override
    public Float sumCostService() {
        return serviceEntriesDao.sumCostService() ;
    }

    @Override
    public Float minCostService() {
        return serviceEntriesDao.minCostService();
    }

    @Override
    public String minDescriptionService() {
        return serviceEntriesDao.minDescriptionService();
    }

    @Override
    public Float maxCostService() {
        return serviceEntriesDao.maxCostService();
    }

    @Override
    public String maxDescriptionService() {
        return serviceEntriesDao.maxDescriptionService();
    }

    @Override
    public Float avgCostService() {
        return serviceEntriesDao.avgCostService();
    }
}
