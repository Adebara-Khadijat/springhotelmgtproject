package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.Guests;
import greater.service.GuestService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "guestController")
@RequestScoped
public class GuestController implements Serializable {
    
     @ManagedProperty(value="#{guestService}") //injecting Service Class Interface into ManagedBean 

    @Autowired
    GuestService guestService;

    public GuestService getGuestService() {
        return guestService;
    }

    public void setGuestService(GuestService guestService) {
        this.guestService = guestService;
    }
    
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
     private String nextOfKinPhone;
     private String arrivalDate;
     private String departureDate;
     private String timeCheckIn;
     private String timeCheckOut;
     private String receptionistOnDuty;
     private String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());          
     private String mgsError;
     
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getResidentPermitNo() {
        return residentPermitNo;
    }

    public void setResidentPermitNo(String residentPermitNo) {
        this.residentPermitNo = residentPermitNo;
    }

    public String getNextOfKinName() {
        return nextOfKinName;
    }

    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }

    public String getNextOfKinAddress() {
        return nextOfKinAddress;
    }

    public void setNextOfKinAddress(String nextOfKinAddress) {
        this.nextOfKinAddress = nextOfKinAddress;
    }

    public String getNextOfKinPhone() {
        return nextOfKinPhone;
    }

    public void setNextOfKinPhone(String nextOfKinPhone) {
        this.nextOfKinPhone = nextOfKinPhone;
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

    public String getReceptionistOnDuty() {
        return receptionistOnDuty;
    }

    public void setReceptionistOnDuty(String receptionistOnDuty) {
        this.receptionistOnDuty = receptionistOnDuty;
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
     
    public GuestController() {
    }
    
    public void validateEmail(FacesContext fc, UIComponent c, Object value)throws ValidatorException{
        String email = (String) value;
        Pattern mask = null;
        mask = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher matcher = mask.matcher(email);
        if(!matcher.matches()){
            FacesMessage message = new FacesMessage();
            message.setDetail("Invalid em-mail ID");
            message.setSummary("Invalid em-mail ID");
            throw new ValidatorException(message);
        }
    }    
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    
    public String saveGuest(){ 
        Guests g = new Guests();        
        int mgs = guestService.checkGuest(email);    
        if(mgs !=0){
            
            g.setEmail(email);       
            g.setTitle(title);
            g.setFirstName(firstName);
            g.setLastName(lastName);
            g.setAddress(address);
            g.setDateOfBirth(dateOfBirth);
            g.setSex(sex);
            g.setPhone(phone);        
            g.setOccupation(occupation);
            g.setGuestType(guestType);
            g.setCompanyName(companyName);
            g.setNationality(nationality);        
            g.setPassportNo(passportNo);
            g.setResidentPermitNo(residentPermitNo);
            g.setNextOfKinName(nextOfKinName);
            g.setNextOfKinphone(nextOfKinPhone);
            g.setNextOfKinAddress(nextOfKinAddress);
            g.setArrivalDate(arrivalDate);
            g.setDepartureDate(departureDate);
            g.setTimeCheckIn(timeCheckIn);
            g.setTimeCheckOut(timeCheckOut);
            String sReceptionistOnDuty = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            g.setReceptionistOnDuty(sReceptionistOnDuty);
            g.setCreatedDate(createdDate);            
            
            guestService.createdGuest(g);
            setFieldToNull();            
            mgsError="Guest Record Created!!!";          
            
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
            audit.setOperation("Create Guest with Email ID "+g.getEmail());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
            
        }else if(mgs ==0){
            mgsError="Guest Record Already Exist!!!"; 
        }
        return "hotel_guest";
    }
    
    public String updateGuest(){
        Guests g = new Guests();
        
        int mgs = guestService.checkGuest(email);    
        if(mgs ==0){
            
            g.setEmail(email);       
            g.setTitle(title);
            g.setFirstName(firstName);
            g.setLastName(lastName);
            g.setAddress(address);
            g.setDateOfBirth(dateOfBirth);
            g.setSex(sex);
            g.setPhone(phone);        
            g.setOccupation(occupation);
            g.setGuestType(guestType);
            g.setCompanyName(companyName);
            g.setNationality(nationality);        
            g.setPassportNo(passportNo);
            g.setResidentPermitNo(residentPermitNo);
            g.setNextOfKinName(nextOfKinName);
            g.setNextOfKinphone(nextOfKinPhone);
            g.setNextOfKinAddress(nextOfKinAddress);
            g.setArrivalDate(arrivalDate);
            g.setDepartureDate(departureDate);
            g.setTimeCheckIn(timeCheckIn);
            g.setTimeCheckOut(timeCheckOut);
            String sReceptionistOnDuty = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            g.setReceptionistOnDuty(sReceptionistOnDuty);
            g.setCreatedDate(createdDate);            
            
            guestService.updateGuest(g);
            setFieldToNull();            
            mgsError="Guest Record Updated !!!";          
            
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
            audit.setOperation("Update Guest with Email ID "+g.getEmail());
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
            mgsError="Guest Record Does Not Already Exist!!!"; 
        }
        return "hotel_guest_edit";
    }
    
    public String deleteGuest(){
        Guests g = new Guests();
                
        int mgs = guestService.checkGuest(email);    
        if(mgs ==0){
            
            g.setEmail(email);       
            g.setTitle(title);
            g.setFirstName(firstName);
            g.setLastName(lastName);
            g.setAddress(address);
            g.setDateOfBirth(dateOfBirth);
            g.setSex(sex);
            g.setPhone(phone);        
            g.setOccupation(occupation);
            g.setGuestType(guestType);
            g.setCompanyName(companyName);
            g.setNationality(nationality);        
            g.setPassportNo(passportNo);
            g.setResidentPermitNo(residentPermitNo);
            g.setNextOfKinName(nextOfKinName);
            g.setNextOfKinphone(nextOfKinPhone);
            g.setNextOfKinAddress(nextOfKinAddress);
            g.setArrivalDate(arrivalDate);
            g.setDepartureDate(departureDate);
            g.setTimeCheckIn(timeCheckIn);
            g.setTimeCheckOut(timeCheckOut);
            String sReceptionistOnDuty = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            g.setReceptionistOnDuty(sReceptionistOnDuty);            
            g.setCreatedDate(createdDate);            
            
            guestService.deleteGuest(g);            
            setFieldToNull();            
            mgsError="Guest Record Deleted !!!";          
            
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
            audit.setOperation("Delete Guest with Email ID "+g.getEmail());
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
            mgsError="Guest Record Does Not Already Exist!!!"; 
        }
        
        return "hotel_guest_edit";
    }
    
    // Method To Fetch Particular Guest Details From The Database
	public String getGuestDetailsByID() { 
            Guests g = new Guests();
            List<Guests> guestList = guestService.listGuestByID(email);
                
            int checkId = guestService.checkGuest(email);                
                if(checkId==0){                   
		for(Iterator it = guestList.iterator(); it.hasNext();) {                    
                    g = (Guests)it.next();

                    email = g.getEmail();
                    title = g.getTitle();
                    firstName = g.getFirstName();
                    lastName = g.getLastName();
                    address = g.getAddress();
                    dateOfBirth = g.getDateOfBirth();
                    sex = g.getSex();
                    phone = g.getPhone();
                    occupation = g.getOccupation();
                    guestType = g.getGuestType();
                    companyName = g.getCompanyName();
                    nationality = g.getNationality();
                    passportNo = g.getPassportNo();
                    residentPermitNo =g.getResidentPermitNo();
                    nextOfKinName = g.getNextOfKinName();
                    nextOfKinPhone = g.getNextOfKinphone();
                    nextOfKinAddress = g.getNextOfKinAddress();            
                    arrivalDate = g.getArrivalDate();
                    departureDate = g.getDepartureDate();
                    timeCheckIn = g.getTimeCheckIn();
                    timeCheckOut = g.getTimeCheckOut();
                    receptionistOnDuty = g.getReceptionistOnDuty();
                    createdDate = g.getCreatedDate();
		}
                }else if(checkId!=0){
                    setMgsError("Guest Record does not Exist!!");                                                          
                }           
		return "hotel_guest_edit";
	}
        
        // Method To Fetch Particular Employee Details From The Database
	public String getEmployeeProfileByID() { 
            Guests g = new Guests();
            List<Guests> guestList = guestService.listGuestByID(email);
                int checkId = guestService.checkGuest(email);                
                if(checkId==0){                   
		for(Iterator it = guestList.iterator(); it.hasNext();) {                    
                    g = (Guests)it.next();
                    
                    email = g.getEmail();
                    title = g.getTitle();
                    firstName = g.getFirstName();
                    lastName = g.getLastName();
                    address = g.getAddress();
                    dateOfBirth = g.getDateOfBirth();
                    sex = g.getSex();
                    phone = g.getPhone();
                    occupation = g.getOccupation();
                    guestType = g.getGuestType();
                    companyName = g.getCompanyName();
                    nationality = g.getNationality();
                    passportNo = g.getPassportNo();
                    residentPermitNo =g.getResidentPermitNo();
                    nextOfKinName = g.getNextOfKinName();
                    nextOfKinPhone = g.getNextOfKinphone();
                    nextOfKinAddress = g.getNextOfKinAddress();            
                    arrivalDate = g.getArrivalDate();
                    departureDate = g.getDepartureDate();
                    timeCheckIn = g.getTimeCheckIn();
                    timeCheckOut = g.getTimeCheckOut();
                    receptionistOnDuty = g.getReceptionistOnDuty();
                    createdDate = g.getCreatedDate();
		}
                }else if(checkId!=0){
                    setMgsError("Guest Record does not Exist!!");                                                          
                }
           
		return "";
        }
        
        // Method To Fetch All Guest Details From The Database
	public List<Guests> getGuestDetails() {            
            Guests g = new Guests();
            	List<Guests> guestList = guestService.listGuest();
		for(Iterator it = guestList.iterator();it.hasNext();) {                    
                    g = (Guests)it.next();
                    email = g.getEmail();
                    title = g.getTitle();
                    firstName = g.getFirstName();
                    lastName = g.getLastName();
                    address = g.getAddress();
                    dateOfBirth = g.getDateOfBirth();
                    sex = g.getSex();
                    phone = g.getPhone();
                    occupation = g.getOccupation();
                    guestType = g.getGuestType();
                    companyName = g.getCompanyName();
                    nationality = g.getNationality();
                    passportNo = g.getPassportNo();
                    residentPermitNo =g.getResidentPermitNo();
                    nextOfKinName = g.getNextOfKinName();
                    nextOfKinPhone = g.getNextOfKinphone();
                    nextOfKinAddress = g.getNextOfKinAddress();            
                    arrivalDate = g.getArrivalDate();
                    departureDate = g.getDepartureDate();
                    timeCheckIn = g.getTimeCheckIn();
                    timeCheckOut = g.getTimeCheckOut();
                    receptionistOnDuty = g.getReceptionistOnDuty();
                    createdDate = g.getCreatedDate();
		}               
		return guestList;
	}
        
        public void setFieldToNull(){
            this.setEmail("");       
            this.setTitle("");
            this.setFirstName("");
            this.setLastName("");
            this.setAddress("");
            this.setDateOfBirth("");
            this.setSex("");
            this.setPhone("");        
            this.setOccupation("");
            this.setGuestType("");
            this.setCompanyName("");
            this.setNationality("");        
            this.setPassportNo("");
            this.setResidentPermitNo("");
            this.setNextOfKinName("");
            this.setNextOfKinPhone("");
            this.setNextOfKinAddress("");
            this.setArrivalDate("");
            this.setDepartureDate("");
            this.setTimeCheckIn("");
            this.setTimeCheckOut("");
            this.setReceptionistOnDuty("");
            this.setCreatedDate(createdDate);
    }
        
    
    
    
}
