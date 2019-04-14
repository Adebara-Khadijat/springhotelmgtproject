package greater.service;

import greater.dao.BarDao;
import greater.pojo.Bars;
import greater.pojo.GuestMasterBills;
import greater.pojo.ServiceCharges;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("barService")
@Transactional(readOnly = true)
public class BarServiceImp implements BarService{
    @Autowired
    BarDao barDao; 

    public BarDao getBarDao() {
        return barDao;
    }

    public void setBarDao(BarDao barDao) {
        this.barDao = barDao;
    }
    
    @Override
    public void createdBar(Bars b) {
        barDao.createdBar(b);
    }

    @Override
    public void updateBar(Bars b) {
        barDao.updateBar(b);
    }

    @Override
    public void deleteBar(Bars b) {
        barDao.deleteBar(b);
    }

    @Override
    public List<Bars> listBarByID(String barId) {
        return barDao.listBarByID(barId);
    }

    @Override
    public List<Bars> listBar() {
        return barDao.listBar();
    }

    @Override
    public int checkBarID(String barId) {
        return barDao.checkBarID(barId);
    }

    @Override
    public int checkBarEmail(String email) {
        return barDao.checkBarEmail(email);
    }

    @Override
    public List<Bars> listBarByEmail(String email) {
        return barDao.listBarByEmail(email);
    }

    @Override
    public List<Bars> listBarBySumTotal(String email) {
        return barDao.listBarBySumTotal(email);
    }

    @Override
    public List<ServiceCharges> listServiceCharge(String email, String productDec) {
        return barDao.listServiceCharge(email, productDec);
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotal(String email, String productDec) {
        return barDao.listSerChGrandTotal(email, productDec);
    }

    @Override
    public List<Bars> listBarByWalkInGuest(String WINGuest) {
        return barDao.listBarByWalkInGuest(WINGuest);
    }

    @Override
    public int checkBarWalkInGuest(String WINGuest) {
        return barDao.checkBarWalkInGuest(WINGuest);
    }

    @Override
    public List<Bars> listBarByWINGSumTotal(String WINGuest) {
        return barDao.listBarByWINGSumTotal(WINGuest);
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotalWinguest(String WINGuest, String productDec) {
        return barDao.listSerChGrandTotalWinguest(WINGuest, productDec);
    }

    @Override
    public List<ServiceCharges> listServiceChargeWinguest(String WINGuest, String productDec) {
        return barDao.listServiceChargeWinguest(WINGuest, productDec);
    }

    @Override
    public List<Bars> listBarSumTotalDateBetween(String startDate, String endDate) {
        return barDao.listBarSumTotalDateBetween(startDate, endDate);
    }

    @Override
    public List<Bars> listBarSumVat5DateBetween(String startDate, String endDate) {
        return barDao.listBarSumVat5DateBetween(startDate, endDate);
    }

    @Override
    public List<Bars> listBarSumConTax5DateBetween(String startDate, String endDate) {
        return barDao.listBarSumConTax5DateBetween(startDate, endDate);
    }

    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        barDao.createdGuestMasterBill(gmb);
    }

    @Override
    public List<Bars> listBarByEmail(String email, String startDate, String endDate) {
        return barDao.listBarByEmail(email, startDate, endDate);
    }

    @Override
    public List<Bars> listBarByWalkInGuest(String WINGuest, String startDate, String endDate) {
        return barDao.listBarByEmail(WINGuest, startDate, endDate);
    }
    
}
