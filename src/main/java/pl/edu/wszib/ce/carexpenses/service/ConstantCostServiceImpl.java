package pl.edu.wszib.ce.carexpenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.ce.carexpenses.dao.ConstantCostsDao;

@Transactional
@Service
public class ConstantCostServiceImpl implements ConstantCostService {

    @Autowired
    ConstantCostsDao constantCostsDao;

    @Override
    public Float sumCostConst() {
        return constantCostsDao.sumCostConst();
    }

    @Override
    public Float sumInstallment() {
        return constantCostsDao.sumInstallment();
    }

    @Override
    public Float sumRent() {
        return constantCostsDao.sumRent();
    }

    @Override
    public Float sumTechExem() {
        return constantCostsDao.sumTechExem();
    }

    @Override
    public Float sumInsuranceOC() {
        return constantCostsDao.sumInsuranceOC();
    }

    @Override
    public Float sumInsuranceOther() {
        return constantCostsDao.sumInsuranceOther();
    }

    @Override
    public Float sumPark() {
        return constantCostsDao.sumPark();
    }

    @Override
    public Float sumOther() {
        return constantCostsDao.sumOther();
    }
}
