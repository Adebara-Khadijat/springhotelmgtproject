package greater.service;

import greater.pojo.GuestMasterBills;
import greater.pojo.Restaurants;
import greater.pojo.ServiceCharges;
import java.util.List;

public interface RestaurantService {
    public void createdRestaurant(Restaurants res);
    public void updateRestaurant(Restaurants res);
    public void deleteRestaurant(Restaurants res);
    public void createdGuestMasterBill(GuestMasterBills gmb);
    public List<Restaurants> listRestaurantByID(String restId);        
    public List<Restaurants> listRestaurant();         
    public int checkRestaurantID(String restId);
    public int checkRestaurantEmail(String email);    
    public List<Restaurants> listRestaurantByEmail(String email);
    public List<Restaurants> listRestaurantByEmail(String email, String startDate, String endDate);
    public List<Restaurants> listRestaurantBySumTotal(String email);
    public List<ServiceCharges> listServiceCharge(String email);
    public List<ServiceCharges> listSerChGrandTotal(String email);
    public List<Restaurants> listRestaurantByWalkInGuest(String WINGuest);
    public List<Restaurants> listRestaurantByWalkInGuest(String WINGuest,String startDate, String endDate);
    public int checkRestaurantWalkInGuest(String WINGuest);
    public List<Restaurants> listRestaurantByWINGSumTotal(String WINGuest);
    public List<ServiceCharges> listSerChGrandTotalWinguest(String WINGuest);
    public List<ServiceCharges> listServiceChargeWinguest(String WINGuest);
    public List<Restaurants> listRestSumTotalDateBetween(String startDate, String endDate);
    public List<Restaurants> listRestSumVat5DateBetween(String startDate, String endDate);
    public List<Restaurants> listRestSumConTax5DateBetween(String startDate, String endDate);
    
}
