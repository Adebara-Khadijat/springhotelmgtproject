package greater.pojo;
// Generated Mar 23, 2019 12:04:22 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Rooms generated by hbm2java
 */
public class Rooms  implements java.io.Serializable {


     private String roomId;
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
     private String authorizedDiscount;
     private String approvedDiscount;
     private String createdDate;
     private Set guestMasterBillses = new HashSet(0);

    public Rooms() {
    }

	
    public Rooms(String roomId) {
        this.roomId = roomId;
    }
    public Rooms(String roomId, Guests guests, Integer roomNo, String roomType, Double roomRate, Double chargeRate, Double discountedRate, Integer noOfNight, Double vat5, Double conTax5, Double deposite, Double balance, Integer noOfGuestInRoom, Integer noOfLuggage, String reasonForLodging, String arrivalDate, String departureDate, String timeCheckIn, String timeCheckOut, String authorizedDiscount, String approvedDiscount, String createdDate, Set guestMasterBillses) {
       this.roomId = roomId;
       this.guests = guests;
       this.roomNo = roomNo;
       this.roomType = roomType;
       this.roomRate = roomRate;
       this.chargeRate = chargeRate;
       this.discountedRate = discountedRate;
       this.noOfNight = noOfNight;
       this.vat5 = vat5;
       this.conTax5 = conTax5;
       this.deposite = deposite;
       this.balance = balance;
       this.noOfGuestInRoom = noOfGuestInRoom;
       this.noOfLuggage = noOfLuggage;
       this.reasonForLodging = reasonForLodging;
       this.arrivalDate = arrivalDate;
       this.departureDate = departureDate;
       this.timeCheckIn = timeCheckIn;
       this.timeCheckOut = timeCheckOut;
       this.authorizedDiscount = authorizedDiscount;
       this.approvedDiscount = approvedDiscount;
       this.createdDate = createdDate;
       this.guestMasterBillses = guestMasterBillses;
    }
   
    public String getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public Guests getGuests() {
        return this.guests;
    }
    
    public void setGuests(Guests guests) {
        this.guests = guests;
    }
    public Integer getRoomNo() {
        return this.roomNo;
    }
    
    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }
    public String getRoomType() {
        return this.roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public Double getRoomRate() {
        return this.roomRate;
    }
    
    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }
    public Double getChargeRate() {
        return this.chargeRate;
    }
    
    public void setChargeRate(Double chargeRate) {
        this.chargeRate = chargeRate;
    }
    public Double getDiscountedRate() {
        return this.discountedRate;
    }
    
    public void setDiscountedRate(Double discountedRate) {
        this.discountedRate = discountedRate;
    }
    public Integer getNoOfNight() {
        return this.noOfNight;
    }
    
    public void setNoOfNight(Integer noOfNight) {
        this.noOfNight = noOfNight;
    }
    public Double getVat5() {
        return this.vat5;
    }
    
    public void setVat5(Double vat5) {
        this.vat5 = vat5;
    }
    public Double getConTax5() {
        return this.conTax5;
    }
    
    public void setConTax5(Double conTax5) {
        this.conTax5 = conTax5;
    }
    public Double getDeposite() {
        return this.deposite;
    }
    
    public void setDeposite(Double deposite) {
        this.deposite = deposite;
    }
    public Double getBalance() {
        return this.balance;
    }
    
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Integer getNoOfGuestInRoom() {
        return this.noOfGuestInRoom;
    }
    
    public void setNoOfGuestInRoom(Integer noOfGuestInRoom) {
        this.noOfGuestInRoom = noOfGuestInRoom;
    }
    public Integer getNoOfLuggage() {
        return this.noOfLuggage;
    }
    
    public void setNoOfLuggage(Integer noOfLuggage) {
        this.noOfLuggage = noOfLuggage;
    }
    public String getReasonForLodging() {
        return this.reasonForLodging;
    }
    
    public void setReasonForLodging(String reasonForLodging) {
        this.reasonForLodging = reasonForLodging;
    }
    public String getArrivalDate() {
        return this.arrivalDate;
    }
    
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public String getDepartureDate() {
        return this.departureDate;
    }
    
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public String getTimeCheckIn() {
        return this.timeCheckIn;
    }
    
    public void setTimeCheckIn(String timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }
    public String getTimeCheckOut() {
        return this.timeCheckOut;
    }
    
    public void setTimeCheckOut(String timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }
    public String getAuthorizedDiscount() {
        return this.authorizedDiscount;
    }
    
    public void setAuthorizedDiscount(String authorizedDiscount) {
        this.authorizedDiscount = authorizedDiscount;
    }
    public String getApprovedDiscount() {
        return this.approvedDiscount;
    }
    
    public void setApprovedDiscount(String approvedDiscount) {
        this.approvedDiscount = approvedDiscount;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public Set getGuestMasterBillses() {
        return this.guestMasterBillses;
    }
    
    public void setGuestMasterBillses(Set guestMasterBillses) {
        this.guestMasterBillses = guestMasterBillses;
    }




}


