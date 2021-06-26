package pl.edu.wszib.ce.carexpenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.dao.FuelEntriesDao;

@Transactional
@Service
public class FuelEntriesServiceImpl implements FuelEntriesService {

    @Autowired
    private FuelEntriesDao fuelEntriesDao;


    @Override
    public Float sumCostFuel() {
        return fuelEntriesDao.sumCostFuel();
    }

    @Override
    public Float sumDistFuel() {
        return fuelEntriesDao.sumDistFuel();
    }

    @Override
    public Float minCostFuel() {
        return fuelEntriesDao.minCostFuel();
    }

    @Override
    public Float maxCostFuel() {
        return fuelEntriesDao.maxCostFuel();
    }

    @Override
    public Float avgCostFuel() {
        return fuelEntriesDao.avgCostFuel();
    }

    @Override
    public Float minDistFuel() {
        return fuelEntriesDao.minDistFuel();
    }

    @Override
    public Float maxDistFuel() {
        return fuelEntriesDao.maxDistFuel();
    }

    @Override
    public Float avgDistFuel() {
        return fuelEntriesDao.avgDistFuel();
    }

    @Override
    public Float avgFuelDist() {
        return fuelEntriesDao.avgFuelDist();
    }

    @Override
    public Float avgFuelConsupt() {
        return fuelEntriesDao.avgFuelConsupt();
    }
}
