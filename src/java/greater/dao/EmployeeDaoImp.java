package greater.dao;

import greater.pojo.Employees;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

@Named
@Repository("employeeDao")
public class EmployeeDaoImp implements EmployeeDao {
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdEmplyee(Employees e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        e.setEmail(e.getEmail());        
        e.setUserRoleId(e.getUserRoleId());
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPassword(e.getPassword());
        e.setSex(e.getSex());
        e.setPhone(e.getPhone());        
        e.setAddress(e.getAddress());
        e.setPosition(e.getPosition());
//        e.setPicture(image.getFileName());                     
        e.setPicture(e.getPicture());                                                
        e.setHireDate(e.getHireDate());
        e.setCreatedDate(e.getCreatedDate());
                
        session.save(e);
        trans.commit();
    }
    
    @Override
    public List<Employees> listEmployeeByID(String emailId){
        Employees eObj = new Employees();
        List<Employees> eList = new ArrayList<Employees>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Employees where email = :email").setString("email", emailId);
        eObj = (Employees)queryObj.uniqueResult();
        eList = queryObj.list();
//        for(Employees em: eList){
////            System.out.println(em.getEmail());
////            System.out.println(em.getUserRoleId());
////            System.out.println(em.getFirstName());            
//        }
        trans.commit();
        return eList;
    }
    
    @Override
    public int checkEmployeeLogin(String email_id){
             int status = 1;
             Session session = HibernateUtil.getSessionFactory().openSession();
             Transaction trans = session.beginTransaction();
             Query q = session.createQuery("from Employees where email= :email").setString("email", email_id);			        
             List employeeList = q.list();
             for(Iterator it = employeeList.iterator(); it.hasNext();){
             Employees emp =(Employees)it.next();
             
             if(emp.getEmail().equals(email_id)){                 
                 return status=0;
                }             
             }              
             trans.commit();
             return status;
        }
    
    @Override
    public void updateEmplyee(Employees e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        e.setEmail(e.getEmail());        
        e.setUserRoleId(e.getUserRoleId());
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPassword(e.getPassword());
        e.setSex(e.getSex());
        e.setPhone(e.getPhone());        
        e.setAddress(e.getAddress());
        e.setPosition(e.getPosition());
//        e.setPicture(image.getFileName());                     
        e.setPicture(e.getPicture());                                                
        e.setHireDate(e.getHireDate());
        e.setCreatedDate(e.getCreatedDate());
               
        session.update(e);
        trans.commit();
    }

    @Override
    public void deleteEmployee(Employees e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        
        e.setEmail(e.getEmail());        
        e.setUserRoleId(e.getUserRoleId());
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPassword(e.getPassword());
        e.setSex(e.getSex());
        e.setPhone(e.getPhone());        
        e.setAddress(e.getAddress());
        e.setPosition(e.getPosition());
        e.setPicture(e.getPicture());                                                
        e.setHireDate(e.getHireDate());
        e.setCreatedDate(e.getCreatedDate());
        
        session.delete(e);                         
        trans.commit();
    }

    @Override
    public List<Employees> listEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Employees> listEmployees = session.createQuery("select e from Employees e").list();
        
        trans.commit();
        return listEmployees;
    }        
    
// public static void main(String employee[]){
//        EmployeeDaoImp daoImp = new EmployeeDaoImp();
//        Employees e = new Employees();
////        
//        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
////        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
////        String filename = FilenameUtils.getName("C:/ComputerG/Khadijat/oris pics/Image0076.jpg");
////
////////        insert        
////        e.setEmail("abdrahman@gmail.com");       
////        e.setUserRoleId("U0002");
////        e.setFirstName("AbdRahman");
////        e.setLastName("Orimadegun");
////        e.setPassword("123");
////        e.setSex("Male");
////        e.setPhone("08099901122");        
////        e.setAddress("24B, Pike Street");
////        e.setPosition("Software Developer");
////        e.setPicture(filename);
////        e.setHireDate(createdDate);
////        e.setCreatedDate(createdDate);
////        System.out.println("OK1: "+e.getEmail());    
////        System.out.println("OK2: "+e.getUserRoleId());            
////        System.out.println("OK3: "+e.getFirstName());
////        System.out.println("OK4: "+e.getLastName());
////        System.out.println("OK5: "+e.getPassword());
////        System.out.println("OK6: "+e.getSex());
////        System.out.println("OK7: "+e.getPhone());
////        System.out.println("OK8: "+e.getEmail());
////        System.out.println("OK9: "+e.getAddress());
////        System.out.println("OK10: "+e.getPosition());
////        System.out.println("OK11: "+e.getPicture());
////        System.out.println("OK12: "+e.getHireDate());
////        System.out.println("OK13: "+e.getCreatedDate());
////        daoImp.createdEmplyee(e);
//
////getEmployeeByID
////        System.out.println(daoImp.listEmployeeByID("abimbola@gmail.com"));
////        System.out.println(daoImp.checkEmployeeLogin("ola@gmail.com"));
//        
//        //update
////        e.setEmail("abdrahman@yahoo.com");       
////        e.setUserRoleId("U0002");
////        e.setFirstName("AbdRahman");
////        e.setLastName("Oyinkansola");
////        e.setPassword("123");
////        e.setSex("Male");
////        e.setPhone("08099901122");        
////        e.setAddress("24B, Pike Street");
////        e.setPosition("Software Developer");
////        e.setPicture("image.png");
////        e.setHireDate(createdDate);
////        daoImp.updateEmplyee(e);
//        
//        //delete        
////        e.setEmail("Klola@gmail.com");
////        daoImp.deleteEmployee(e);
//        
//        //getAllEmployeesDetail
////        List<Employees> liste = daoImp.listEmployee();
////        for(Iterator it = liste.iterator(); it.hasNext();){
////            Employees emp = (Employees) it.next();
////            System.out.println(emp.getEmail()+ " : "+emp.getUserRoleId()+ " : "+emp.getFirstName()+ " : "+emp.getLastName());           
////        }
//     
//    }
 
    
}
