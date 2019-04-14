package greater.service;

import greater.dao.RestaurantPriceListDao;
import greater.pojo.RestaurantPriceLists;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("restaurantPriceListService")
@Transactional(readOnly = true)
public class RestaurantPriceListServiceImp  implements RestaurantPriceListService{
    
    @Autowired
    RestaurantPriceListDao restaurantPriceListDao; 

    public RestaurantPriceListDao getRestaurantPriceListDao() {
        return restaurantPriceListDao;
    }

    public void setRestaurantPriceListDao(RestaurantPriceListDao restaurantPriceListDao) {
        this.restaurantPriceListDao = restaurantPriceListDao;
    }
    
    @Override
    public void createdResPriceList(RestaurantPriceLists restPrice) {
        restaurantPriceListDao.createdResPriceList(restPrice);
    }

    @Override
    public void updateResPriceList(RestaurantPriceLists restPrice) {
        restaurantPriceListDao.updateResPriceList(restPrice);
    }

    @Override
    public void deleteResPriceList(RestaurantPriceLists restPrice) {
        restaurantPriceListDao.deleteResPriceList(restPrice);
    }

    @Override
    public List<RestaurantPriceLists> listResPriceListByID(int restPriceId) {
        return restaurantPriceListDao.listResPriceListByID(restPriceId);
    }

    @Override
    public List<RestaurantPriceLists> listResPriceList() {
        return restaurantPriceListDao.listResPriceList();
    }

    @Override
    public int checkResPriceListID(int restPriceId) {
        return restaurantPriceListDao.checkResPriceListID(restPriceId);
    }

    @Override
    public List<RestaurantPriceLists> pepperSoup() {
        return restaurantPriceListDao.pepperSoup();
    }

    @Override
    public List<RestaurantPriceLists> allPepperSoup() {
        return restaurantPriceListDao.allPepperSoup();
    }

    @Override
    public List<RestaurantPriceLists> peppered() {
        return restaurantPriceListDao.peppered();
    }

    @Override
    public List<RestaurantPriceLists> allPepperred() {
        return restaurantPriceListDao.allPepperred();
    }

    @Override
    public List<RestaurantPriceLists> barbecue() {
        return restaurantPriceListDao.barbecue();
    }

    @Override
    public List<RestaurantPriceLists> allBarBecue() {
        return restaurantPriceListDao.allBarBecue();
    }

    @Override
    public List<RestaurantPriceLists> byOrder() {
        return restaurantPriceListDao.byOrder();
    }

    @Override
    public List<RestaurantPriceLists> allByOrder() {
        return restaurantPriceListDao.allByOrder();
    }

    @Override
    public List<RestaurantPriceLists> choiceOfFood() {
        return restaurantPriceListDao.choiceOfFood();
    }

    @Override
    public List<RestaurantPriceLists> allChoiceOfFood() {
        return restaurantPriceListDao.allChoiceOfFood();
    }
    
}
