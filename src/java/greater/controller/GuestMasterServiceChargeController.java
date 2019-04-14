package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.Rooms;
import greater.pojo.ServiceCharges;
import greater.service.ServiceChargeService;
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

@ManagedBean(name="guestMasterServiceChargeController")
@RequestScoped
public class GuestMasterServiceChargeController implements Serializable {
    
    @ManagedProperty(value="#{serviceChargeService}")

    @Autowired
    ServiceChargeService serviceChargeService;

    public ServiceChargeService getServiceChargeService() {
        return serviceChargeService;
    }

    public void setServiceChargeService(ServiceChargeService serviceChargeService) {
        this.serviceChargeService = serviceChargeService;
    }
    
     private String serChargeId= new SimpleDateFormat("yyyyMMss").format(new Date());
     private String serChargeIds;
//     private Guests guests;
     private String email;
     private Double serviceCharge;
     private Double subTotal;
     private Double grandTotal;
     private String walkInGuestId;
     private String productDescription;
     private String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
     private String mgsError;
     
     //for storing combo box value 
     private String guestEmail="";
     
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
     
    public String getSerChargeId() {
        return serChargeId;
    }

    public void setSerChargeId(String serChargeId) {
        this.serChargeId = serChargeId;
    }

    public String getSerChargeIds() {
        return serChargeIds;
    }

    public void setSerChargeIds(String serChargeIds) {
        this.serChargeIds = serChargeIds;
    }
    
//    public void setGuests(Guests guests) {
//        this.guests = guests;
//    }

//    public Guests getGuests() {
//        return guests;
//    }
//
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
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

    public String getWalkInGuestId() {
        return walkInGuestId;
    }

    public void setWalkInGuestId(String walkInGuestId) {
        this.walkInGuestId = walkInGuestId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
         
    public GuestMasterServiceChargeController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    GuestMasterBills gmb = new GuestMasterBills(); 
    
    public String saveServiceCharge(){                 
        ServiceCharges sch = new ServiceCharges();
        Guests guests = new Guests(guestEmail);
        Rooms rooms = new Rooms(walkInGuestId);
        
        double serviceCharges = (serviceCharge/100) * subTotal; 
        grandTotal = serviceCharges + subTotal;
       
            sch.setSerChargeId(serChargeId);            
//            sch.setGuests(guests);            
            sch.setEmail(guestEmail);
            sch.setServiceCharge(serviceCharges);
            sch.setSubTotal(subTotal);
            sch.setGrandTotal(grandTotal);                             
            sch.setProductDescription(productDescription);            
            sch.setCreatedDate(createdDate);
                       
            serviceChargeService.createdServiceCharge(sch);
            setFieldToNull();
            mgsError="Service Charge Record Created!!!";
            
             //insert values into Guest_Master_Bill
            gmb.setId(gmbID);
            gmb.setGuests(guests);            
            gmb.setRooms(rooms);
            gmb.setAccountNo(gmbId);
            gmb.setTransactions("Service Charge");
            gmb.setCharge(serviceCharges);
            gmb.setTimes(createdTime);
            gmb.setCreatedDate(createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            serviceChargeService.createdGuestMasterBill(gmb);
                      
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
            audit.setOperation("Create Service Charge with ID "+sch.getSerChargeId()+" amounted to "+ serviceCharge);
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_room_servicecharge";
    }
    
    public String updateServiceCharge(){        
        ServiceCharges sch = new ServiceCharges();
//        guests = new Guests(guestEmail);        
        int mgs = serviceChargeService.checkServiceChargeId(serChargeIds);
        if(mgs ==0){

        serviceCharge = (serviceCharge/100) * subTotal; 
        grandTotal = serviceCharge + subTotal;
           
            sch.setSerChargeId(serChargeIds);            
            sch.setEmail(email);
//            sch.setGuests(guests);            
            sch.setServiceCharge(serviceCharge);
            sch.setSubTotal(subTotal);
            sch.setGrandTotal(grandTotal);            
            sch.setWalkInGuestId(walkInGuestId);            
            sch.setProductDescription(productDescription);            
            sch.setCreatedDate(createdDate);
            
            serviceChargeService.updateServiceCharge(sch);        
            setFieldToNull();            
            mgsError="Service Charge Record Updated !!!";          
            
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
            audit.setOperation("Update Service Charge with ID "+sch.getSerChargeId());
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
            mgsError="Service Charge Record Does Not Exist!!!"; 
        }
        return "hotel_room_servicecharge_edit";
    }
    
    public String deleteServiceCharge(){
        ServiceCharges sch = new ServiceCharges();
//        guests = new Guests(guestEmail);        
        
        int mgs = serviceChargeService.checkServiceChargeId(serChargeIds);
        if(mgs ==0){
                       
            sch.setSerChargeId(serChargeIds);            
//            sch.setGuests(guests);            
            sch.setEmail(email);
            sch.setServiceCharge(serviceCharge);
            sch.setSubTotal(subTotal);
            sch.setGrandTotal(grandTotal);            
            sch.setWalkInGuestId(walkInGuestId);            
            sch.setProductDescription(productDescription);            
            sch.setCreatedDate(createdDate);          
            
            serviceChargeService.deleteServiceCharge(sch);
            setFieldToNull();                        
            mgsError="Service Charge Record Deleted !!!";          
            
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
            audit.setOperation("Delete Service Charge with ID "+sch.getSerChargeId());
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
            mgsError="Service Charge Record Does Not Exist!!!"; 
        }        
        return "hotel_room_servicecharge_edit";
    }

// Method To Fetch All Room status Details From The Database
    public List<ServiceCharges> getServiceChargeDetails() {                        
           ServiceCharges sch = new ServiceCharges();
//           guests = new Guests(guestEmail);
                        
            List<ServiceCharges> serviceChargeList = serviceChargeService.listServiceCharge();
		for(Iterator it = serviceChargeList.iterator();it.hasNext();) {                    
                    sch = (ServiceCharges)it.next();
                            
                    serChargeIds = sch.getSerChargeId();                    
                    serviceCharge = sch.getServiceCharge();
                    subTotal = sch.getSubTotal();
                    grandTotal = sch.getGrandTotal();
                    email = sch.getEmail();
                    walkInGuestId = sch.getWalkInGuestId();
                    productDescription =sch.getProductDescription();
//                    guests = sch.getGuests();                                        
                    createdDate =sch.getCreatedDate();                                
		}               
		return serviceChargeList;
	}
//           
    public List<ServiceCharges> getServiceChargeByEmail() {                            
        ServiceCharges sch = new ServiceCharges();
//        guests = new Guests(guestEmail);

            List<ServiceCharges> serviceList = serviceChargeService.listServiceChargeByEmail(guestEmail);
		for(Iterator it = serviceList.iterator();it.hasNext();) {                    
                    sch = (ServiceCharges)it.next();
                                        
                    serChargeIds = sch.getSerChargeId();                    
                    serviceCharge = sch.getServiceCharge();
                    subTotal = sch.getSubTotal();
                    email = sch.getEmail();
                    walkInGuestId = sch.getWalkInGuestId();
                    productDescription = sch.getProductDescription();
                    grandTotal = sch.getGrandTotal();
//                    guests = sch.getGuests();                                        
                    createdDate =sch.getCreatedDate();                                
                    
		}               
		return serviceList;
	}
    
    	public String getServicCharge() { 
        ServiceCharges sch = new ServiceCharges();
//        guests = new Guests(guestEmail);
                
        List<ServiceCharges> serviceList = serviceChargeService.listServiceChargeById(serChargeIds);                
            int checkServiceChargeId = serviceChargeService.checkServiceChargeId(serChargeIds);                
                if(checkServiceChargeId==0){                   
		for(Iterator it = serviceList.iterator(); it.hasNext();) {                    
                    sch = (ServiceCharges)it.next();                                       
                    
                    serChargeIds = sch.getSerChargeId();                    
                    serviceCharge = sch.getServiceCharge();
                    subTotal = sch.getSubTotal();
                    grandTotal = sch.getGrandTotal();
//                    guests = sch.getGuests();                                        
                    email = sch.getEmail();                    
                    walkInGuestId = sch.getWalkInGuestId();
                    productDescription = sch.getProductDescription();
                    createdDate =sch.getCreatedDate();                                
                                          
		}
                }else if(checkServiceChargeId!=0){
                    setMgsError("Service Charge Record does not Exist!!");                                                          
                }           
		return "hotel_room_servicecharge_edit";
	}
        
    	public String getServicChargeBar() { 
        ServiceCharges sch = new ServiceCharges();
//        guests = new Guests(guestEmail);
                
        List<ServiceCharges> serviceList = serviceChargeService.listServiceChargeById(serChargeIds);                
            int checkServiceChargeId = serviceChargeService.checkServiceChargeId(serChargeIds);                
                if(checkServiceChargeId==0){                   
		for(Iterator it = serviceList.iterator(); it.hasNext();) {                    
                    sch = (ServiceCharges)it.next();                                       
                    
                    serChargeIds = sch.getSerChargeId();                    
                    serviceCharge = sch.getServiceCharge();
                    subTotal = sch.getSubTotal();
                    grandTotal = sch.getGrandTotal();
//                    guests = sch.getGuests();                                        
                    email = sch.getEmail();                    
                    walkInGuestId = sch.getWalkInGuestId();
                    productDescription = sch.getProductDescription();
                    createdDate =sch.getCreatedDate();                                
                                          
		}
                }else if(checkServiceChargeId!=0){
                    setMgsError("Service Charge Record does not Exist!!");                                                          
                }           
		return "hotel_room_servicecharge_edit";
	}
        

    public void setFieldToNull(){          
        this.setSerChargeId("");
        this.setEmail("");        
        this.setGuestEmail("");
        this.setWalkInGuestId("");
        this.setProductDescription("");
        this.setServiceCharge(0.0);
        this.setGrandTotal(0.0);
        this.setSubTotal(0.0);        
    }
}
