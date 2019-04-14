package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name="employeeLoginController")
@RequestScoped
public class EmployeeLoginController {
    private String email; //= "saboor@gmail.com"; //"abimbola@gmail.com";  
    private String password; // = "123";
    private static final String user_role_id_0 ="Super Admin";
    private static final String user_role_id_1 ="Admin";
    private static final String user_role_id_2 ="Employee";
    private static final String positionSuper ="Super Admin";
    private static final String positionAdmin ="Admin";
    private static final String positionWaiter ="Waiter";
    private static final String positionWaiteress ="Waitress";
    private static final String positionBarman ="Bar man";
    private static final String positionReceptionist ="Receptionist";    
    private String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
    private String email_Error;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getEmail_Error() {
        return email_Error;
    }

    public void setEmail_Error(String email_Error) {
        this.email_Error = email_Error;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
                
    public String submitAction(){
        EmployeeLogin empLogin = new EmployeeLogin();

        int msgSuper = empLogin.checkEmployeeLogin(email, password, user_role_id_0, positionSuper);
        int msgAdmin = empLogin.checkEmployeeLogin(email, password, user_role_id_1, positionAdmin);
        int msgWaiter = empLogin.checkEmployeeLogin(email, password, user_role_id_2, positionWaiter);
        int msgWaiteress = empLogin.checkEmployeeLogin(email, password, user_role_id_2, positionWaiteress);
        int msgBarman = empLogin.checkEmployeeLogin(email, password, user_role_id_2, positionBarman);
        int msgReceptionist = empLogin.checkEmployeeLogin(email, password, user_role_id_2, positionReceptionist);
           
        if(msgSuper==0){            
            setFieldToNull();
            return "hotel_super_admin";
        }       
        else if(msgAdmin==0){            
            setFieldToNull();
            return "hotel_admin";
        }
        else if(msgWaiter==0){            
            setFieldToNull();
            return "hotel_restaurant";
        }
        else if(msgWaiteress==0){            
            setFieldToNull();
            return "hotel_restaurant";
        }
        else if(msgBarman==0){            
            setFieldToNull();
            return "hotel_bar";
        }
        else if(msgReceptionist==0){            
            setFieldToNull();
            return "hotel_room";
        }
        else if(msgSuper!=0 || msgAdmin!=0 || msgWaiter!=0 || msgWaiteress!=0 || msgBarman!=0 || msgReceptionist!=0)            
            setEmail_Error("Employee Details does not exists. Try again");                                   
            setFieldToNull();

            return "hotel_index";          
    }
    
    public void setFieldToNull(){
        this.setEmail("");        
        this.setPassword("");
    //    this.setEmail_Error("");
    }

    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    
public void logout(){
        
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
//            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Employee Logout");
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(createdDate);
            el.createAuditTrailLogin(audit);  
        }catch(Exception ex){
            ex.printStackTrace();
        }
            
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/hotel_index.xhtml");
    }    
    

//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//HttpServletResponse response =  (HttpServletResponse)context.getResponse();
//response.setHeader("Cache-Control", "no-cache, no-store");


public void setNoCache() {
        HttpServletResponse response = (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Cache-Control", "no-cache, no-store");
} 



//    public static void main(String EmployeeLogin[]){
//        EmployeeLoginController empCon = new EmployeeLoginController();
//        System.out.println(empCon.submitAction());
//        
//    }
    
    
}
