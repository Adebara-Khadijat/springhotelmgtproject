package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.Rooms;
import greater.service.RoomService;
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

@ManagedBean(name="roomController")
@RequestScoped
public class RoomController implements Serializable {
    
     @ManagedProperty(value="#{roomService}") //injecting Service Class Interface into ManagedBean      

    @Autowired
    RoomService roomService;

    public RoomService getRoomService() {
        return roomService;
    }

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
   
     private String roomId = new SimpleDateFormat("yyyyMMddss").format(new Date());     
     private String roomID = "RM"+roomId;
     private String roomIds;
     private Guests guests;
     private Integer roomNo;
     private String roomType;
     private Double roomRate;
     private Double chargeRate;
     private Double discountedRate;
     private Integer noOfNight;
     private Double vat5;
     private Double conTax5;
     private Double deposite;
     private Double balance;
     private Integer noOfGuestInRoom;
     private Integer noOfLuggage;
     private String reasonForLodging;
     private String arrivalDate;
     private String departureDate;
     private String timeCheckIn;
     private String timeCheckOut;
     private String createdDate=  new SimpleDateFormat("yyyy-MM-dd").format(new Date());          
     private String mgsError;
     
     //variables for Guest Master Bill 
     private String gmbId = new SimpleDateFormat("yyyyss").format(new Date());     
     private String gmbID = "GMB"+gmbId;
     private String createdTime =  new SimpleDateFormat("HH:mm:ss").format(new Date()); 
     
    private String guestString; //= "brand1"; //it is use to store the value selected from comboBox

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
    
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(String roomIds) {
        this.roomIds = roomIds;
    }        
    
    public String getGuestString() {
        return guestString;
    }

    public void setGuestString(String guestString) {
        this.guestString = guestString;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public Double getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(Double chargeRate) {
        this.chargeRate = chargeRate;
    }

    public Double getDiscountedRate() {
        return discountedRate;
    }

    public void setDiscountedRate(Double discountedRate) {
        this.discountedRate = discountedRate;
    }
        
    public Integer getNoOfNight() {
        return noOfNight;
    }

    public void setNoOfNight(Integer noOfNight) {
        this.noOfNight = noOfNight;
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

    public Double getDeposite() {
        return deposite;
    }

    public void setDeposite(Double deposite) {
        this.deposite = deposite;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getNoOfGuestInRoom() {
        return noOfGuestInRoom;
    }

    public void setNoOfGuestInRoom(Integer noOfGuestInRoom) {
        this.noOfGuestInRoom = noOfGuestInRoom;
    }

    public Integer getNoOfLuggage() {
        return noOfLuggage;
    }

    public void setNoOfLuggage(Integer noOfLuggage) {
        this.noOfLuggage = noOfLuggage;
    }

    public String getReasonForLodging() {
        return reasonForLodging;
    }

    public void setReasonForLodging(String reasonForLodging) {
        this.reasonForLodging = reasonForLodging;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getTimeCheckIn() {
        return timeCheckIn;
    }

    public void setTimeCheckIn(String timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }

    public String getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setTimeCheckOut(String timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
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
     
    public RoomController() {
    }   
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins(); 
    GuestMasterBills gmb = new GuestMasterBills();    
      
    public String saveRoom(){                 
        Rooms r = new Rooms();
        Guests guests = new Guests(guestString);
        try{
           vat5 = 0.05 * chargeRate * noOfNight;
           conTax5 = 0.05 * chargeRate * noOfNight;
           double chargeRates = chargeRate * noOfNight;

            r.setGuests(guests);
            r.setRoomId(roomID);
            r.setRoomNo(roomNo);
            r.setRoomType(roomType);
            r.setRoomRate(roomRate);
            r.setChargeRate(chargeRates);
            r.setDiscountedRate(discountedRate);
            r.setNoOfNight(noOfNight);
            r.setVat5(vat5);
            r.setConTax5(conTax5);
            r.setDeposite(deposite);
            r.setBalance(balance);
            r.setNoOfGuestInRoom(noOfGuestInRoom);
            r.setNoOfLuggage(noOfLuggage);
            r.setReasonForLodging(reasonForLodging);
            r.setArrivalDate(arrivalDate);
            r.setDepartureDate(departureDate);
            r.setTimeCheckIn(timeCheckIn);
            r.setTimeCheckOut(timeCheckOut);
            r.setCreatedDate(createdDate);
            
            roomService.createdRoom(r);
            setFieldToNull();
            mgsError="Room Record Created!!!";
            
            Rooms rm = new Rooms();
            rm.setRoomId(roomID);                        
            gmb.setId(gmbID);
            gmb.setGuests(guests);
            gmb.setRooms(rm);
            gmb.setAccountNo(gmbId);
            gmb.setTransactions("Accommodation");
            gmb.setCharge(chargeRates);
            gmb.setTimes(createdTime);
            gmb.setCreatedDate(createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            roomService.createdGuestMasterBill(gmb);
        
          }catch(Exception ex){ex.printStackTrace();}
        
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
            audit.setOperation("Create Room with Room ID "+r.getRoomId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
            
        return "hotel_room";
    }        
    
    public String updateRoom(){
        
        Guests g = new Guests();
        Guests guests = new Guests(guestString);
        Rooms r = new Rooms();
        
        int mgs = roomService.checkRoomId(roomIds);
        if(mgs ==0){
            
           vat5 = 0.05 * chargeRate * noOfNight;
           conTax5 = 0.05 * chargeRate * noOfNight;
           double chargeRates = chargeRate * noOfNight;

            r.setRoomId(roomIds);
            r.setRoomNo(roomNo);
            r.setRoomType(roomType);
            r.setRoomRate(roomRate);
            r.setChargeRate(chargeRates);
            r.setDiscountedRate(discountedRate);
            r.setNoOfNight(noOfNight);
            r.setVat5(vat5);
            r.setConTax5(conTax5);
            r.setDeposite(deposite);
            r.setBalance(balance);
            r.setNoOfGuestInRoom(noOfGuestInRoom);
            r.setNoOfLuggage(noOfLuggage);
            r.setGuests(guests);
            r.setReasonForLodging(reasonForLodging);
            r.setArrivalDate(arrivalDate);
            r.setDepartureDate(departureDate);
            r.setTimeCheckIn(timeCheckIn);
            r.setTimeCheckOut(timeCheckOut);
            r.setCreatedDate(createdDate);
            
            roomService.updateRoom(r);
            setFieldToNull();            
            mgsError="Room Record Updated !!!";                                  
            
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
            audit.setOperation("Update Room with Room ID "+r.getRoomId());
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
            mgsError="Room Record Does Not Exist!!!"; 
        }
        return "hotel_room_edit";
    }
    
    // Method To Fetch Particular Room Details From The Database
	public String getRoomDetailsByID() { 
            Rooms r = new Rooms();   
                        
            List<Rooms> roomList = roomService.listRoomByID(roomIds);
                
            int checkRoomId = roomService.checkRoomId(roomIds);                
                if(checkRoomId==0){                   
		for(Iterator it = roomList.iterator(); it.hasNext();) {                    
                    r = (Rooms)it.next();                                       

                    guestString = r.getGuests().getEmail();
                    roomID = r.getRoomId();
                    roomNo = r.getRoomNo();
                    roomType = r.getRoomType();
                    roomRate = r.getRoomRate();
                    chargeRate = r.getChargeRate();
                    discountedRate = r.getDiscountedRate();
                    noOfNight = r.getNoOfNight();            
                    vat5 = r.getVat5();    
                    conTax5 = r.getConTax5();            
                    deposite = r.getDeposite();            
                    balance = r.getBalance();
                    noOfGuestInRoom = r.getNoOfGuestInRoom();
                    noOfLuggage = r.getNoOfLuggage();     
                    reasonForLodging = r.getReasonForLodging();  
                    arrivalDate = r.getArrivalDate();
                    departureDate = r.getDepartureDate();
                    timeCheckIn=r.getTimeCheckIn();
                    timeCheckOut=r.getTimeCheckOut();
                    createdDate = r.getCreatedDate();            
                    
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
                    audit.setOperation("Select Room with Room ID "+r.getRoomId());
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
                }else if(checkRoomId!=0){
                    setMgsError("Room Record does not Exist!!");                                                          
                }           
		return "hotel_room_edit";
	}
        
        // Method To Fetch Particular Room Details From The Database
	public String getRoomProfileByID() { 
            Rooms r = new Rooms();   
                        
            List<Rooms> roomList = roomService.listRoomByID(roomIds);
                
            int checkRoomId = roomService.checkRoomId(roomIds);                
                if(checkRoomId==0){                   
		for(Iterator it = roomList.iterator(); it.hasNext();) {                    
                    r = (Rooms)it.next();                                       

                    guestString = r.getGuests().getEmail();
                    roomIds = r.getRoomId();
                    roomNo = r.getRoomNo();
                    roomType = r.getRoomType();
                    roomRate = r.getRoomRate();
                    chargeRate = r.getChargeRate();
                    discountedRate = r.getDiscountedRate();
                    noOfNight = r.getNoOfNight();            
                    vat5 = r.getVat5();    
                    conTax5 = r.getConTax5();            
                    deposite = r.getDeposite();            
                    balance = r.getBalance();
                    noOfGuestInRoom = r.getNoOfGuestInRoom();
                    noOfLuggage = r.getNoOfLuggage();     
                    reasonForLodging = r.getReasonForLodging();  
                    arrivalDate = r.getArrivalDate();
                    departureDate = r.getDepartureDate();
                    timeCheckIn=r.getTimeCheckIn();
                    timeCheckOut=r.getTimeCheckOut();
                    createdDate = r.getCreatedDate();            
                    
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
                    audit.setOperation("Select Room  Profile with Room ID "+r.getRoomId());
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
                }else if(checkRoomId!=0){
                    setMgsError("Room Record does not Exist!!");                                                          
                }           
		return "hotel_room_profile";
	}
        
    public String deleteRoom(){
        Rooms r = new Rooms();
                
        int mgs = roomService.checkRoomId(roomIds);    
        if(mgs ==0){
            
            r.setRoomId(roomIds);
            r.setRoomNo(roomNo);
            r.setRoomType(roomType);
            r.setRoomRate(roomRate);
            r.setChargeRate(chargeRate);
            r.setDiscountedRate(discountedRate);
            r.setNoOfNight(noOfNight);
            r.setVat5(vat5);
            r.setConTax5(conTax5);
            r.setDeposite(deposite);
            r.setBalance(balance);
            r.setNoOfGuestInRoom(noOfGuestInRoom);
            r.setNoOfLuggage(noOfLuggage);
            r.setGuests(guests);
            r.setReasonForLodging(reasonForLodging);
            r.setArrivalDate(arrivalDate);
            r.setDepartureDate(departureDate);
            r.setTimeCheckIn(timeCheckIn);
            r.setTimeCheckOut(timeCheckOut);
            r.setCreatedDate(createdDate);
            
            roomService.deleteRoom(r);
            setFieldToNull();                        
            mgsError="Room Record Deleted !!!";          
            
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
            audit.setOperation("Delete Room with Room ID "+r.getRoomId());
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
            mgsError="Room Record Does Not Exist!!!"; 
        }
        
        return "hotel_room_edit";
    }

   // Method To Fetch All Room Details From The Database
    public List<Rooms> getRoomDetails() {            
            Rooms r = new Rooms();
                        
            List<Rooms> roomList = roomService.listRoom();
		for(Iterator it = roomList.iterator();it.hasNext();) {                    
                    r = (Rooms)it.next();
                                        
                    roomIds = r.getRoomId();                    
                    guests =r.getGuests();
                    roomNo = r.getRoomNo();
                    roomType = r.getRoomType();
                    roomRate = r.getRoomRate();
                    chargeRate = r.getChargeRate();
                    discountedRate = r.getDiscountedRate();
                    noOfNight = r.getNoOfNight();            
                    vat5 = r.getVat5();    
                    conTax5 = r.getConTax5();            
                    deposite = r.getDeposite();            
                    balance = r.getBalance();
                    noOfGuestInRoom = r.getNoOfGuestInRoom();
                    noOfLuggage = r.getNoOfLuggage();     
                    reasonForLodging = r.getReasonForLodging();  
                    arrivalDate = r.getArrivalDate();
                    departureDate = r.getDepartureDate();
                    timeCheckIn=r.getTimeCheckIn();
                    timeCheckOut=r.getTimeCheckOut();
                    createdDate = r.getCreatedDate();        
                    
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
                    audit.setOperation("View All Rooms");
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
		return roomList;
	}
    
    
    // Method To Fetch All Room Currently in Use From The Database
    public List<Rooms> getRoomCurrentlyInUse() {            
            Rooms r = new Rooms();
                        
            List<Rooms> roomList = roomService.listRoomCurrentlyInUse();
		for(Iterator it = roomList.iterator();it.hasNext();) {                    
                    r = (Rooms)it.next();
                                        
                    roomIds = r.getRoomId();                    
                    guests =r.getGuests();
                    roomNo = r.getRoomNo();
                    roomType = r.getRoomType();
                    roomRate = r.getRoomRate();
                    chargeRate = r.getChargeRate();
                    discountedRate = r.getDiscountedRate();
                    noOfNight = r.getNoOfNight();            
                    vat5 = r.getVat5();    
                    conTax5 = r.getConTax5();            
                    deposite = r.getDeposite();            
                    balance = r.getBalance();
                    noOfGuestInRoom = r.getNoOfGuestInRoom();
                    noOfLuggage = r.getNoOfLuggage();     
                    reasonForLodging = r.getReasonForLodging();  
                    arrivalDate = r.getArrivalDate();
                    departureDate = r.getDepartureDate();
                    timeCheckIn=r.getTimeCheckIn();
                    timeCheckOut=r.getTimeCheckOut();
                    createdDate = r.getCreatedDate();        
                    
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
                    audit.setOperation("View Rooms Currently In Use");
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
		return roomList;
	}
    
        // Method To Fetch All Room History From The Database
	public List<Rooms> getRoomHistory() {            
            Rooms r = new Rooms();
                        
            List<Rooms> roomList = roomService.listRoomHistory();
		for(Iterator it = roomList.iterator();it.hasNext();) {                    
                    r = (Rooms)it.next();
                                        
                    roomIds = r.getRoomId();                    
                    guests =r.getGuests();
                    roomNo = r.getRoomNo();
                    roomType = r.getRoomType();
                    roomRate = r.getRoomRate();
                    chargeRate = r.getChargeRate();
                    discountedRate = r.getDiscountedRate();
                    noOfNight = r.getNoOfNight();            
                    vat5 = r.getVat5();    
                    conTax5 = r.getConTax5();            
                    deposite = r.getDeposite();            
                    balance = r.getBalance();
                    noOfGuestInRoom = r.getNoOfGuestInRoom();
                    noOfLuggage = r.getNoOfLuggage();     
                    reasonForLodging = r.getReasonForLodging();  
                    arrivalDate = r.getArrivalDate();
                    departureDate = r.getDepartureDate();
                    timeCheckIn=r.getTimeCheckIn();
                    timeCheckOut=r.getTimeCheckOut();
                    createdDate = r.getCreatedDate();        
                    
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
                    audit.setOperation("View Rooms History");
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
		return roomList;
	}
    
    
    public void setFieldToNull(){
        
        this.setGuestString("");
        this.setRoomIds("");
        this.setRoomNo(0);
        this.setRoomType("");
        this.setRoomRate(0.0);
        this.setChargeRate(0.0);
        this.setNoOfNight(0);            
        this.setDeposite(0.0);
        this.setDiscountedRate(0.0);
        this.setBalance(0.0);
        this.setNoOfGuestInRoom(0);            
        this.setNoOfLuggage(0);
        this.setReasonForLodging("");            
        this.setArrivalDate("");
        this.setDepartureDate("");
        this.setTimeCheckIn("");
        this.setTimeCheckOut("");
    }
    
}
