package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.Rooms;
import greater.service.GuestMasterBillService;
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

@ManagedBean(name="guestMasterController")
@RequestScoped
public class GuestMasterController implements Serializable {
    
    @ManagedProperty(value="#{guestMasterBillService}")
    
    @Autowired
    GuestMasterBillService guestMasterBillService;

    public GuestMasterBillService getGuestMasterBillService() {
        return guestMasterBillService;
    }

    public void setGuestMasterBillService(GuestMasterBillService guestMasterBillService) {
        this.guestMasterBillService = guestMasterBillService;
    }
    
     private String id = new SimpleDateFormat("yyyyss").format(new Date());
     private String gmbID = "GMB"+id;
     private String gmbId;
     private Guests guests;
     private Rooms rooms;
     private String accountNo;
     private String transactions;
     private Double charge=0.0;
     private Double credit=0.0;
     private String checkedOutOn;
     private String checkedOutBy;
     private String times =  new SimpleDateFormat("HH:mm:ss").format(new Date());
     private String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());     
     private String mgsError;
          
     //variables for storing combox value
     private String guestEmail; //primary key on the table
     private String roomID; //primary key on the table
     
     //creating variables for storing the value of parent table      
     private String guestName;      
     private String guestCompanyName;
     private String guestAddress;
     private String guestBillTo;     
     private Integer roomNo;
     private String roomArrival;
     private String roomDepature;
     private String roomCheckInTime;
     private String roomCheckOutTime;     
     //end here
     
     private String startDate;
     private String endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGmbID() {
        return gmbID;
    }

    public void setGmbID(String gmbID) {
        this.gmbID = gmbID;
    }

    public String getGmbId() {
        return gmbId;
    }

    public void setGmbId(String gmbId) {
        this.gmbId = gmbId;
    }
    
    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getCheckedOutOn() {
        return checkedOutOn;
    }

    public void setCheckedOutOn(String checkedOutOn) {
        this.checkedOutOn = checkedOutOn;
    }

    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setCheckedOutBy(String checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
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

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public String getGuestBillTo() {
        return guestBillTo;
    }

    public void setGuestBillTo(String guestBillTo) {
        this.guestBillTo = guestBillTo;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomArrival() {
        return roomArrival;
    }

    public void setRoomArrival(String roomArrival) {
        this.roomArrival = roomArrival;
    }

    public String getRoomDepature() {
        return roomDepature;
    }

    public void setRoomDepature(String roomDepature) {
        this.roomDepature = roomDepature;
    }

    public String getRoomCheckInTime() {
        return roomCheckInTime;
    }

    public void setRoomCheckInTime(String roomCheckInTime) {
        this.roomCheckInTime = roomCheckInTime;
    }

    public String getRoomCheckOutTime() {
        return roomCheckOutTime;
    }

    public void setRoomCheckOutTime(String roomCheckOutTime) {
        this.roomCheckOutTime = roomCheckOutTime;
    }
     
    public GuestMasterController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    
    public String saveGuestMaster(){                 
        GuestMasterBills gmb = new GuestMasterBills();        
        guests = new Guests(guestEmail);        
        rooms = new Rooms(roomID); 
        
        try{
        
        gmb.setId(gmbID);
        gmb.setGuests(guests);
        gmb.setRooms(rooms);
        gmb.setAccountNo(id);
        gmb.setTransactions(transactions);
        gmb.setCharge(charge);
        gmb.setCredit(credit);
        gmb.setCheckedOutOn(checkedOutOn);
        gmb.setCheckedOutBy(checkedOutBy);
        gmb.setTimes(times);
        gmb.setCreatedDate(createdDate);            
                       
        guestMasterBillService.createdGuestMasterBill(gmb);
        setFieldToNull();
        mgsError="Guest Master Bill Record Created!!!";          
                                
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
        audit.setOperation("Create Guest Master Bill with ID "+gmb.getId());
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

        return "hotel_gmb";
    }
    
    public String updateGuestMaster(){                
        GuestMasterBills gmb = new GuestMasterBills();        
        guests = new Guests(guestEmail);        
        rooms = new Rooms(roomID); 
        
        int mgs = guestMasterBillService.checkGuestMasterBillByID(gmbId);
        if(mgs ==0){
            
        gmb.setId(gmbId);
        gmb.setGuests(guests);
        gmb.setRooms(rooms);
        gmb.setAccountNo(id);
        gmb.setTransactions(transactions);
        gmb.setCharge(charge);
        gmb.setCredit(credit);
        gmb.setCheckedOutOn(checkedOutOn);
        gmb.setCheckedOutBy(checkedOutBy);
        gmb.setTimes(times);
        gmb.setCreatedDate(createdDate);            
                       
        guestMasterBillService.updateGuestMasterBill(gmb);
        setFieldToNull();
        mgsError="Guest Master Bill Record Update!!!";                      
            
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
        audit.setOperation("Update Guest Master Bill with ID "+gmb.getId());
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
            mgsError="Guest Master Bill Record Does Not Exist!!!"; 
        }
        return "hotel_gmb_edit";
    }
    
    public String deleteGuestMaster(){
        GuestMasterBills gmb = new GuestMasterBills();        
        guests = new Guests(guestEmail);        
        rooms = new Rooms(roomID); 
                        
        int mgs = guestMasterBillService.checkGuestMasterBillByID(gmbId);
        if(mgs ==0){
                       
        gmb.setId(gmbId);
        gmb.setGuests(guests);
        gmb.setRooms(rooms);
        gmb.setAccountNo(id);
        gmb.setTransactions(transactions);
        gmb.setCharge(charge);
        gmb.setCredit(credit);
        gmb.setCheckedOutOn(checkedOutOn);
        gmb.setCheckedOutBy(checkedOutBy);
        gmb.setTimes(times);
        gmb.setCreatedDate(createdDate);            
                       
        guestMasterBillService.deleteGuestMasterBill(gmb);        
        setFieldToNull();
        mgsError="Guest Master Bill Record Deleted!!!";                      
            
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
            audit.setOperation("Delete Guest Master Bill ID "+gmb.getId());
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
            mgsError="Guest Master Bill Record Does Not Exist!!!"; 
        }
        
        return "hotel_gmb_edit";
    }
    
    // Method To Fetch Particular GuestMaster Details From The Database
	public String getGuestMasterDetailsByID() { 
        GuestMasterBills gmb = new GuestMasterBills();
        
        guests = new Guests(guestEmail);        
        rooms = new Rooms(roomID);        
        
       try{                                 
        List<GuestMasterBills> gmbList = guestMasterBillService.listGuestMasterBillByID(gmbId);
                
            int checkGmbId = guestMasterBillService.checkGuestMasterBillByID(gmbId);                
                if(checkGmbId==0){                   
		for(Iterator it = gmbList.iterator(); it.hasNext();) {                    
                    gmb = (GuestMasterBills)it.next();                                       

                    gmbId = gmb.getId();
                    guestEmail = gmb.getGuests().getEmail().trim(); 
                    guestName = gmb.getGuests().getFirstName() +" "+ gmb.getGuests().getLastName();
                    guestCompanyName = gmb.getGuests().getCompanyName();
                    guestAddress = gmb.getGuests().getAddress();
                    guestBillTo = gmb.getGuests().getGuestType();                    
                    accountNo = gmb.getAccountNo();
                    transactions = gmb.getTransactions();
                    charge = gmb.getCharge();
                    credit = gmb.getCredit();
                    checkedOutOn = gmb.getCheckedOutOn();
                    checkedOutBy = gmb.getCheckedOutBy();                    
                    times = gmb.getTimes();
                    createdDate = gmb.getCreatedDate();
                    roomID = gmb.getRooms().getRoomId().trim();
                    roomNo = gmb.getRooms().getRoomNo();
                    roomArrival = gmb.getRooms().getArrivalDate();
                    roomDepature = gmb.getRooms().getDepartureDate();
                    roomCheckInTime = gmb.getRooms().getTimeCheckIn();
                    roomCheckOutTime = gmb.getRooms().getTimeCheckOut();                    
                    
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
                    audit.setOperation("Select Guest Master Bill with ID "+gmb.getId());
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
                }else if(checkGmbId!=0){
                    setMgsError("Guest Master Bill Record does not Exist!!");                                                          
                } 
       }catch(Exception ex){
           ex.printStackTrace();
       }
	    return "hotel_gmb_edit";
   }
    
    public List<GuestMasterBills> getGuestMasterBillByEmailID() { 
        GuestMasterBills gmb = new GuestMasterBills();
        
        guests = new Guests(guestEmail);        
        rooms = new Rooms(roomID); 
                                        
        List<GuestMasterBills> gmbList = guestMasterBillService.listGuestMasterBillByEmail(guestEmail, startDate, endDate);
                
            int checkGuestMasterId = guestMasterBillService.checkGuestMasterBillByEmail(guestEmail);                
                if(checkGuestMasterId==0){                   
		for(Iterator it = gmbList.iterator(); it.hasNext();) {                    
                    gmb = (GuestMasterBills)it.next();                                       

                    gmbId = gmb.getId();
                    guestEmail = gmb.getGuests().getEmail().trim(); 
                    guestName = gmb.getGuests().getFirstName() +" "+ gmb.getGuests().getLastName();
                    guestCompanyName = gmb.getGuests().getCompanyName();
                    guestAddress = gmb.getGuests().getAddress();
                    guestBillTo = gmb.getGuests().getGuestType();                    
                    accountNo = gmb.getAccountNo();
                    transactions = gmb.getTransactions();
                    charge = gmb.getCharge();
                    credit = gmb.getCredit();
                    checkedOutOn = gmb.getCheckedOutOn();
                    checkedOutBy = gmb.getCheckedOutBy();                    
                    times = gmb.getTimes();
                    createdDate = gmb.getCreatedDate();
                    roomID = gmb.getRooms().getRoomId().trim();
                    roomNo = gmb.getRooms().getRoomNo();
                    roomArrival = gmb.getRooms().getArrivalDate();
                    roomDepature = gmb.getRooms().getDepartureDate();
                    roomCheckInTime = gmb.getRooms().getTimeCheckIn();
                    roomCheckOutTime = gmb.getRooms().getTimeCheckOut();                    
		}
                }else if(checkGuestMasterId!=0){
                    setMgsError("Guest Master Bill Record does not Exist!!");                                                          
                }           
		return gmbList;
	}
    
    // Method To Fetch All Guest Master Bill Details From The Database
    public List<GuestMasterBills> getGuestMasterDetails() {            
            GuestMasterBills gmb = new GuestMasterBills();
                        
            List<GuestMasterBills> gmbList = guestMasterBillService.listGuestMasterBill();
		for(Iterator it = gmbList.iterator();it.hasNext();) {                    
                    gmb = (GuestMasterBills)it.next();
                    
                    gmbId = gmb.getId();
                    gmbId = gmb.getId();
                    guestEmail = gmb.getGuests().getEmail().trim(); 
                    guestName = gmb.getGuests().getFirstName() +" "+ gmb.getGuests().getLastName();
                    guestCompanyName = gmb.getGuests().getCompanyName();
                    guestAddress = gmb.getGuests().getAddress();
                    guestBillTo = gmb.getGuests().getGuestType();                    
                    accountNo = gmb.getAccountNo();
                    transactions = gmb.getTransactions();
                    charge = gmb.getCharge();
                    credit = gmb.getCredit();
                    checkedOutOn = gmb.getCheckedOutOn();
                    checkedOutBy = gmb.getCheckedOutBy();                    
                    times = gmb.getTimes();
                    createdDate = gmb.getCreatedDate();
                    roomID = gmb.getRooms().getRoomId().trim();
                    roomNo = gmb.getRooms().getRoomNo();
                    roomArrival = gmb.getRooms().getArrivalDate();
                    roomDepature = gmb.getRooms().getDepartureDate();
                    roomCheckInTime = gmb.getRooms().getTimeCheckIn();
                    roomCheckOutTime = gmb.getRooms().getTimeCheckOut();                    
                    
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
		}               
		return gmbList;
	}
    
    // Method To Fetch Particular Restaurant Details From The Database
	public String getGuestMasterBillByID() { 
        GuestMasterBills gmb = new GuestMasterBills();
        
        guests = new Guests(guestEmail);        
        rooms = new Rooms(roomID); 
        try{
                                                
        List<GuestMasterBills> gmbList = guestMasterBillService.listGuestMasterBillByEmail(guestEmail, startDate, endDate);
                
            int checkGuestMasterId = guestMasterBillService.checkGuestMasterBillByEmail(guestEmail);
                if(checkGuestMasterId==0){                   
		for(Iterator it = gmbList.iterator(); it.hasNext();) {                    
                    gmb = (GuestMasterBills)it.next();                                       

                    gmbId = gmb.getId();
                    guestEmail = gmb.getGuests().getEmail().trim(); 
                    guestName = gmb.getGuests().getFirstName() +" "+ gmb.getGuests().getLastName();
                    guestCompanyName = gmb.getGuests().getCompanyName();
                    guestAddress = gmb.getGuests().getAddress();
                    guestBillTo = gmb.getGuests().getGuestType();                    
                    accountNo = gmb.getAccountNo();
                    transactions = gmb.getTransactions();
                    charge = gmb.getCharge();
                    credit = gmb.getCredit();
                    checkedOutOn = gmb.getCheckedOutOn();
                    checkedOutBy = gmb.getCheckedOutBy();                    
                    times = gmb.getTimes();
                    createdDate = gmb.getCreatedDate();
                    roomID = gmb.getRooms().getRoomId().trim();
                    roomNo = gmb.getRooms().getRoomNo();
                    roomArrival = gmb.getRooms().getArrivalDate();
                    roomDepature = gmb.getRooms().getDepartureDate();
                    roomCheckInTime = gmb.getRooms().getTimeCheckIn();
                    roomCheckOutTime = gmb.getRooms().getTimeCheckOut();                                                
		}
                }else if(checkGuestMasterId!=0){
                    setMgsError("Guest Master Bill Record does not Exist!!");                                                          
                }           
             }catch(Exception ex){
            ex.printStackTrace();
        }
		return "hotel_gmb_bill";
	}
    
    public List<GuestMasterBills> getSumCharge(){ 
        List<GuestMasterBills> sumCharge = guestMasterBillService.listGuestMasterBillSumCharge(guestEmail, startDate, endDate);
         return sumCharge;
    }
    
    public List<GuestMasterBills> getSumCredit(){ 
        List<GuestMasterBills> sumCredit = guestMasterBillService.listGuestMasterBillSumCredit(guestEmail, startDate, endDate);
         return sumCredit;
    }
    
    public List<GuestMasterBills> getSubtractChargesFromCredit(){ 
        List<GuestMasterBills> subtract = guestMasterBillService.listGuestMasterBillSubtractChargeFromCredit(guestEmail, startDate, endDate);
         return subtract;
    }    
        
    public void setFieldToNull(){                        
        this.setId("");
        this.setGuests(null);
        this.setRooms(null);
        this.setRoomID("");
        this.setGuestEmail("");        
        this.setAccountNo("");
        this.setTransactions("");
        this.setCharge(0.0);
        this.setCheckedOutBy("");
        this.setCheckedOutOn("");
        this.setCredit(0.0);        
        this.setTimes("");
        this.setCreatedDate("");
        this.setStartDate("");
        this.setEndDate("");
        this.setMgsError("");
        this.setGmbID("");
        
    }
    
}
