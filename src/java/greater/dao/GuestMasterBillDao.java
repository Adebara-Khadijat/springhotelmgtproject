package greater.dao;

import greater.pojo.GuestMasterBills;
import greater.pojo.ServiceCharges;
import java.util.List;

public interface GuestMasterBillDao {
    public void createdGuestMasterBill(GuestMasterBills gmb);
    public void updateGuestMasterBill(GuestMasterBills gmb);
    public void deleteGuestMasterBill(GuestMasterBills gmb);
    public List<GuestMasterBills> listGuestMasterBillByID(String gmbId);        
    public List<GuestMasterBills> listGuestMasterBill();         
    public int checkGuestMasterBillByID(String gmbId);    
    public int checkGuestMasterBillByEmail(String email);    
    public List<GuestMasterBills> listGuestMasterBillByEmail(String email, String startDate, String endDate);    
    public List<GuestMasterBills> listGuestMasterBillSumCharge(String email, String startDate, String endDate);
    public List<GuestMasterBills> listGuestMasterBillSumCredit(String email, String startDate, String endDate);
    public List<ServiceCharges> listServiceCharge(String email, String productDec, String startDate, String endDate);
    public List<ServiceCharges> listSerChGrandTotal(String email, String productDec, String startDate, String endDate);
    public List<GuestMasterBills> listGuestMasterBillSubtractChargeFromCredit(String email, String startDate, String endDate);    
}
