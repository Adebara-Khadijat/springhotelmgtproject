package greater.dao;

import greater.pojo.AuditTrailLogins;
import greater.pojo.Employees;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import util.HibernateUtil;

public class EmployeeLogin {
    
    private SessionFactory sessionFactory;
    private String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    Session session = HibernateUtil.getSessionFactory().openSession();  
    
    public int checkEmployeeLogin(String email_id, String pwd, String user_role_id, String position){
             int status = 1;
             Query q = session.createQuery("from Employees where email= :email and password = :password and user_role_id = :user_role_id and position = :position").setString("email", email_id).setString("password", pwd).setString("user_role_id", user_role_id).setString("position", position);			        
             List employeeList = q.list();
             for(Iterator it = employeeList.iterator(); it.hasNext();){
             Employees emp =(Employees)it.next();
             
             AuditTrailLogins auditLogin = new AuditTrailLogins();
             
             if(emp.getEmail().equals(email_id) && emp.getPassword().equals(pwd) && emp.getUserRoleId().equals("Super Admin") && emp.getPosition().equals("Super Admin")){                 
                                  
                auditLogin.setEmail(emp.getEmail()); 
                auditLogin.setUserRoleId(emp.getUserRoleId());
                auditLogin.setOperation("Employee Login");                 
                auditLogin.setPassword(emp.getPassword());
                auditLogin.setFirstName(emp.getFirstName());
                auditLogin.setLastName(emp.getLastName());
                auditLogin.setSex(emp.getSex());
                auditLogin.setPhone(emp.getPhone());
                auditLogin.setAddress(emp.getAddress());
                auditLogin.setPosition(emp.getPosition());
                auditLogin.setCreatedDate(createdDate);
               
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sUserRoleId", emp.getUserRoleId());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPassword", emp.getPassword());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sFirstName", emp.getFirstName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sLastName", emp.getLastName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sSex", emp.getSex());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPhone", emp.getPhone());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sAddress", emp.getAddress());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPicture", emp.getPicture().trim());                              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPosition", emp.getPosition());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sCreatedDate", emp.getCreatedDate());              
                      
                createAuditTrailLogin(auditLogin);
                                
//                 String email_db = emp.getEmail();                 
//                 String userRole_db = emp.getUserRoleId();                 
//                 String positiion_db = emp.getPosition();                   
//                                  
//                 System.out.println(email_db);                 
//                 System.out.println(userRole_db);                 
//                 System.out.println(positiion_db);
                 
                                  
                 return status=0;
                }
             
             else if(emp.getEmail().equals(email_id) && emp.getPassword().equals(pwd) && emp.getUserRoleId().equals("Admin") && emp.getPosition().equals("Admin")){                 
                                  
                auditLogin.setEmail(emp.getEmail()); 
                auditLogin.setUserRoleId(emp.getUserRoleId());
                auditLogin.setOperation("Employee Login");                 
                auditLogin.setPassword(emp.getPassword());
                auditLogin.setFirstName(emp.getFirstName());
                auditLogin.setLastName(emp.getLastName());
                auditLogin.setSex(emp.getSex());
                auditLogin.setPhone(emp.getPhone());
                auditLogin.setAddress(emp.getAddress());
                auditLogin.setPosition(emp.getPosition());
                auditLogin.setCreatedDate(createdDate);
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sUserRoleId", emp.getUserRoleId());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPassword", emp.getPassword());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sFirstName", emp.getFirstName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sLastName", emp.getLastName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sSex", emp.getSex());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPhone", emp.getPhone());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sAddress", emp.getAddress());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPicture", emp.getPicture().trim());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPosition", emp.getPosition());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sCreatedDate", emp.getCreatedDate());              
                
                createAuditTrailLogin(auditLogin);
                                  
                 return status=0;
                }
             
             else if(emp.getEmail().equals(email_id) && emp.getPassword().equals(pwd) && emp.getUserRoleId().equals("Employee") && emp.getPosition().equals("Receptionist")){                 
                                  
                auditLogin.setEmail(emp.getEmail()); 
                auditLogin.setUserRoleId(emp.getUserRoleId());
                auditLogin.setOperation("Employee Login");                 
                auditLogin.setPassword(emp.getPassword());
                auditLogin.setFirstName(emp.getFirstName());
                auditLogin.setLastName(emp.getLastName());
                auditLogin.setSex(emp.getSex());
                auditLogin.setPhone(emp.getPhone());
                auditLogin.setAddress(emp.getAddress());
                auditLogin.setPosition(emp.getPosition());
                auditLogin.setCreatedDate(createdDate);
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sUserRoleId", emp.getUserRoleId());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPassword", emp.getPassword());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sFirstName", emp.getFirstName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sLastName", emp.getLastName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sSex", emp.getSex());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPhone", emp.getPhone());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sAddress", emp.getAddress());       
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPicture", emp.getPicture().trim());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPosition", emp.getPosition());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sCreatedDate", emp.getCreatedDate());              
                
                createAuditTrailLogin(auditLogin);
                                  
                 return status=0;
                }
             
             else if(emp.getEmail().equals(email_id) && emp.getPassword().equals(pwd) && emp.getUserRoleId().equals("Employee") && emp.getPosition().equals("Waiter")){                 
                                  
                auditLogin.setEmail(emp.getEmail()); 
                auditLogin.setUserRoleId(emp.getUserRoleId());
                auditLogin.setOperation("Employee Login");                 
                auditLogin.setPassword(emp.getPassword());
                auditLogin.setFirstName(emp.getFirstName());
                auditLogin.setLastName(emp.getLastName());
                auditLogin.setSex(emp.getSex());
                auditLogin.setPhone(emp.getPhone());
                auditLogin.setAddress(emp.getAddress());
                auditLogin.setPosition(emp.getPosition());
                auditLogin.setCreatedDate(createdDate);
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sUserRoleId", emp.getUserRoleId());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPassword", emp.getPassword());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sFirstName", emp.getFirstName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sLastName", emp.getLastName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sSex", emp.getSex());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPhone", emp.getPhone());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sAddress", emp.getAddress());       
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPicture", emp.getPicture().trim());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPosition", emp.getPosition());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sCreatedDate", emp.getCreatedDate());              
                
                createAuditTrailLogin(auditLogin);
                                  
                 return status=0;
                }
             
             else if(emp.getEmail().equals(email_id) && emp.getPassword().equals(pwd) && emp.getUserRoleId().equals("Employee") && emp.getPosition().equals("Waitress")){                 
                                  
                auditLogin.setEmail(emp.getEmail()); 
                auditLogin.setUserRoleId(emp.getUserRoleId());
                auditLogin.setOperation("Employee Login");                 
                auditLogin.setPassword(emp.getPassword());
                auditLogin.setFirstName(emp.getFirstName());
                auditLogin.setLastName(emp.getLastName());
                auditLogin.setSex(emp.getSex());
                auditLogin.setPhone(emp.getPhone());
                auditLogin.setAddress(emp.getAddress());
                auditLogin.setPosition(emp.getPosition());
                auditLogin.setCreatedDate(createdDate);
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sUserRoleId", emp.getUserRoleId());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPassword", emp.getPassword());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sFirstName", emp.getFirstName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sLastName", emp.getLastName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sSex", emp.getSex());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPhone", emp.getPhone());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sAddress", emp.getAddress());       
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPicture", emp.getPicture().trim());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPosition", emp.getPosition());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sCreatedDate", emp.getCreatedDate());              
                
                createAuditTrailLogin(auditLogin);
                                  
                 return status=0;
                }
             
             else if(emp.getEmail().equals(email_id) && emp.getPassword().equals(pwd) && emp.getUserRoleId().equals("Employee") && emp.getPosition().equals("Bar man")){                 
                                  
                auditLogin.setEmail(emp.getEmail()); 
                auditLogin.setUserRoleId(emp.getUserRoleId());
                auditLogin.setOperation("Employee Login");                 
                auditLogin.setPassword(emp.getPassword());
                auditLogin.setFirstName(emp.getFirstName());
                auditLogin.setLastName(emp.getLastName());
                auditLogin.setSex(emp.getSex());
                auditLogin.setPhone(emp.getPhone());
                auditLogin.setAddress(emp.getAddress());
                auditLogin.setPosition(emp.getPosition());
                auditLogin.setCreatedDate(createdDate);
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sUserRoleId", emp.getUserRoleId());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPassword", emp.getPassword());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sFirstName", emp.getFirstName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sLastName", emp.getLastName());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sSex", emp.getSex());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPhone", emp.getPhone());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sAddress", emp.getAddress());       
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPicture", emp.getPicture().trim());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sPosition", emp.getPosition());              
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sCreatedDate", emp.getCreatedDate());              
                
                createAuditTrailLogin(auditLogin);
                                  
                 return status=0;
                }
             }              
             return status;
        }
        
    
    public void createAuditTrailLogin(AuditTrailLogins auditLogin) {        
        Transaction trans = session.beginTransaction();
        session.save(auditLogin);
        trans.commit();
    }
    
    public List<AuditTrailLogins> listAuditTrail() {
        Session sessions = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sessions.beginTransaction();
        List<AuditTrailLogins> listAudit = sessions.createQuery("select a from AuditTrailLogins a").list();
        
        trans.commit();
        return listAudit;
    }
        
//    public static void main(String checkEmp[]){
//        EmployeeLogin empLogin = new EmployeeLogin();
//            
//        System.out.println(empLogin.checkEmployeeLogin("abimbola@gmail.com", "1111","U0001"));
//              
//    }
    
}
