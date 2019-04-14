package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.RestaurantPriceLists;
import greater.pojo.RoomStatus;
import greater.service.RestaurantPriceListService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name="restaurantPriceListController")
@RequestScoped
public class RestaurantPriceListController implements Serializable {
    
    @ManagedProperty(value="#{restaurantPriceListService}")
    
    @Autowired
    RestaurantPriceListService restaurantPriceListService;

    public RestaurantPriceListService getRestaurantPriceListService() {
        return restaurantPriceListService;
    }

    public void setRestaurantPriceListService(RestaurantPriceListService restaurantPriceListService) {
        this.restaurantPriceListService = restaurantPriceListService;
    }
    
     private Integer restaurantPriceId;
     private String foodType;
     private String foodDescription;
     private Double vat5;
     private Double conTax5;
     private Double amount;
     private String createdDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    
     private String mgsError;

    public Integer getRestaurantPriceId() {
        return restaurantPriceId;
    }

    public void setRestaurantPriceId(Integer restaurantPriceId) {
        this.restaurantPriceId = restaurantPriceId;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public double getVat5() {
        return vat5;
    }

    public void setVat5(double vat5) {
        this.vat5 = vat5;
    }

    public double getConTax5() {
        return conTax5;
    }

    public void setConTax5(double conTax5) {
        this.conTax5 = conTax5;
    }
       
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMgsError() {
        return mgsError;
    }

    public void setMgsError(String mgsError) {
        this.mgsError = mgsError;
    }
     
    public RestaurantPriceListController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    
    public String saveRestaurantPrice(){                 
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        
        vat5 = 0.05 * amount;        
        conTax5 = 0.05 * amount;
        amount = amount + vat5 + conTax5;

            restPrice.setRestaurantPriceId(restaurantPriceId);
            restPrice.setFoodType(foodType);
            restPrice.setFoodDescription(foodDescription);
            restPrice.setConTax5(vat5);
            restPrice.setVat5(vat5);
            restPrice.setAmount(amount);
            
            restPrice.setCreatedDate(createdDate);                 
            
            restaurantPriceListService.createdResPriceList(restPrice);
            setFieldToNull();
            mgsError="Restaurant Price List Record Created!!!";
                      
            String sEmail = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            String sUserRoleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sUserRoleId").toString();
            String sPassword = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPassword").toString();
            String sFirstName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sFirstName").toString();
            String sLastName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sLastName").toString();
            String sSex = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sSex").toString();
            String sPhone = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPhone").toString();
            String sAddress = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sAddress").toString();
            String sPosition = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPosition").toString();
            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Create Restaurant Price List with ID "+restPrice.getRestaurantPriceId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_restaurant_price";
    }        
    
    public String updateRestaurantPrice(){        
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        
        int mgs = restaurantPriceListService.checkResPriceListID(restaurantPriceId);
        if(mgs ==0){           
            
        vat5 = 0.05 * amount;        
        conTax5 = 0.05 * amount;
        amount = amount + vat5 + conTax5;
            
            restPrice.setRestaurantPriceId(restaurantPriceId);
            restPrice.setFoodType(foodType);
            restPrice.setFoodDescription(foodDescription);
            restPrice.setVat5(vat5);
            restPrice.setConTax5(conTax5);            
            restPrice.setAmount(amount);
            restPrice.setCreatedDate(createdDate);                 
            
            restaurantPriceListService.updateResPriceList(restPrice);
            setFieldToNull();            
            mgsError="Restaurant Price List Record Updated !!!";          
            
            String sEmail = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            String sUserRoleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sUserRoleId").toString();
            String sPassword = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPassword").toString();
            String sFirstName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sFirstName").toString();
            String sLastName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sLastName").toString();
            String sSex = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sSex").toString();
            String sPhone = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPhone").toString();
            String sAddress = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sAddress").toString();
            String sPosition = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPosition").toString();
            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Update Restaurant Price List with ID "+restPrice.getRestaurantPriceId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
        }
            else if(mgs !=0){
            mgsError="Restaurant Price List Record Does Not Exist!!!"; 
        }
        return "hotel_restaurant_price_list_edit";
    }
    
    public String deleteRestaurantPrice(){
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
                                                                
        int mgs = restaurantPriceListService.checkResPriceListID(restaurantPriceId);
        if(mgs ==0){
            
            restPrice.setRestaurantPriceId(restaurantPriceId);
            restPrice.setFoodType(foodType);
            restPrice.setFoodDescription(foodDescription);
            restPrice.setAmount(amount);
            restPrice.setCreatedDate(createdDate);                 
            
            restaurantPriceListService.deleteResPriceList(restPrice);
            setFieldToNull();            
            mgsError="Restaurant Price List Record Delete !!!";                    
            
            String sEmail = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            String sUserRoleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sUserRoleId").toString();
            String sPassword = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPassword").toString();
            String sFirstName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sFirstName").toString();
            String sLastName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sLastName").toString();
            String sSex = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sSex").toString();
            String sPhone = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPhone").toString();
            String sAddress = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sAddress").toString();
            String sPosition = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPosition").toString();
            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Delete Restaurant Price List with ID "+restPrice.getRestaurantPriceId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
        }
            else if(mgs !=0){
            mgsError="Restaurant Price List Record Does Not Exist!!!"; 
        }
        
        return "hotel_restaurant_price_list_edit";
    }
    
    // Method To Fetch Particular Restaurant Details From The Database
	public String getRestaurantDetailsByID() { 
            RestaurantPriceLists restPrice = new RestaurantPriceLists();                           
            List<RestaurantPriceLists> restList = restaurantPriceListService.listResPriceListByID(restaurantPriceId);
                
            int checkRestaurantPriceId = restaurantPriceListService.checkResPriceListID(restaurantPriceId);                
                if(checkRestaurantPriceId==0){                   
		for(Iterator it = restList.iterator(); it.hasNext();) {                    
                    restPrice = (RestaurantPriceLists)it.next();                                       
                    
                    restaurantPriceId = restPrice.getRestaurantPriceId();                
                    foodType = restPrice.getFoodType();
                    foodDescription = restPrice.getFoodDescription();
                    amount = restPrice.getAmount();
                    createdDate = restPrice.getCreatedDate();
                                    
		}
                }else if(checkRestaurantPriceId!=0){
                    setMgsError("Restaurant Price List Record does not Exist!!");                                                          
                }           
		return "hotel_restaurant_price_edit";
	}
                
    // Method To Fetch All Restaurant Price Lists Details From The Database
    public List<RestaurantPriceLists> getRestaurantPriceDetails() {            
            RestaurantPriceLists restPrice = new RestaurantPriceLists();
                        
            List<RestaurantPriceLists> restPriceList = restaurantPriceListService.listResPriceList();
		for(Iterator it = restPriceList.iterator();it.hasNext();) {                    
                    restPrice = (RestaurantPriceLists)it.next();
                                        
                    restaurantPriceId = restPrice.getRestaurantPriceId();                
                    foodType = restPrice.getFoodType();
                    foodDescription = restPrice.getFoodDescription();
                    amount = restPrice.getAmount();
                    createdDate = restPrice.getCreatedDate();                    
		}               
		return restPriceList;
	}
    
    public List<RestaurantPriceLists> getPepperSoup() {                                      
        List<RestaurantPriceLists> pepperSoup = restaurantPriceListService.pepperSoup();
        return pepperSoup;
    }
   
    public List<RestaurantPriceLists> getAllPepperSoup() {                                      
        List<RestaurantPriceLists> allpepperSoup = restaurantPriceListService.allPepperSoup();
        return allpepperSoup;
    }
    
    public List<RestaurantPriceLists> getPeppered() {                                      
        List<RestaurantPriceLists> peppered = restaurantPriceListService.peppered();
        return peppered;
    }
   
    public List<RestaurantPriceLists> getAllPeppered() {                                      
        List<RestaurantPriceLists> allpepperSoup = restaurantPriceListService.allPepperred();
        return allpepperSoup;
    }
    
    public List<RestaurantPriceLists> getBarbecue() {                                      
        List<RestaurantPriceLists> barbecue = restaurantPriceListService.barbecue();
        return barbecue;
    }
   
    public List<RestaurantPriceLists> getAllBarbecue() {                                      
        List<RestaurantPriceLists> allbarbecue = restaurantPriceListService.allBarBecue();
        return allbarbecue;
    }
    
    public List<RestaurantPriceLists> getByOrder() {                                      
        List<RestaurantPriceLists> byOrder = restaurantPriceListService.byOrder();
        return byOrder;
    }
   
    public List<RestaurantPriceLists> getAllByOrder() {                                      
        List<RestaurantPriceLists> allbyOrder = restaurantPriceListService.allByOrder();
        return allbyOrder;
    }
    
    public List<RestaurantPriceLists> getChoiceOfFood() {                                      
        List<RestaurantPriceLists> choiceOfFood = restaurantPriceListService.choiceOfFood();
        return choiceOfFood;
    }
   
    public List<RestaurantPriceLists> getAllChoiceOfFood() {                                      
        List<RestaurantPriceLists> allchoiceOfFood = restaurantPriceListService.allChoiceOfFood();
        return allchoiceOfFood;
    }
        
    public void setFieldToNull(){                
        this.setRestaurantPriceId(0);
        this.setFoodType("");
        this.setFoodDescription("");
        this.setAmount(0.0);        
        this.setCreatedDate("");        
    }
    
}
