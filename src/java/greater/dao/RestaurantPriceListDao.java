package greater.dao;

import greater.pojo.RestaurantPriceLists;
import java.util.List;

public interface RestaurantPriceListDao {
    public void createdResPriceList(RestaurantPriceLists restPrice);
    public void updateResPriceList(RestaurantPriceLists restPrice);
    public void deleteResPriceList(RestaurantPriceLists restPrice);
    public List<RestaurantPriceLists> listResPriceListByID(int restPriceId);        
    public List<RestaurantPriceLists> listResPriceList();         
    public int checkResPriceListID(int restPriceId);    
    public List<RestaurantPriceLists> pepperSoup();
    public List<RestaurantPriceLists> allPepperSoup();
    public List<RestaurantPriceLists> peppered();
    public List<RestaurantPriceLists> allPepperred();
    public List<RestaurantPriceLists> barbecue();
    public List<RestaurantPriceLists> allBarBecue();
    public List<RestaurantPriceLists> byOrder();
    public List<RestaurantPriceLists> allByOrder();
    public List<RestaurantPriceLists> choiceOfFood();
    public List<RestaurantPriceLists> allChoiceOfFood();
    
}
