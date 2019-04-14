package greater.dao;
import greater.pojo.Guests;
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
@Repository("guestDao")
public class GuestDaoImp implements GuestDao {
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdGuest(Guests g) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.save(g);
        trans.commit();
    }
    
    @Override
    public List<Guests> listGuestByID(String emailId) {
        Guests gObj = new Guests();
        List<Guests> gList = new ArrayList<Guests>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Guests where email = :email").setString("email", emailId);
        gObj = (Guests)queryObj.uniqueResult();
        gList = queryObj.list();
//        for(Guests g: gList){
//            System.out.println(g.getEmail());            
//            System.out.println(g.getFirstName());            
//            System.out.println(g.getLastName());            
//        }
        trans.commit();
        return gList;
    }
    
    
    @Override
    public int checkGuest(String email_id) {
        int status = 1;
             Session session = HibernateUtil.getSessionFactory().openSession();
             Transaction trans = session.beginTransaction();
             Query q = session.createQuery("from Guests where email= :email").setString("email", email_id);			        
             List guestList = q.list();
             for(Iterator it = guestList.iterator(); it.hasNext();){
             Guests g =(Guests)it.next();
             
             if(g.getEmail().equals(email_id)){                 
                 return status=0;
                }             
             }              
             trans.commit();
             return status;
    }

    @Override
    public void updateGuest(Guests g) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
               
        session.update(g);
        trans.commit();
    }

    @Override
    public void deleteGuest(Guests g) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        
        session.delete(g);                         
        trans.commit();
    }

    @Override
    public List<Guests> listGuest() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Guests> listGuest = session.createQuery("select g from Guests g order by email desc").list();
        
        trans.commit();
        return listGuest;
    }
    
//     public static void main(String employee[]){
//        GuestDaoImp daoImp = new GuestDaoImp();
//        Guests g = new Guests();
        
//        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
////email, title, firstName, lastName, address, dateOfBirth, sex, phone, occupation, guestType, companyName, nationality,
//
//////        insert        
////        g.setEmail("sola@gmail.com");       
////        g.setTitle("Miss");
////        g.setFirstName("Yola");
////        g.setLastName("Bola");
////        g.setAddress("24B, Pike Street, Lagos Island, Lagos");
////        g.setDateOfBirth("2001-05-01");
////        g.setSex("Female");
////        g.setPhone("08099901122");        
////        g.setOccupation("Student");
////        g.setGuestType("Private");
////        g.setCompanyName("");
////        g.setNationality("Nigerian");        
////        g.setPassportNo("");
////        g.setResidentPermitNo("");
////        g.setNextOfKinName("Mr. Bola");
////        g.setNextOfKinPhone("0805544333");
////        g.setNextOfKinAddress("12, Iponri Road, Lagos State");
////        g.setArrivalDate("2019-01-25");
////        g.setDepartureDate("2019-01-27");
////        g.setTimeCheckIn("01:230pm");
////        g.setTimeCheckOut("12:00pm");
////        g.setReceptionistOnDuty("ronke@gmail.com");
////        g.setCreatedDate(createdDate);
////
////        System.out.println("OK1: "+g.getEmail());    
////        System.out.println("OK3: "+g.getFirstName());
////        System.out.println("OK4: "+g.getLastName());
////        daoImp.createdGuest(g);
//
////getEmployeeByID
////        System.out.println(daoImp.listGuestByID("ola@gmail.com"));
////        System.out.println(daoImp.checkGuest("ola@gmail.com"));
//        
//        //update
////        g.setEmail("yola@gmail.com");       
////        g.setTitle("Mr");
////        g.setFirstName("Yola");
////        g.setLastName("Boro");
////        g.setAddress("24B, Pike Street, Lagos Island, Lagos");
////        g.setDateOfBirth("1991-05-01");
////        g.setSex("Male");
////        g.setPhone("08099901122");        
////        g.setOccupation("Student");
////        g.setGuestType("Company");
////        g.setCompanyName("Germmy Limited");
////        g.setNationality("Germany");        
////        g.setPassportNo("G009098");
////        g.setResidentPermitNo("RES0990");
////        g.setNextOfKinName("Mr. Halaja");
////        g.setNextOfKinPhone("08033464333");
////        g.setNextOfKinAddress("12, Iponri Road, Lagos State");
////        g.setArrivalDate("2019-01-25");
////        g.setDepartureDate("2019-01-27");
////        g.setTimeCheckIn("05:10am");
////        g.setTimeCheckOut("12:00pm");
////        g.setReceptionistOnDuty("ronke@gmail.com");
////        g.setCreatedDate(createdDate);
////        daoImp.updateGuest(g);
////        
////        delete        
////        g.setEmail("sola@gmail.com");
////        daoImp.deleteGuest(g);
//        
//        //getAllGuestDetail
//        List<Guests> listgt = daoImp.listGuest();
//        for(Iterator it = listgt.iterator(); it.hasNext();){
//            Guests gt = (Guests) it.next();
//            System.out.println(gt.getEmail()+ " : "+ gt.getFirstName()+ " : "+gt.getLastName());           
//        }
//     
//    }
// 

    
}
