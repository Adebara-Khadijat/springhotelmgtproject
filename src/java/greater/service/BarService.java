package greater.service;

import greater.pojo.Bars;
import greater.pojo.GuestMasterBills;
import greater.pojo.ServiceCharges;
import java.util.List;

public interface BarService {
    public void createdBar(Bars b);
    public void updateBar(Bars b);
    public void deleteBar(Bars b);
    public void createdGuestMasterBill(GuestMasterBills gmb);
    public List<Bars> listBarByID(String barId);        
    public List<Bars> listBar();         
    public int checkBarID(String barId);
    public int checkBarEmail(String email);
    public List<Bars> listBarByEmail(String email);
    public List<Bars> listBarByEmail(String email, String startDate, String endDate);
    public List<Bars> listBarBySumTotal(String email);
    public List<ServiceCharges> listServiceCharge(String email, String productDec);
    public List<ServiceCharges> listSerChGrandTotal(String email, String productDec);
    public List<Bars> listBarByWalkInGuest(String WINGuest);
    public List<Bars> listBarByWalkInGuest(String WINGuest, String startDate, String endDate);
    public int checkBarWalkInGuest(String WINGuest);
    public List<Bars> listBarByWINGSumTotal(String WINGuest);
    public List<ServiceCharges> listSerChGrandTotalWinguest(String WINGuest, String productDec);
    public List<ServiceCharges> listServiceChargeWinguest(String WINGuest, String productDec);
    public List<Bars> listBarSumTotalDateBetween(String startDate, String endDate);
    public List<Bars> listBarSumVat5DateBetween(String startDate, String endDate);
    public List<Bars> listBarSumConTax5DateBetween(String startDate, String endDate);
    
}
