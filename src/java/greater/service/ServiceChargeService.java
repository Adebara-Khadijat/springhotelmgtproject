package greater.service;

import greater.pojo.GuestMasterBills;
import greater.pojo.Restaurants;
import greater.pojo.ServiceCharges;
import java.util.List;

public interface ServiceChargeService {        
    public void createdServiceCharge(ServiceCharges s);
    public void createdGuestMasterBill(GuestMasterBills gmb);
    public void updateServiceCharge(ServiceCharges s);    
    public void deleteServiceCharge(ServiceCharges s);
    public List<ServiceCharges> listServiceChargeByEmail(String email);        
    public List<ServiceCharges> listServiceCharge();             
    public int checkServiceCharge(String email);
    public List<Restaurants> listRestaurantBySubTotal(String email);
    public List<ServiceCharges> listServiceChargeById(String serChargeId);
    public int checkServiceChargeId(String serChargeId);
        
}
