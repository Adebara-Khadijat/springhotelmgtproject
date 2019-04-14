package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.Employees;
import greater.service.EmployeeService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name="employeeController")
@RequestScoped
public class EmployeeController implements Serializable {
    
    @ManagedProperty(value="#{employeeService}") //injecting Service Class Interface into ManagedBean 

    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
            
     private String email; // = "gola@gmail.com"; // ="Khadijat@gmail.com";
     private String userRoleId;
     private String firstName;
     private String lastName;
     private String password;
     private String sex;
     private String phone;
     private String address;
     private String position;
     private String picture;
     private String hireDate;
     private String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());     
     private UploadedFile image;
     private String mgsError;
    
    public String getMgsError() {
        return mgsError;
    }

    public void setMgsError(String mgsError) {
        this.mgsError = mgsError;
    }
     
   
    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }     
         
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    
    public EmployeeController() {
    }

    EmployeeLogin el = new EmployeeLogin();
    AuditTrailLogins audit = new AuditTrailLogins();            
            
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
        
    public String save(){         
        Employees e = new Employees();        
                        
        UploadedFile uploadedPhoto = getImage();                       
        
        String filePath = "C:/ComputerG/Spring-HomeWork, Sept2018/SpringHotelMgtPro/web/pictures/";
        byte[] bytes = null;
        
            if(null != uploadedPhoto){            
                bytes = uploadedPhoto.getContents();                
                String filename = FilenameUtils.getName(uploadedPhoto.getFileName());   
                try{
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
                    stream.write(bytes);
                    stream.close();                
                }catch(Exception ex){
                    ex.printStackTrace();
                }            

        e.setEmail(email);
        e.setUserRoleId(userRoleId);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setPassword(password);
        e.setSex(sex);
        e.setPhone(phone);
        e.setAddress(address);
        e.setPosition(position);
        e.setPicture(filename);
        e.setHireDate(hireDate);
        e.setCreatedDate(createdDate);
            
        }
            
        try{
        
         int message = el.checkEmployeeLogin(email, password, userRoleId, position);
         
        if(message !=0){  
            
            employeeService.createdEmplyee(e);                                                                    
            setFieldToNull();            
            mgsError="Employee Record Created!!!";
            
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
            audit.setOperation("Create Employee with Email ID "+e.getEmail());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
                 
        
        }else if(message ==0){            
             mgsError="Employee Record Already Exist!!!";             
           }    
        }catch(Exception ex){
                ex.printStackTrace();                
                mgsError="Employee Already Exist";
            }
       
        return "/hotel_employee_spa.xhtml"; 
    }
    
    public String saveAdmin(){         
        Employees e = new Employees();        
                        
        UploadedFile uploadedPhoto = getImage();                       
        
        String filePath = "C:/ComputerG/Spring-HomeWork, Sept2018/SpringHotelMgtPro/web/pictures/";
        byte[] bytes = null;
        
            if(null != uploadedPhoto){            
                bytes = uploadedPhoto.getContents();                
                String filename = FilenameUtils.getName(uploadedPhoto.getFileName());   
                try{
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
                    stream.write(bytes);
                    stream.close();                
                }catch(Exception ex){
                    ex.printStackTrace();
                }            

        e.setEmail(email);
        e.setUserRoleId(userRoleId);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setPassword(password);
        e.setSex(sex);
        e.setPhone(phone);
        e.setAddress(address);
        e.setPosition(position);
        e.setPicture(filename);
        e.setHireDate(hireDate);
        e.setCreatedDate(createdDate);
            
        }
            
        try{
        
         int message = el.checkEmployeeLogin(email, password, userRoleId, position);
         
        if(message !=0){  
            
            employeeService.createdEmplyee(e);                                                                    
            setFieldToNull();            
            mgsError="Employee Record Created!!!";
            
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
            audit.setOperation("Create Employee with Email ID "+e.getEmail());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
                 
        
        }else if(message ==0){            
             mgsError="Employee Record Already Exist!!!";             
           }    
        }catch(Exception ex){
                ex.printStackTrace();                
                mgsError="Employee Already Exist";
            }
       
        return "/hotel_employee_adm.xhtml"; 
    }
    
    // Method To Fetch Particular Employee Details From The Database
	public String getEmployeeDetailsByID() { 
            Employees e = new Employees();
            List<Employees> employeeList = employeeService.listEmployeeByID(email);
                int checkId = employeeService.checkEmployeeLogin(email);                
                if(checkId==0){                   
		for(Iterator it = employeeList.iterator(); it.hasNext();) {                    
                    e = (Employees)it.next();
                    
                    email = e.getEmail();                                        
                    userRoleId = e.getUserRoleId();
                    firstName = e.getFirstName();
                    lastName = e.getLastName();
                    password = e.getPassword();
                    sex = e.getSex();
                    phone = e.getPhone();
                    address = e.getAddress();
                    position = e.getPosition();
                    picture = e.getPicture();
                    hireDate = e.getHireDate();                     
		}
                }else if(checkId!=0){
                    setMgsError("Employee Record does not Exist!!");                                                          
                }
           
		return "hotel_employee_edit_spa";
	}
        
        // Method To Fetch Particular Employee Details From The Database
	public String getEmployeeProfileByID() { 
            Employees e = new Employees();
            List<Employees> employeeList = employeeService.listEmployeeByID(email);
                int checkId = employeeService.checkEmployeeLogin(email);                
                if(checkId==0){                   
		for(Iterator it = employeeList.iterator(); it.hasNext();) {                    
                    e = (Employees)it.next();
                    
                    email = e.getEmail();                                        
                    userRoleId = e.getUserRoleId();
                    firstName = e.getFirstName();
                    lastName = e.getLastName();
                    password = e.getPassword();
                    sex = e.getSex();
                    phone = e.getPhone();
                    address = e.getAddress();
                    position = e.getPosition();
                    picture = e.getPicture();
                    hireDate = e.getHireDate();                     
		}
                }else if(checkId!=0){
                    setMgsError("Employee Record does not Exist!!");                                                          
                }
           
		return "hotel_employee_report_spa";
        }
        
        public String update(){
            Employees e = new Employees();
            UploadedFile uploadedPhoto = getImage();                       

            String filePath = "C:/ComputerG/Spring-HomeWork, Sept2018/SpringHotelMgtPro/web/pictures/";
            byte[] bytes = null;

                if(null != uploadedPhoto){            
                    bytes = uploadedPhoto.getContents();                
                    String filename = FilenameUtils.getName(uploadedPhoto.getFileName());   
                    try{
                        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
                        stream.write(bytes);
                        stream.close();                
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }            
    
            e.setEmail(email);
            e.setUserRoleId(userRoleId);
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setPassword(password);
            e.setSex(sex);
            e.setPhone(phone);
            e.setAddress(address);
            e.setPosition(position);
            e.setPicture(filename);    
            e.setHireDate(hireDate);
            e.setCreatedDate(createdDate);
            }
                
            employeeService.updateEmplyee(e);
            setFieldToNull();
            mgsError="Employee Record Updated Successfully!!!";            
            
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
            audit.setOperation("Update Employee with Email ID "+e.getEmail());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);
            
            return "hotel_employee_getID";
        }
                
        public String delete(){
            Employees e = new Employees(); 
            
            e.setEmail(email);
            e.setUserRoleId(userRoleId);
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setPassword(password);
            e.setSex(sex);
            e.setPhone(phone);
            e.setAddress(address);
            e.setPosition(position);
            e.setPicture(picture);    
            e.setHireDate(hireDate);
            e.setCreatedDate(createdDate);
                      
            employeeService.deleteEmployee(e);
            setFieldToNull();
            mgsError="Employee Record Deleted Successfully!!!"; 
            
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
            audit.setOperation("Delete Employee with Email ID "+e.getEmail());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);
                        
            return "hotel_employee_getID";
        }
                
        // Method To Fetch All Employees Details From The Database
	public List<Employees> getEmployeeDetails() {            
            Employees e = new Employees();
            	List<Employees> employeeList = employeeService.listEmployee();      
		for(Iterator it=employeeList.iterator();it.hasNext();) {                    
                    e = (Employees)it.next();
                    email = e.getEmail();                                        
                    userRoleId = e.getUserRoleId();
                    firstName = e.getFirstName();
                    lastName = e.getLastName();
                    password = e.getPassword();
                    sex = e.getSex();
                    phone = e.getPhone();
                    address = e.getAddress();
                    position = e.getPosition();
                    picture = e.getPicture();
                    hireDate = e.getHireDate();                                    
		}               
		return employeeList;
	}
        
        // Method To Fetch All Employees Audit Trail From The Database
	public List<AuditTrailLogins> getAuditTrail() {       
            EmployeeLogin el = new EmployeeLogin();
            AuditTrailLogins audit = new AuditTrailLogins();
            	List<AuditTrailLogins> auditList = el.listAuditTrail();
		for(Iterator it=auditList.iterator();it.hasNext();) {                    
                    audit = (AuditTrailLogins)it.next();
                                       
                    email = audit.getEmail();                                        
                    userRoleId = audit.getUserRoleId();
                    String operation = audit.getOperation();
                    password = audit.getPassword();
                    firstName = audit.getFirstName();
                    lastName = audit.getLastName();
                    sex = audit.getSex();
                    phone = audit.getPhone();                    
                    position = audit.getPosition();
                    createdDate = audit.getCreatedDate();                                    
		}
                return auditList;
	}
    
    public void setFieldToNull(){
        this.setEmail("");        
        this.setUserRoleId("");
        this.setFirstName("");
        this.setLastName("");
        this.setPassword("");
        this.setSex("");
        this.setPhone("");
        this.setAddress("");
        this.setPosition("");
        this.setPicture("");
        this.setHireDate("");
    }
        
////    public static void main(String emp[]){
////        EmployeeController ec = new EmployeeController();
////        System.out.println(ec.getEmployeeDetailsByID());
//                
////    }
    
}
