package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.RestaurantPriceLists;
import greater.pojo.Restaurants;
import greater.pojo.ServiceCharges;
import greater.service.RestaurantService;
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

@ManagedBean(name="restaurantController")
@RequestScoped
public class RestaurantController implements Serializable {
    
    @ManagedProperty(value="#{restaurantService}")
    
    @Autowired
    RestaurantService restaurantService;

    public RestaurantService getRestaurantService() {
        return restaurantService;
    }

    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
     private String id = new SimpleDateFormat("yyyyMMddss").format(new Date());
     private String resId = "REST"+id;
     private String restId;
     private Guests guests;
     private String walkInGuestId;
     private RestaurantPriceLists restaurantPriceLists;
     private String receiptNo = new SimpleDateFormat("yyyyMMddss").format(new Date());
     private String roomNo;
     private String tableNo;
     private Integer qty;
     private String mealType;
     private Double amount = 0.0;
     private Double discountedRate = 0.0;
     private Double total;
     private Double vat5;
     private Double conTax5;
     private String waiterName;
     private String guestSignature;
     private String signture;
     private String authorizedDiscount;
     private String approvedDiscount;        
     private String times = new SimpleDateFormat("HH:mm:ss").format(new Date());
     private String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
     private String mgsError;
          
     //variables for storing combox value
     private String guestEmail=null; //primary key on the table
     private Integer restPriceID;  //primary key on the table
     
     //creating variables for storing the value of parent table 
     private String guestName;      
     private String guestCompanyName; 
     private String guestDate;      
     private String restPriceDesItem;  
     //end here
     private String startDate;
     private String endDate;     
     private double serviceCharge=0.0;
     private double grandTotal=0.0;
     
     //creating guest master bill variables
     private String gmbId = new SimpleDateFormat("yyyyss").format(new Date());     
     private String gmbID = "GMB"+gmbId;
     private String createdTime =  new SimpleDateFormat("HH:mm:ss").format(new Date()); 

    public String getGmbId() {
        return gmbId;
    }

    public void setGmbId(String gmbId) {
        this.gmbId = gmbId;
    }

    public String getGmbID() {
        return gmbID;
    }

    public void setGmbID(String gmbID) {
        this.gmbID = gmbID;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
     
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getRestId() {
        return restId;
    }

    public void setRestId(String restId) {
        this.restId = restId;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public String getWalkInGuestId() {
        return walkInGuestId;
    }

    public void setWalkInGuestId(String walkInGuestId) {
        this.walkInGuestId = walkInGuestId;
    }
    
    public RestaurantPriceLists getRestaurantPriceLists() {
        return restaurantPriceLists;
    }

    public void setRestaurantPriceLists(RestaurantPriceLists restaurantPriceLists) {
        this.restaurantPriceLists = restaurantPriceLists;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscountedRate() {
        return discountedRate;
    }

    public void setDiscountedRate(Double discountedRate) {
        this.discountedRate = discountedRate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getVat5() {
        return vat5;
    }

    public void setVat5(Double vat5) {
        this.vat5 = vat5;
    }

    public Double getConTax5() {
        return conTax5;
    }

    public void setConTax5(Double conTax5) {
        this.conTax5 = conTax5;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getGuestSignature() {
        return guestSignature;
    }

    public void setGuestSignature(String guestSignature) {
        this.guestSignature = guestSignature;
    }

    public String getSignture() {
        return signture;
    }

    public void setSignture(String signture) {
        this.signture = signture;
    }

    public String getAuthorizedDiscount() {
        return authorizedDiscount;
    }

    public void setAuthorizedDiscount(String authorizedDiscount) {
        this.authorizedDiscount = authorizedDiscount;
    }

    public String getApprovedDiscount() {
        return approvedDiscount;
    }

    public void setApprovedDiscount(String approvedDiscount) {
        this.approvedDiscount = approvedDiscount;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
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

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestCompanyName() {
        return guestCompanyName;
    }

    public void setGuestCompanyName(String guestCompanyName) {
        this.guestCompanyName = guestCompanyName;
    }

    public Integer getRestPriceID() {
        return restPriceID;
    }

    public void setRestPriceID(Integer restPriceID) {
        this.restPriceID = restPriceID;
    }

    public String getRestPriceDesItem() {
        return restPriceDesItem;
    }

    public void setRestPriceDesItem(String restPriceDesItem) {
        this.restPriceDesItem = restPriceDesItem;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGuestDate() {
        return guestDate;
    }

    public void setGuestDate(String guestDate) {
        this.guestDate = guestDate;
    }
                
    public RestaurantController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    GuestMasterBills gmb = new GuestMasterBills();    
     
    public String saveRestaurant(){                 
        Restaurants res = new Restaurants();        
        Guests guests = new Guests();        
        guests.setEmail(guestEmail);
        guests.getEmail();
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                    
           vat5 = 0.05 * discountedRate;
           conTax5 = 0.05 * discountedRate;           
           double totals = discountedRate * qty;
           
            res.setId(resId);
            res.setGuests(guests);                        
            res.setRestaurantPriceLists(restPrice);            
            res.setMealType(mealType);
            res.setAmount(amount);
            res.setReceiptNo(receiptNo);
            res.setRoomNo(roomNo);
            res.setTableNo(tableNo);            
            res.setQty(qty);            
            res.setDiscountedRate(discountedRate);
            res.setTotal(totals);
            res.setVat5(vat5);
            res.setConTax5(conTax5);            
            res.setWaiterName(waiterName);
            res.setGuestSignature(guestSignature);
            res.setSignture(signture);
            res.setAuthorizedDiscount(authorizedDiscount);
            res.setApprovedDiscount(approvedDiscount);
            res.setTimes(times);
            res.setCreatedDate(createdDate);
                       
            restaurantService.createdRestaurant(res);
            setFieldToNull();
            mgsError="Restaurant Record Created!!!";
                      
            try{
                       
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
            audit.setOperation("Create Restaurant Room Guest with ID "+res.getId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
            }catch(Exception ex){
                ex.printStackTrace();
            }

        return "hotel_restaurant";
    }
    
    public String updateRestaurant(){
        
        Restaurants res = new Restaurants();
        
        Guests guests = new Guests(guestEmail);        
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                
        int mgs = restaurantService.checkRestaurantID(restId);
        if(mgs ==0){
            
           vat5 = 0.05 * discountedRate;
           conTax5 = 0.05 * discountedRate;           
           total = discountedRate * qty;
           
            res.setId(restId);
            res.setGuests(guests);            
            res.setRestaurantPriceLists(restPrice);            
            res.setMealType(mealType);
            res.setAmount(amount);
            res.setReceiptNo(receiptNo);
            res.setRoomNo(roomNo);
            res.setTableNo(tableNo);            
            res.setQty(qty);            
            res.setDiscountedRate(discountedRate);
            res.setTotal(total);
            res.setVat5(vat5);
            res.setConTax5(conTax5);            
            res.setWaiterName(waiterName);
            res.setGuestSignature(guestSignature);
            res.setSignture(signture);
            res.setAuthorizedDiscount(authorizedDiscount);
            res.setApprovedDiscount(approvedDiscount);
            res.setTimes(times);
            res.setCreatedDate(createdDate);
                       
            restaurantService.updateRestaurant(res);
            setFieldToNull();
            mgsError="Restaurant Record Update!!!";                      
            
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
            audit.setOperation("Update Restaurant Room Guest with ID "+res.getId());
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
            mgsError="Restaurant Record Does Not Exist!!!"; 
        }
        return "hotel_restaurant_edit";
    }
    
    public String deleteRestaurant(){
        Restaurants res = new Restaurants();
        
        Guests guests = new Guests(guestEmail);        
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                        
        int mgs = restaurantService.checkRestaurantID(restId);    
        if(mgs ==0){
                       
            res.setId(restId);
            res.setGuests(guests);            
            res.setRestaurantPriceLists(restPrice);            
            res.setMealType(mealType);
            res.setAmount(restPrices.getAmount());
            res.setReceiptNo(receiptNo);
            res.setRoomNo(roomNo);
            res.setTableNo(tableNo);            
            res.setQty(qty);            
            res.setDiscountedRate(discountedRate);
            res.setTotal(total);
            res.setVat5(vat5);
            res.setConTax5(conTax5);            
            res.setWaiterName(waiterName);
            res.setGuestSignature(guestSignature);
            res.setSignture(signture);
            res.setAuthorizedDiscount(authorizedDiscount);
            res.setApprovedDiscount(approvedDiscount);
            res.setTimes(times);
            res.setCreatedDate(createdDate);
            
            restaurantService.deleteRestaurant(res);
            setFieldToNull();
            mgsError="Restaurant Record Deleted!!!";                      
            
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
            audit.setOperation("Delete Restaurant Room Guest with ID "+res.getId());
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
            mgsError="Restaurant Record Does Not Exist!!!"; 
        }
        
        return "hotel_restaurant_edit";
    }
    
    public String saveRestaurantOrder(){                 
        Restaurants res = new Restaurants();        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                    
           vat5 = 0.05 * discountedRate;
           conTax5 = 0.05 * discountedRate;           
           total = discountedRate * qty;
           
            res.setId(resId);
            res.setRestaurantPriceLists(restPrice);            
            res.setMealType(mealType);
            res.setWalkInGuestId(walkInGuestId);
            res.setAmount(amount);
            res.setReceiptNo(receiptNo);
            res.setRoomNo(roomNo);
            res.setTableNo(tableNo);            
            res.setQty(qty);            
            res.setDiscountedRate(discountedRate);
            res.setTotal(total);
            res.setVat5(vat5);
            res.setConTax5(conTax5);            
            res.setWaiterName(waiterName);
            res.setGuestSignature(guestSignature);
            res.setSignture(signture);
            res.setAuthorizedDiscount(authorizedDiscount);
            res.setApprovedDiscount(approvedDiscount);
            res.setTimes(times);
            res.setCreatedDate(createdDate);
                       
            restaurantService.createdRestaurant(res);
            setFieldToNull();
            mgsError="Restaurant Record Created!!!";
                      
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
            audit.setOperation("Create Restaurant Walk in Guest with ID "+res.getId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_restaurant_order";
    }
    
    public String updateRestaurantOrder(){
        
        Restaurants res = new Restaurants();

        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                
        int mgs = restaurantService.checkRestaurantID(restId);
        if(mgs ==0){
            
           vat5 = 0.05 * discountedRate;
           conTax5 = 0.05 * discountedRate;           
           total = discountedRate * qty;
           
            res.setId(restId);
            res.setRestaurantPriceLists(restPrice);            
            res.setMealType(mealType);
            res.setWalkInGuestId(walkInGuestId);
            res.setAmount(amount);
            res.setReceiptNo(receiptNo);
            res.setRoomNo(roomNo);
            res.setTableNo(tableNo);            
            res.setQty(qty);            
            res.setDiscountedRate(discountedRate);
            res.setTotal(total);
            res.setVat5(vat5);
            res.setConTax5(conTax5);            
            res.setWaiterName(waiterName);
            res.setGuestSignature(guestSignature);
            res.setSignture(signture);
            res.setAuthorizedDiscount(authorizedDiscount);
            res.setApprovedDiscount(approvedDiscount);
            res.setTimes(times);
            res.setCreatedDate(createdDate);
                       
            restaurantService.updateRestaurant(res);
            setFieldToNull();
            mgsError="Restaurant Record Update!!!";                      
            
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
            audit.setOperation("Update Restaurant Walk in Guest with ID "+res.getId());
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
            mgsError="Restaurant Record Does Not Exist!!!"; 
        }
        return "hotel_restaurant_order_edit";
    }
    
    public String deleteRestaurantOrder(){
        Restaurants res = new Restaurants();
                        
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                        
        int mgs = restaurantService.checkRestaurantID(restId);    
        if(mgs ==0){
                       
            res.setId(restId);        
            res.setRestaurantPriceLists(restPrice);            
            res.setMealType(mealType);
            res.setWalkInGuestId(walkInGuestId);
            res.setAmount(restPrices.getAmount());
            res.setReceiptNo(receiptNo);
            res.setRoomNo(roomNo);
            res.setTableNo(tableNo);            
            res.setQty(qty);            
            res.setDiscountedRate(discountedRate);
            res.setTotal(total);
            res.setVat5(vat5);
            res.setConTax5(conTax5);            
            res.setWaiterName(waiterName);
            res.setGuestSignature(guestSignature);
            res.setSignture(signture);
            res.setAuthorizedDiscount(authorizedDiscount);
            res.setApprovedDiscount(approvedDiscount);
            res.setTimes(times);
            res.setCreatedDate(createdDate);
            
            restaurantService.deleteRestaurant(res);
            setFieldToNull();
            mgsError="Restaurant Record Deleted!!!";                      
            
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
            audit.setOperation("Delete Restaurant Walk in Guest with ID "+res.getId());
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
            mgsError="Restaurant Record Does Not Exist!!!"; 
        }
        
        return "hotel_restaurant_order_edit";
    }
    
    // Method To Fetch Particular Restaurant Details From The Database
	public String getRestaurantDetailsByID() { 
        Restaurants res = new Restaurants();
        
        Guests guests = new Guests(guestEmail);        
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
                        
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
       try{                                 
        List<Restaurants> restList = restaurantService.listRestaurantByID(restId);
                
            int checkRestaurantId = restaurantService.checkRestaurantID(restId);                
                if(checkRestaurantId==0){                   
		for(Iterator it = restList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    guestEmail = res.getGuests().getEmail();
                    guestName = res.getGuests().getFirstName() +" "+res.getGuests().getLastName();
                    guestCompanyName =res.getGuests().getCompanyName();
                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId=res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                    
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
                    audit.setOperation("Select Restaurant Room Guest with ID "+res.getId());
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
                }else if(checkRestaurantId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                } 
       }catch(Exception ex){
           ex.printStackTrace();
       }
		return "hotel_restaurant_edit";
	}
        
	public String getRestaurantOrderDetailsByID() { 
        Restaurants res = new Restaurants();
        
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                                        
        List<Restaurants> restList = restaurantService.listRestaurantByID(restId);
                
            int checkRestaurantId = restaurantService.checkRestaurantID(restId);                
                if(checkRestaurantId==0){                   
		for(Iterator it = restList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                    
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
                    audit.setOperation("Select Restaurant Walk in Guest with ID "+res.getId());
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
                }else if(checkRestaurantId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
		return "hotel_restaurant_order_edit";
	}
                
    // Method To Fetch Particular Restaurant Details From The Database
	public String getRestaurantBillByID() {  
        Restaurants res = new Restaurants();        
        
        Guests guests = new Guests(guestEmail);        
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
        res.setCreatedDate(guestDate);
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                                        
        List<Restaurants> resList = restaurantService.listRestaurantByEmail(guestEmail, startDate, endDate);
                
            int checkRestaurantId = restaurantService.checkRestaurantEmail(guestEmail);                
                if(checkRestaurantId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    guestEmail = res.getGuests().getEmail();
                    guestName = res.getGuests().getFirstName() +" "+res.getGuests().getLastName();
                    guestCompanyName =res.getGuests().getCompanyName();
                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                    guestDate = res.getCreatedDate();
                    
		}
                }else if(checkRestaurantId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
		return "hotel_restaurant_bill";
	}
        
	public String getRestaurantBillByWalkInGuestID() { 
        Restaurants res = new Restaurants();        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                                        
        List<Restaurants> resList = restaurantService.listRestaurantByWalkInGuest(walkInGuestId, startDate, endDate);
                
            int checkWalkInGuestId = restaurantService.checkRestaurantWalkInGuest(walkInGuestId);                
                if(checkWalkInGuestId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();                    
                    
		}
                }else if(checkWalkInGuestId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
		return "hotel_restaurant_bill_walkinguest";
	}
        
	public String getRestaurantBillByWingSerCharge() { 
        Restaurants res = new Restaurants();        
                      
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
        try{                                  
        List<Restaurants> resList = restaurantService.listRestaurantByWalkInGuest(walkInGuestId, startDate, endDate);
                
            int checkWalkInGuestId = restaurantService.checkRestaurantWalkInGuest(walkInGuestId);                
                if(checkWalkInGuestId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();                    
                    
		}
                }else if(checkWalkInGuestId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
		return "hotel_restaurant_bill_walkinguest_serch";
	}
        
	public String getRestaurantBillServiceCharge() { 
        try{                                
            Restaurants res = new Restaurants();        
        
        Guests guests = new Guests(guestEmail);        
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
        
        List<Restaurants> resList = restaurantService.listRestaurantByEmail(guestEmail, startDate, endDate);
                
            int checkRestaurantId = restaurantService.checkRestaurantEmail(guestEmail);                
                if(checkRestaurantId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    guestEmail = res.getGuests().getEmail();
                    guestName = res.getGuests().getFirstName() +" "+res.getGuests().getLastName();
                    guestCompanyName =res.getGuests().getCompanyName();
                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                                        
		}
                }else if(checkRestaurantId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
		return "hotel_restaurant_bill_serchange";
	}

        public List<Restaurants> getRestaurantBillByEmailID() { 
        Restaurants res = new Restaurants();
        
        Guests guests = new Guests(guestEmail);        
        Guests guest = new Guests();
        guest.setFirstName(guestName);
        guest.setLastName(guestName);        
        guest.setCompanyName(guestCompanyName);        
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                                        
        List<Restaurants> resList = restaurantService.listRestaurantByEmail(guestEmail);
                
            int checkRestaurantId = restaurantService.checkRestaurantEmail(guestEmail);                
                if(checkRestaurantId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    guestEmail = res.getGuests().getEmail();
                    guestName = res.getGuests().getFirstName() +" "+res.getGuests().getLastName();
                    guestCompanyName =res.getGuests().getCompanyName();
                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                    
		}
                }else if(checkRestaurantId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
		return resList;
	}
        
        public List<Restaurants> getRestaurantWalkInGuesID() { 
        Restaurants res = new Restaurants();
                
        RestaurantPriceLists restPrice = new RestaurantPriceLists();
        restPrice.setRestaurantPriceId(restPriceID);
        RestaurantPriceLists restPrices = new RestaurantPriceLists();
        restPrices.setFoodDescription(restPriceDesItem);                 
                                        
        List<Restaurants> resList = restaurantService.listRestaurantByWalkInGuest(walkInGuestId, startDate, endDate);
                
            int checkRestaurantId = restaurantService.checkRestaurantWalkInGuest(walkInGuestId);                
                if(checkRestaurantId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    res = (Restaurants)it.next();                                       

                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    walkInGuestId = res.getWalkInGuestId();
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                    
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
                    audit.setOperation("Generate Restaurant Bill with ID "+res.getId());
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
                }else if(checkRestaurantId!=0){
                    setMgsError("Restaurant Record does not Exist!!");                                                          
                }           
		return resList;
	}
        
	public List<Restaurants> getRestaurantSumTotal() {                             
        Guests guests = new Guests(guestEmail);  
        List<Restaurants> sumTotal = restaurantService.listRestaurantBySumTotal(guestEmail);        

         return sumTotal;
	}
        
	public List<Restaurants> getRestaurantWINGuestSumTotal() {                                     
        List<Restaurants> sumTotal = restaurantService.listRestaurantByWINGSumTotal(walkInGuestId);        

         return sumTotal;
	}
        
        public List<ServiceCharges> getSerCharge() {                             
        Guests guests = new Guests(guestEmail);  
        List<ServiceCharges> serviceChargelst = restaurantService.listServiceCharge(guestEmail);        

         return serviceChargelst;
	}
        
        public List<ServiceCharges> getGdTotal() {                             
        Guests guests = new Guests(guestEmail);  
        List<ServiceCharges> grandTotalLst = restaurantService.listSerChGrandTotal(guestEmail);        

         return grandTotalLst;
	}
        
        public List<ServiceCharges> getSerChargeWINGuest() {                                      
        List<ServiceCharges> serviceChargelst = restaurantService.listServiceChargeWinguest(walkInGuestId);        

         return serviceChargelst;
	}
        
        public List<ServiceCharges> getGdTotalWINGuest() {                                     
        List<ServiceCharges> grandTotalLst = restaurantService.listSerChGrandTotalWinguest(walkInGuestId);        

         return grandTotalLst;
	}

        public List<Restaurants> getSumTotalBetDate() {                                     
        List<Restaurants> sumTotal = restaurantService.listRestSumTotalDateBetween(startDate, endDate);
         return sumTotal;
	}
        
        public List<Restaurants> getSumVat5BetDate() {                                     
        List<Restaurants> sumVat = restaurantService.listRestSumVat5DateBetween(startDate, endDate);
         return sumVat;
	}
        
        public List<Restaurants> getSumConTax5BetDate() {                                     
        List<Restaurants> sumConTax = restaurantService.listRestSumConTax5DateBetween(startDate, endDate);
         return sumConTax;
	}

   // Method To Fetch All Room Details From The Database
    public List<Restaurants> getRestaurantDetails() {            
            Restaurants res = new Restaurants();
            
            List<Restaurants> restList = restaurantService.listRestaurant();
		for(Iterator it = restList.iterator();it.hasNext();) {                    
                    res = (Restaurants)it.next();
                    
                    id = res.getId();                    
                    restPriceID = res.getRestaurantPriceLists().getRestaurantPriceId();
                    restPriceDesItem = res.getRestaurantPriceLists().getFoodDescription();
                    amount = res.getAmount();        
                    mealType = res.getMealType();                    
                    roomNo = res.getRoomNo();
                    tableNo = res.getTableNo();                    
                    qty = res.getQty();
                    discountedRate = res.getDiscountedRate();                    
                    waiterName = res.getWaiterName();
                    authorizedDiscount = res.getAuthorizedDiscount();
                    approvedDiscount = res.getApprovedDiscount();            
                    guestSignature = res.getGuestSignature();
                    signture = res.getSignture();
                    vat5 = res.getVat5();
                    conTax5 = res.getConTax5();
                    times = res.getTimes();
                    createdDate = res.getCreatedDate();                    
                    
                    try{
                    
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
                        audit.setOperation("View All Restaurant Details");
                        audit.setPassword(sPassword);
                        audit.setFirstName(sFirstName);
                        audit.setLastName(sLastName);
                        audit.setSex(sSex);
                        audit.setPhone(sPhone);
                        audit.setAddress(sAddress);
                        audit.setPosition(sPosition);
                        audit.setCreatedDate(sCreatedDate);
                        el.createAuditTrailLogin(audit);                       
                    
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
		}               
               
		return restList;
	}
      
    public void setFieldToNull(){                        
        this.setId("");
        this.setGuests(null);
        this.setWalkInGuestId("");
        this.setRestaurantPriceLists(null);
        this.setGuestEmail("");        
        this.setGuestName("");        
        this.setGuestCompanyName("");
        this.setRestPriceDesItem("");                
        this.setRestPriceID(0);
        this.setAmount(0.0);
        this.setDiscountedRate(0.0);
        this.setReceiptNo("");
        this.setRoomNo("");
        this.setTableNo("");
        this.setMealType("");                
        this.setQty(0);
        this.setGuestSignature("");
        this.setSignture("");
        this.setWaiterName("");        
        this.setTotal(0.0);
        this.setVat5(0.0);
        this.setConTax5(0.0);
        this.setServiceCharge(0.0);
        this.setAuthorizedDiscount("");
        this.setApprovedDiscount("");
        this.setTimes("");
        this.setCreatedDate("");
        this.setStartDate("");
        this.setEndDate("");
    }
    
}
