package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.BarPriceLists;
import greater.pojo.Bars;
import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.ServiceCharges;
import greater.service.BarService;
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

@ManagedBean(name="barController")
@RequestScoped
public class BarController implements Serializable {
                             
    @ManagedProperty(value="#{barService}")
    
    @Autowired
    BarService barService;

    public BarService getBarService() {
        return barService;
    }

    public void setBarService(BarService barService) {
        this.barService = barService;
    }
    
     private String id = new SimpleDateFormat("yyyyMMddss").format(new Date());
     private String barId = "BAR"+id;
     private String barID;
     private Guests guests;
     private BarPriceLists barPriceLists;
     private String walkInGuestId ="";
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
          
     //for storing combox value
     private String guestEmail=null; //primary key on the table
     private String guestName;      
     private String guestCompanyName;
     private Integer barPriceID;  //primary key on the table
     private String barPriceDesItem;  
     private String startDate;
     private String endDate;
     private String productDec = "Bar Service Charge";
          
     private double serviceCharge=0.0;
     private double grandTotal=0.0;
     
     //variables for Guest Master Bill 
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

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public String getBarID() {
        return barID;
    }

    public void setBarID(String barID) {
        this.barID = barID;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public BarPriceLists getBarPriceLists() {
        return barPriceLists;
    }

    public void setBarPriceLists(BarPriceLists barPriceLists) {
        this.barPriceLists = barPriceLists;
    }

    public String getWalkInGuestId() {
        return walkInGuestId;
    }

    public void setWalkInGuestId(String walkInGuestId) {
        this.walkInGuestId = walkInGuestId;
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

    public Integer getBarPriceID() {
        return barPriceID;
    }

    public void setBarPriceID(Integer barPriceID) {
        this.barPriceID = barPriceID;
    }

    public String getBarPriceDesItem() {
        return barPriceDesItem;
    }

    public void setBarPriceDesItem(String barPriceDesItem) {
        this.barPriceDesItem = barPriceDesItem;
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

    public String getProductDec() {
        return productDec;
    }

    public void setProductDec(String productDec) {
        this.productDec = productDec;
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
         
    public BarController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();
    GuestMasterBills gmb = new GuestMasterBills();    
     
    public String saveBar(){                 
        Bars b = new Bars();        
        Guests guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);
                    
           double totals = discountedRate * qty;
           vat5 = 0.05 * totals;
           conTax5 = 0.05 * totals;
           
            b.setId(barId);
            b.setGuests(guests);                        
            b.setBarPriceLists(barPriceLists);                        
            b.setMealType(mealType);
            b.setAmount(amount);
            b.setReceiptNo(receiptNo);
            b.setRoomNo(roomNo);
            b.setTableNo(tableNo);            
            b.setQty(qty);            
            b.setDiscountedRate(discountedRate);
            b.setTotal(totals);
            b.setVat5(vat5);
            b.setConTax5(conTax5);            
            b.setWaiterName(waiterName);
            b.setGuestSignature(guestSignature);
            b.setSignture(signture);
            b.setAuthorizedDiscount(authorizedDiscount);
            b.setApprovedDiscount(approvedDiscount);
            b.setTimes(times);
            b.setCreatedDate(createdDate);
                       
            barService.createdBar(b);
            setFieldToNull();
            mgsError="Bar Record Created!!!";
                                  
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
            audit.setOperation("Create Bar Room Guest with ID "+b.getId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_bar";
    }
    
    public String updateBar(){
        Bars b = new Bars();        
        guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);             
                
        int mgs = barService.checkBarID(barID);
        if(mgs ==0){
           
           total = discountedRate * qty;
           vat5 = 0.05 * total;
           conTax5 = 0.05 * total;    
           
            b.setId(barID);
            b.setGuests(guests);                        
            b.setBarPriceLists(barPriceLists);                        
            b.setMealType(mealType);
            b.setAmount(amount);
            b.setReceiptNo(receiptNo);
            b.setRoomNo(roomNo);
            b.setTableNo(tableNo);            
            b.setQty(qty);            
            b.setDiscountedRate(discountedRate);
            b.setTotal(total);
            b.setVat5(vat5);
            b.setConTax5(conTax5);            
            b.setWaiterName(waiterName);
            b.setGuestSignature(guestSignature);
            b.setSignture(signture);
            b.setAuthorizedDiscount(authorizedDiscount);
            b.setApprovedDiscount(approvedDiscount);
            b.setTimes(times);
            b.setCreatedDate(createdDate);
                       
            barService.updateBar(b);
            setFieldToNull();
            mgsError="Bar Record Update!!!";                      
            
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
            audit.setOperation("Update Bar Room Guest with ID "+b.getId());
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
            mgsError="Bar Record Does Not Exist!!!"; 
        }
        return "hotel_bar_edit";
    }
    
    public String deleteBar(){
        Bars b = new Bars();        
        guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);             
                        
        int mgs = barService.checkBarID(barID);
        if(mgs ==0){
           
            b.setId(barID);
            b.setGuests(guests);                        
            b.setBarPriceLists(barPriceLists);                        
            b.setMealType(mealType);
            b.setAmount(amount);
            b.setReceiptNo(receiptNo);
            b.setRoomNo(roomNo);
            b.setTableNo(tableNo);            
            b.setQty(qty);            
            b.setDiscountedRate(discountedRate);
            b.setTotal(total);
            b.setVat5(vat5);
            b.setConTax5(conTax5);            
            b.setWaiterName(waiterName);
            b.setGuestSignature(guestSignature);
            b.setSignture(signture);
            b.setAuthorizedDiscount(authorizedDiscount);
            b.setApprovedDiscount(approvedDiscount);
            b.setTimes(times);
            b.setCreatedDate(createdDate);
            
            barService.deleteBar(b);
            setFieldToNull();
            mgsError="Bar Record Deleted!!!";                      
            
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
            audit.setOperation("Delete Bar Room Guest with ID "+b.getId());
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
            mgsError="Bar Record Does Not Exist!!!"; 
        }
        
        return "hotel_bar_edit";
    }
    
    public String saveBarOrder(){                 
        Bars b = new Bars();        
                
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);             
                    
           total = discountedRate * qty;
           vat5 = 0.05 * total;
           conTax5 = 0.05 * total;
           
            b.setId(barId);
            b.setWalkInGuestId(walkInGuestId);
            b.setBarPriceLists(barPriceLists);                        
            b.setMealType(mealType);
            b.setAmount(amount);
            b.setReceiptNo(receiptNo);
            b.setRoomNo(roomNo);
            b.setTableNo(tableNo);            
            b.setQty(qty);            
            b.setDiscountedRate(discountedRate);
            b.setTotal(total);
            b.setVat5(vat5);
            b.setConTax5(conTax5);            
            b.setWaiterName(waiterName);
            b.setGuestSignature(guestSignature);
            b.setSignture(signture);
            b.setAuthorizedDiscount(authorizedDiscount);
            b.setApprovedDiscount(approvedDiscount);
            b.setTimes(times);
            b.setCreatedDate(createdDate);
            
            barService.createdBar(b);
            setFieldToNull();
            mgsError="Bar Record Created!!!";
                      
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
            audit.setOperation("Create Bar Walk in Guest with ID "+b.getId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_bar_order";
    }
    
    public String updateBarOrder(){
        
        Bars b = new Bars();        
                
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);             
                
        int mgs = barService.checkBarID(barID);
        if(mgs ==0){
            
           total = discountedRate * qty;
           vat5 = 0.05 * total;
           conTax5 = 0.05 * total;
           
            b.setId(barID);
            b.setWalkInGuestId(walkInGuestId);
            b.setBarPriceLists(barPriceLists);                        
            b.setMealType(mealType);
            b.setAmount(amount);
            b.setReceiptNo(receiptNo);
            b.setRoomNo(roomNo);
            b.setTableNo(tableNo);            
            b.setQty(qty);            
            b.setDiscountedRate(discountedRate);
            b.setTotal(total);
            b.setVat5(vat5);
            b.setConTax5(conTax5);            
            b.setWaiterName(waiterName);
            b.setGuestSignature(guestSignature);
            b.setSignture(signture);
            b.setAuthorizedDiscount(authorizedDiscount);
            b.setApprovedDiscount(approvedDiscount);
            b.setTimes(times);
            b.setCreatedDate(createdDate);
                       
            barService.updateBar(b);
            setFieldToNull();
            mgsError="Bar Record Update!!!";                      
            
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
            audit.setOperation("Update Bar Walk in Guest with ID "+b.getId());
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
            mgsError="Bar Record Does Not Exist!!!"; 
        }
        return "hotel_bar_order_edit";
    }
    
    public String deleteBarOrder(){
        Bars b = new Bars();        
                
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);             
                        
        int mgs = barService.checkBarID(barID);
        if(mgs ==0){
           
            b.setId(barID);
            b.setWalkInGuestId(walkInGuestId);
            b.setBarPriceLists(barPriceLists);                        
            b.setMealType(mealType);
            b.setAmount(amount);
            b.setReceiptNo(receiptNo);
            b.setRoomNo(roomNo);
            b.setTableNo(tableNo);            
            b.setQty(qty);            
            b.setDiscountedRate(discountedRate);
            b.setTotal(total);
            b.setVat5(vat5);
            b.setConTax5(conTax5);            
            b.setWaiterName(waiterName);
            b.setGuestSignature(guestSignature);
            b.setSignture(signture);
            b.setAuthorizedDiscount(authorizedDiscount);
            b.setApprovedDiscount(approvedDiscount);
            b.setTimes(times);
            b.setCreatedDate(createdDate);
            
            barService.deleteBar(b);
            setFieldToNull();
            mgsError="Bar Record Deleted!!!";                      
            
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
            audit.setOperation("Delete Bar Walk in Guest with ID "+b.getId());
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
            mgsError="Bar Record Does Not Exist!!!"; 
        }
        
        return "hotel_bar_order_edit";
    }
    
    // Method To Fetch Particular Bar Details From The Database
	public String getBarDetailsByID() { 
        Bars b = new Bars();        
        guests = new Guests(guestEmail);    
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                   
                       
       try{                                 
        List<Bars> bList = barService.listBarByID(barID);
                
            int checkBarId = barService.checkBarID(barID);                
                if(checkBarId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    guestEmail = b.getGuests().getEmail();
                    guestName = b.getGuests().getFirstName() +" "+b.getGuests().getLastName();
                    guestCompanyName =b.getGuests().getCompanyName();
                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture();
                    
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
                    audit.setOperation("Select Bar Room Guest with ID "+b.getId());
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
                }else if(checkBarId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                } 
       }catch(Exception ex){
           ex.printStackTrace();
       }
		return "hotel_bar_edit";
    }
        
    // Method To Fetch Particular Bar Details From The Database
	public String getBarOrderDetailsByID() { 
        Bars b = new Bars();        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                   
                       
       try{                                 
        List<Bars> bList = barService.listBarByID(barID);
                
            int checkBarId = barService.checkBarID(barID);                
                if(checkBarId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId= b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture();
                    
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
                    audit.setOperation("Select Bar Room Guest with ID "+b.getId());
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
                }else if(checkBarId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                } 
       }catch(Exception ex){
           ex.printStackTrace();
       }
		return "hotel_bar_order_edit";
	}
        
        // Method To Fetch Particular Restaurant Details From The Database
	public String getBarBillByID() { 
        Bars b = new Bars();        
        guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                   
                                
        List<Bars> bList = barService.listBarByEmail(guestEmail, startDate, endDate);
                
            int checkBarId = barService.checkBarEmail(guestEmail);                
                if(checkBarId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    guestEmail = b.getGuests().getEmail();
                    guestName = b.getGuests().getFirstName() +" "+b.getGuests().getLastName();
                    guestCompanyName = b.getGuests().getCompanyName();
                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId = b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture();                    
		}
                }else if(checkBarId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                }           
		return "hotel_bar_bill";
	}
        
        public String getBarBillServiceCharge() {         
        Bars b = new Bars();        
        guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                   

        try{                                
        List<Bars> bList = barService.listBarByEmail(guestEmail, startDate, endDate);        
                
            int checkBarId = barService.checkBarEmail(guestEmail);                
                if(checkBarId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    guestEmail = b.getGuests().getEmail();
                    guestName = b.getGuests().getFirstName() +" "+b.getGuests().getLastName();
                    guestCompanyName = b.getGuests().getCompanyName();
                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId = b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture(); 
                                        
		}
                }else if(checkBarId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
		return "hotel_bar_bill_serchange";
 }

        public String getBarBillByWalkInGuestID() { 
        Bars b = new Bars();        
        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                               
        List<Bars> bList = barService.listBarByWalkInGuest(walkInGuestId, startDate, endDate);
                
            int checkWalkInGuestId = barService.checkBarWalkInGuest(walkInGuestId);                
                if(checkWalkInGuestId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId = b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture();                                       
		}
                }else if(checkWalkInGuestId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                }           
		return "hotel_bar_bill_walkinguest";
	}
        
    public String getBarBillByWingSerCharge() { 
        Bars b = new Bars();        
        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                         
        try{                                  
        List<Bars> bList = barService.listBarByWalkInGuest(walkInGuestId, startDate, endDate);
                
            int checkWalkInGuestId = barService.checkBarWalkInGuest(walkInGuestId);                
                if(checkWalkInGuestId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId = b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture();                    
		}
                }else if(checkWalkInGuestId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
		return "hotel_bar_bill_walkinguest_serch";
	}
        
    public List<Bars> getBarBillByEmailID() { 
        Bars b = new Bars();        
        guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();
        barPriceLists.setBarPriceId(barPriceID);                   
                                        
        List<Bars> bList = barService.listBarByEmail(guestEmail);
                
            int checkBarId = barService.checkBarEmail(guestEmail);                
                if(checkBarId==0){                   
		for(Iterator it = bList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       

                    guestEmail = b.getGuests().getEmail();
                    guestName = b.getGuests().getFirstName() +" "+b.getGuests().getLastName();
                    guestCompanyName = b.getGuests().getCompanyName();
                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId = b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture(); 
                    
		}
                }else if(checkBarId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                }           
		return bList;
	}
    
    public List<Bars> getBarWalkInGuesID() { 
        Bars b = new Bars();        
        guests = new Guests(guestEmail);        
                        
        barPriceLists = new BarPriceLists();        
        barPriceLists.setBarPriceId(barPriceID);                                                 
        
        List<Bars> resList = barService.listBarByWalkInGuest(walkInGuestId);
                
            int checkBarId = barService.checkBarWalkInGuest(walkInGuestId);                
                if(checkBarId==0){                   
		for(Iterator it = resList.iterator(); it.hasNext();) {                    
                    b = (Bars)it.next();                                       
                    
                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    walkInGuestId = b.getWalkInGuestId();
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();                    
                    guestSignature = b.getGuestSignature();                                       
                    signture = b.getSignture(); 
                    
		}
                }else if(checkBarId!=0){
                    setMgsError("Bar Record does not Exist!!");                                                          
                }           
		return resList;
	}
    
    public List<Bars> getBarSumTotal() {                             
        Guests guests = new Guests(guestEmail);  
        List<Bars> sumTotal = barService.listBarBySumTotal(guestEmail);        
         return sumTotal;
	}
        
	public List<Bars> getBarWINGuestSumTotal() {                                     
        List<Bars> sumTotal = barService.listBarByWINGSumTotal(walkInGuestId);        
         return sumTotal;
	}
        
        public List<ServiceCharges> getSerCharge() {                             
        Guests guests = new Guests(guestEmail);  
        List<ServiceCharges> serviceChargelst = barService.listServiceCharge(guestEmail, productDec);        
         return serviceChargelst;
	}
        
        public List<ServiceCharges> getGdTotal() {                             
        Guests guests = new Guests(guestEmail);  
        List<ServiceCharges> grandTotalLst = barService.listSerChGrandTotal(guestEmail, productDec);        
         return grandTotalLst;
	}
        
        public List<ServiceCharges> getSerChargeWINGuest() {                                      
        List<ServiceCharges> serviceChargelst = barService.listServiceChargeWinguest(walkInGuestId, productDec);        
         return serviceChargelst;
	}
        
        public List<ServiceCharges> getGdTotalWINGuest() {                                     
        List<ServiceCharges> grandTotalLst = barService.listSerChGrandTotalWinguest(walkInGuestId, productDec);        
         return grandTotalLst;
	}

        public List<Bars> getSumTotalBetDate() {                                     
        List<Bars> sumTotal = barService.listBarSumTotalDateBetween(startDate, endDate);
         return sumTotal;
	}
        
        public List<Bars> getSumVat5BetDate() {                                     
        List<Bars> sumVat = barService.listBarSumVat5DateBetween(startDate, endDate);
         return sumVat;
	}
        
        public List<Bars> getSumConTax5BetDate() {                                     
        List<Bars> sumConTax = barService.listBarSumConTax5DateBetween(startDate, endDate);
         return sumConTax;
	}
        
        public List<Bars> getBarDetails() {            
            Bars b = new Bars();
                        
            List<Bars> bList = barService.listBar();
		for(Iterator it = bList.iterator();it.hasNext();) {                    
                    b = (Bars)it.next();
                    
                    id = b.getId();                    
                    barPriceID = b.getBarPriceLists().getBarPriceId();
                    barPriceDesItem = b.getBarPriceLists().getDrinkDescription();
                    amount = b.getAmount();        
                    mealType = b.getMealType();                    
                    roomNo = b.getRoomNo();
                    tableNo = b.getTableNo();                    
                    qty = b.getQty();
                    discountedRate = b.getDiscountedRate();                    
                    waiterName = b.getWaiterName();
                    authorizedDiscount = b.getAuthorizedDiscount();
                    approvedDiscount = b.getApprovedDiscount();            
                    guestSignature = b.getGuestSignature();
                    signture = b.getSignture();
                    vat5 = b.getVat5();
                    conTax5 = b.getConTax5();
                    times = b.getTimes();
                    createdDate = b.getCreatedDate();                    
                    
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
                    audit.setOperation("View All Bar Details");
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
		return bList;
	}
    
    public void setFieldToNull(){                        
        this.setId("");
        this.setGuests(null);
        this.setWalkInGuestId("");
        this.setBarPriceLists(null);
        this.setGuestEmail("");        
        this.setGuestName("");        
        this.setGuestCompanyName("");
        this.setBarPriceDesItem("");                
        this.setBarPriceID(0);
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
