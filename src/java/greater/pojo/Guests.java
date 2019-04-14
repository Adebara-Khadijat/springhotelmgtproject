package greater.pojo;
// Generated Mar 23, 2019 12:04:22 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Guests generated by hbm2java
 */
public class Guests  implements java.io.Serializable {


     private String email;
     private String title;
     private String firstName;
     private String lastName;
     private String address;
     private String dateOfBirth;
     private String sex;
     private String phone;
     private String occupation;
     private String guestType;
     private String companyName;
     private String nationality;
     private String passportNo;
     private String residentPermitNo;
     private String nextOfKinName;
     private String nextOfKinAddress;
     private String nextOfKinphone;
     private String arrivalDate;
     private String departureDate;
     private String timeCheckIn;
     private String timeCheckOut;
     private String receptionistOnDuty;
     private String createdDate;
     private Set restaurantses = new HashSet(0);
     private Set guestMasterBillses = new HashSet(0);
     private Set roomses = new HashSet(0);
     private Set barses = new HashSet(0);

    public Guests() {
    }

	
    public Guests(String email) {
        this.email = email;
    }
    public Guests(String email, String title, String firstName, String lastName, String address, String dateOfBirth, String sex, String phone, String occupation, String guestType, String companyName, String nationality, String passportNo, String residentPermitNo, String nextOfKinName, String nextOfKinAddress, String nextOfKinphone, String arrivalDate, String departureDate, String timeCheckIn, String timeCheckOut, String receptionistOnDuty, String createdDate, Set restaurantses, Set guestMasterBillses, Set roomses, Set barses) {
       this.email = email;
       this.title = title;
       this.firstName = firstName;
       this.lastName = lastName;
       this.address = address;
       this.dateOfBirth = dateOfBirth;
       this.sex = sex;
       this.phone = phone;
       this.occupation = occupation;
       this.guestType = guestType;
       this.companyName = companyName;
       this.nationality = nationality;
       this.passportNo = passportNo;
       this.residentPermitNo = residentPermitNo;
       this.nextOfKinName = nextOfKinName;
       this.nextOfKinAddress = nextOfKinAddress;
       this.nextOfKinphone = nextOfKinphone;
       this.arrivalDate = arrivalDate;
       this.departureDate = departureDate;
       this.timeCheckIn = timeCheckIn;
       this.timeCheckOut = timeCheckOut;
       this.receptionistOnDuty = receptionistOnDuty;
       this.createdDate = createdDate;
       this.restaurantses = restaurantses;
       this.guestMasterBillses = guestMasterBillses;
       this.roomses = roomses;
       this.barses = barses;
    }
   
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getOccupation() {
        return this.occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getGuestType() {
        return this.guestType;
    }
    
    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPassportNo() {
        return this.passportNo;
    }
    
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
    public String getResidentPermitNo() {
        return this.residentPermitNo;
    }
    
    public void setResidentPermitNo(String residentPermitNo) {
        this.residentPermitNo = residentPermitNo;
    }
    public String getNextOfKinName() {
        return this.nextOfKinName;
    }
    
    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }
    public String getNextOfKinAddress() {
        return this.nextOfKinAddress;
    }
    
    public void setNextOfKinAddress(String nextOfKinAddress) {
        this.nextOfKinAddress = nextOfKinAddress;
    }
    public String getNextOfKinphone() {
        return this.nextOfKinphone;
    }
    
    public void setNextOfKinphone(String nextOfKinphone) {
        this.nextOfKinphone = nextOfKinphone;
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
    public String getReceptionistOnDuty() {
        return this.receptionistOnDuty;
    }
    
    public void setReceptionistOnDuty(String receptionistOnDuty) {
        this.receptionistOnDuty = receptionistOnDuty;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public Set getRestaurantses() {
        return this.restaurantses;
    }
    
    public void setRestaurantses(Set restaurantses) {
        this.restaurantses = restaurantses;
    }
    public Set getGuestMasterBillses() {
        return this.guestMasterBillses;
    }
    
    public void setGuestMasterBillses(Set guestMasterBillses) {
        this.guestMasterBillses = guestMasterBillses;
    }
    public Set getRoomses() {
        return this.roomses;
    }
    
    public void setRoomses(Set roomses) {
        this.roomses = roomses;
    }
    public Set getBarses() {
        return this.barses;
    }
    
    public void setBarses(Set barses) {
        this.barses = barses;
    }




}


