package greater.service;

import greater.dao.BarPriceListDao;
import greater.pojo.BarPriceLists;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("barPriceListService")
@Transactional(readOnly = true)
public class BarPriceListServiceImp implements BarPriceListService {
    @Autowired
    BarPriceListDao barPriceListDao; 

    public BarPriceListDao getBarPriceListDao() {
        return barPriceListDao;
    }

    public void setBarPriceListDao(BarPriceListDao barPriceListDao) {
        this.barPriceListDao = barPriceListDao;
    }
    
    @Override
    public void createdBarPriceList(BarPriceLists barPrice) {
        barPriceListDao.createdBarPriceList(barPrice);
    }

    @Override
    public void updateBarPriceList(BarPriceLists barPrice) {
        barPriceListDao.updateBarPriceList(barPrice);
    }

    @Override
    public void deleteBarPriceList(BarPriceLists barPrice) {
        barPriceListDao.deleteBarPriceList(barPrice);
    }

    @Override
    public List<BarPriceLists> listBarPriceListByID(int barPriceId) {
        return barPriceListDao.listBarPriceListByID(barPriceId);
    }

    @Override
    public List<BarPriceLists> listBarPriceList() {
        return barPriceListDao.listBarPriceList();
    }

    @Override
    public int checkBarPriceListID(int barPriceId) {
        return barPriceListDao.checkBarPriceListID(barPriceId);
    }

    @Override
    public List<BarPriceLists> wine() {
        return barPriceListDao.wine();
    }

    @Override
    public List<BarPriceLists> allWine() {
        return barPriceListDao.allWine();
    }

    @Override
    public List<BarPriceLists> beer() {
        return barPriceListDao.beer();
    }

    @Override
    public List<BarPriceLists> allBeer() {
        return barPriceListDao.allBeer();
    }

    @Override
    public List<BarPriceLists> spirit() {
        return barPriceListDao.spirit();
    }

    @Override
    public List<BarPriceLists> allSpirit() {
        return barPriceListDao.allSpirit();
    }

    @Override
    public List<BarPriceLists> softDrink() {
        return barPriceListDao.softDrink();
    }

    @Override
    public List<BarPriceLists> allSoftDrink() {
        return barPriceListDao.allSoftDrink();
    }

    @Override
    public List<BarPriceLists> herbalAlcohol() {
        return barPriceListDao.herbalAlcohol();
    }

    @Override
    public List<BarPriceLists> allHerbalAlcohol() {
        return barPriceListDao.allHerbalAlcohol();
    }

    @Override
    public List<BarPriceLists> juice() {
        return barPriceListDao.juice();
    }

    @Override
    public List<BarPriceLists> allJuice() {
        return barPriceListDao.allJuice();
    }
    
}
