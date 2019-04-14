package greater.service;

import greater.dao.RestaurantDao;
import greater.pojo.GuestMasterBills;
import greater.pojo.Restaurants;
import greater.pojo.ServiceCharges;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("restaurantService")
@Transactional(readOnly = true)
public class RestaurantServiceImp implements RestaurantService{
    @Autowired
    RestaurantDao restaurantDao; 

    public RestaurantDao getRestaurantDao() {
        return restaurantDao;
    }

    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }
    
    @Override
    public void createdRestaurant(Restaurants res) {
        restaurantDao.createdRestaurant(res);
    }

    @Override
    public void updateRestaurant(Restaurants res) {
        restaurantDao.updateRestaurant(res);
    }

    @Override
    public void deleteRestaurant(Restaurants res) {
        restaurantDao.deleteRestaurant(res);
    }

    @Override
    public List<Restaurants> listRestaurantByID(String restId) {
        return restaurantDao.listRestaurantByID(restId);
    }

    @Override
    public List<Restaurants> listRestaurant() {
        return restaurantDao.listRestaurant();
    }

    @Override
    public int checkRestaurantID(String restId) {
        return restaurantDao.checkRestaurantID(restId);
    }

    @Override
    public List<Restaurants> listRestaurantByEmail(String email, String startDate, String endDate) {
        return restaurantDao.listRestaurantByEmail(email, startDate, endDate);
    }
    
    @Override
    public List<Restaurants> listRestaurantByEmail(String email) {
        return restaurantDao.listRestaurantByEmail(email);
    }

    @Override
    public List<Restaurants> listRestaurantBySumTotal(String email) {
        return restaurantDao.listRestaurantBySumTotal(email);
    }

    @Override
    public int checkRestaurantEmail(String email) {
        return restaurantDao.checkRestaurantEmail(email);
    }

    @Override
    public List<ServiceCharges> listServiceCharge(String email) {
        return restaurantDao.listServiceCharge(email);
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotal(String email) {
        return restaurantDao.listSerChGrandTotal(email);
    }

    @Override
    public List<Restaurants> listRestaurantByWalkInGuest(String WINGuest) {
        return restaurantDao.listRestaurantByWalkInGuest(WINGuest);
    }
    
    @Override
    public List<Restaurants> listRestaurantByWalkInGuest(String WINGuest, String startDate, String endDate) {
        return restaurantDao.listRestaurantByWalkInGuest(WINGuest, startDate,endDate);
    }

    @Override
    public int checkRestaurantWalkInGuest(String WINGuest) {
        return restaurantDao.checkRestaurantWalkInGuest(WINGuest);
    }

    @Override
    public List<Restaurants> listRestaurantByWINGSumTotal(String WINGuest) {
        return restaurantDao.listRestaurantByWINGSumTotal(WINGuest);
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotalWinguest(String WINGuest) {
        return restaurantDao.listSerChGrandTotalWinguest(WINGuest);
    }

    @Override
    public List<ServiceCharges> listServiceChargeWinguest(String WINGuest) {
        return restaurantDao.listServiceChargeWinguest(WINGuest);
    }

    @Override
    public List<Restaurants> listRestSumTotalDateBetween(String startDate, String endDate) {
        return restaurantDao.listRestSumTotalDateBetween(startDate, endDate);
    }

    @Override
    public List<Restaurants> listRestSumVat5DateBetween(String startDate, String endDate) {
        return restaurantDao.listRestSumVat5DateBetween(startDate, endDate);
    }

    @Override
    public List<Restaurants> listRestSumConTax5DateBetween(String startDate, String endDate) {
        return restaurantDao.listRestSumConTax5DateBetween(startDate, endDate);
    }

    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        restaurantDao.createdGuestMasterBill(gmb);
    }

    

    

}
