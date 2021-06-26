package pl.edu.wszib.ce.carexpenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.dao.OtherExpensesDao;

@Transactional
@Service
public class OtherExpensesServiceImpl implements OtherExpensenService {

    @Autowired
    OtherExpensesDao otherExpensesDao;

    @Override
    public Float sumCostOther() {
        return otherExpensesDao.sumCostOther();
    }

    @Override
    public Float minCostOther() {
        return otherExpensesDao.minCostOther();
    }

    @Override
    public String minDescriptionOther() {
        return otherExpensesDao.minDescriptionOther();
    }

    @Override
    public Float maxCostOther() {
        return otherExpensesDao.maxCostOther();
    }

    @Override
    public String maxDescriptionOther() {
        return otherExpensesDao.maxDescriptionOther();
    }

    @Override
    public Float avgCostOther() {
        return otherExpensesDao.avgCostOther();
    }
}
