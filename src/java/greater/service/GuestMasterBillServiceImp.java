package greater.service;

import greater.dao.GuestMasterBillDao;
import greater.pojo.GuestMasterBills;
import greater.pojo.ServiceCharges;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("guestMasterBillService")
@Transactional(readOnly = true)
public class GuestMasterBillServiceImp implements GuestMasterBillService {
    
    @Autowired
    GuestMasterBillDao guestMasterBillDao;

    public GuestMasterBillDao getGuestMasterBillDao() {
        return guestMasterBillDao;
    }

    public void setGuestMasterBillDao(GuestMasterBillDao guestMasterBillDao) {
        this.guestMasterBillDao = guestMasterBillDao;
    }
    
    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        guestMasterBillDao.createdGuestMasterBill(gmb);
    }

    @Override
    public void updateGuestMasterBill(GuestMasterBills gmb) {
        guestMasterBillDao.updateGuestMasterBill(gmb);
    }

    @Override
    public void deleteGuestMasterBill(GuestMasterBills gmb) {
        guestMasterBillDao.deleteGuestMasterBill(gmb);
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillByID(String gmbId) {
        return guestMasterBillDao.listGuestMasterBillByID(gmbId);
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBill() {
        return guestMasterBillDao.listGuestMasterBill();
    }

    @Override
    public int checkGuestMasterBillByID(String gmbId) {
        return guestMasterBillDao.checkGuestMasterBillByID(gmbId);
    }

    @Override
    public int checkGuestMasterBillByEmail(String email) {
        return guestMasterBillDao.checkGuestMasterBillByEmail(email);
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillByEmail(String email, String startDate, String endDate) {
        return guestMasterBillDao.listGuestMasterBillByEmail(email, startDate, endDate);
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillSumCharge(String email, String startDate, String endDate) {
        return guestMasterBillDao.listGuestMasterBillSumCharge(email, startDate, endDate);
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillSumCredit(String email, String startDate, String endDate) {
        return guestMasterBillDao.listGuestMasterBillSumCredit(email, startDate, endDate);
    }

    @Override
    public List<ServiceCharges> listServiceCharge(String email, String productDec, String startDate, String endDate) {
        return guestMasterBillDao.listServiceCharge(email, productDec, startDate, endDate);
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotal(String email, String productDec, String startDate, String endDate) {
        return guestMasterBillDao.listSerChGrandTotal(email, productDec, startDate, endDate);
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillSubtractChargeFromCredit(String email, String startDate, String endDate) {
        return guestMasterBillDao.listGuestMasterBillSubtractChargeFromCredit(email, startDate, endDate);
    }
    
}
