package greater.dao;

import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.Rooms;
import greater.pojo.ServiceCharges;
import java.util.ArrayList;
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
@Repository("guestMasterBillDao")
public class GuestMasterBillDaoImp implements GuestMasterBillDao{
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
                
        session.save(gmb);
        trans.commit();
    }

    @Override
    public void updateGuestMasterBill(GuestMasterBills gmb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.update(gmb);
        trans.commit();
    }

    @Override
    public void deleteGuestMasterBill(GuestMasterBills gmb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
               
        session.delete(gmb);
        trans.commit();
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillByID(String gmbId) {
        GuestMasterBills gmbObj = new GuestMasterBills();
        List<GuestMasterBills> gmbList = new ArrayList<GuestMasterBills>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from GuestMasterBills where id = :id").setString("id", gmbId);
        gmbObj = (GuestMasterBills)queryObj.uniqueResult();
        gmbList = queryObj.list();
        for(GuestMasterBills gmb: gmbList){
//            System.out.println(r.getRoomId());                        
//            System.out.println(r.getGuests().getEmail());            
//            System.out.println(r.getGuests().getGuestType());            
//            System.out.println(r.getRoomType());            
//            System.out.println(r.getRoomNo());            
        }
        trans.commit();
        return gmbList;
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBill() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<GuestMasterBills> listGmb = session.createQuery("select gmb from GuestMasterBills gmb").list();
        
        trans.commit();
        return listGmb;
    }
   
    @Override
    public int checkGuestMasterBillByID(String gmbId) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from GuestMasterBills where id = :id").setString("id", gmbId);			        
        List gmbList = q.list();
        for(Iterator it = gmbList.iterator(); it.hasNext();){
        GuestMasterBills gmb =(GuestMasterBills)it.next();
        if(gmb.getId().equals(gmbId)){                 
             return status=0;
            }             
          }              
        trans.commit();
        return status;
    }

    @Override
    public int checkGuestMasterBillByEmail(String email) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from GuestMasterBills where email = :email").setString("email", email);			        
        List gmbList = q.list();
        for(Iterator it = gmbList.iterator(); it.hasNext();){
        GuestMasterBills gmb =(GuestMasterBills)it.next();

        if(gmb.getGuests().getEmail().equals(email)){                 
             return status=0;
            }             
          }              
        trans.commit();
        return status;
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillByEmail(String email, String startDate, String endDate) {
        GuestMasterBills gmbObj = new GuestMasterBills();
        List<GuestMasterBills> gmbList = new ArrayList<GuestMasterBills>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();                
        List<GuestMasterBills> listemail = session.createQuery("select gmb from GuestMasterBills gmb where email = :email AND createdDate between :startDate and :endDate").setString("email", email).setString("startDate", startDate).setString("endDate", endDate).list();
        gmbList = listemail;       
        trans.commit();
        return gmbList;
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillSumCharge(String email, String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<GuestMasterBills> listGmb = session.createQuery("select sum(charge) from GuestMasterBills where email = :email AND createdDate between :startDate and :endDate").setString("email", email).setString("startDate", startDate).setString("endDate", endDate).list();        
        String gmbList = listGmb.toString();
//        System.out.println(gmbList);
        trans.commit();
        return listGmb;
    }

    @Override
    public List<GuestMasterBills> listGuestMasterBillSumCredit(String email, String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<GuestMasterBills> listGmb = session.createQuery("select sum(credit) from GuestMasterBills where email = :email AND createdDate between :startDate and :endDate").setString("email", email).setString("startDate", startDate).setString("endDate", endDate).list();        
        String gmbList = listGmb.toString();
//        System.out.println(roomList);
        trans.commit();
        return listGmb;
    }
    
    @Override
    public List<GuestMasterBills> listGuestMasterBillSubtractChargeFromCredit(String email, String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<GuestMasterBills> listGmb = session.createQuery("select (sum(credit) - sum(charge)) from GuestMasterBills where email = :email AND createdDate between :startDate and :endDate").setString("email", email).setString("startDate", startDate).setString("endDate", endDate).list();        
        String gmbList = listGmb.toString();
//        System.out.println(roomList);
        trans.commit();
        return listGmb;
    }

    
    @Override
    public List<ServiceCharges> listServiceCharge(String email, String productDec, String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listServiceCharge = session.createQuery("select serviceCharge from ServiceCharges where email = :email AND productDescription = :productDec AND createdDate between :startDate and :endDate").setString("email", email).setString("productDec", productDec).setString("startDate", startDate).setString("endDate", endDate).list();         
        String serCharge = listServiceCharge.toString().trim();
//        System.out.println(serCharge);
        trans.commit();
        return listServiceCharge;
    }
    
    @Override
    public List<ServiceCharges> listSerChGrandTotal(String email, String productDec, String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listServiceCharge = session.createQuery("select grandTotal from ServiceCharges where email = :email AND productDescription = :productDec AND createdDate between :startDate and :endDate").setString("email", email).setString("productDec", productDec).setString("startDate", startDate).setString("endDate", endDate).list();         
        String serCharge = listServiceCharge.toString().trim();
//        System.out.println(serCharge);
        trans.commit();
        return listServiceCharge;
    } 
    
    public static void main(String employee[]){
        GuestMasterBillDaoImp daoImp = new GuestMasterBillDaoImp();
        Guests g = new Guests();
        Rooms rm = new Rooms();
        GuestMasterBills gm = new GuestMasterBills(); 
        
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

//        System.out.println(daoImp.listGuestMasterBillSumCharge("hameedah@gmail.com", "2019-03-08", "2019-03-12"));
        
    }
    
}
