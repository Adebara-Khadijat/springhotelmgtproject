package greater.dao;

import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.Restaurants;
import greater.pojo.ServiceCharges;
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
@Repository("serviceChargeDao")

public class ServiceChargeDaoImp implements ServiceChargeDao {
    
        private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdServiceCharge(ServiceCharges s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.save(s);
        trans.commit();
    }
    
    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
                
        session.save(gmb);
        trans.commit();
    }

    @Override
    public void updateServiceCharge(ServiceCharges s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.update(s);
        trans.commit();
    }
            
    @Override
    public void deleteServiceCharge(ServiceCharges s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.delete(s);
        trans.commit();
    }

    @Override
    public List<ServiceCharges> listServiceChargeByEmail(String email) {
        ServiceCharges sObj = new ServiceCharges();
        List<ServiceCharges> sList = new ArrayList<ServiceCharges>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listemail = session.createQuery("select s from ServiceCharges s where email  = :email").setString("email", email).list();
        sList = listemail;       
        trans.commit();
        return sList;
    }
     
    @Override
    public List<ServiceCharges> listServiceChargeById(String serChargeId) {        
        List<ServiceCharges> sList = new ArrayList<ServiceCharges>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listemail = session.createQuery("select s from ServiceCharges s where serChargeId  = :serChargeId").setString("serChargeId", serChargeId).list();
        sList = listemail;       
        trans.commit();
        return sList;
    }
    
    @Override
    public List<ServiceCharges> listServiceCharge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<ServiceCharges> listS = session.createQuery("select s from ServiceCharges s").list();
        
        trans.commit();
        return listS;
    }

    @Override
    public int checkServiceCharge(String email) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from ServiceCharges where email = :email").setString("email", email);			        
        List stList = q.list();
        for(Iterator it = stList.iterator(); it.hasNext();){
        ServiceCharges s =(ServiceCharges)it.next();

        if(s.getEmail().equals(email)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }
    
    @Override
    public int checkServiceChargeId(String serChargeId) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from ServiceCharges where serChargeId = :serChargeId").setString("serChargeId", serChargeId);			        
        List stList = q.list();
        for(Iterator it = stList.iterator(); it.hasNext();){
        ServiceCharges s =(ServiceCharges)it.next();

        if(s.getSerChargeId().equals(serChargeId)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }
            
    @Override
    public List<Restaurants> listRestaurantBySubTotal(String email) {     
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Restaurants> listSubTotal = session.createQuery("select sum(total) from Restaurants where email  = :email").setString("email", email).list();         
        String subTotal = listSubTotal.toString().trim();
//        System.out.println(subTotal);
        trans.commit();
        return listSubTotal;
    }
    
        public static void main(String employee[]){
        ServiceChargeDaoImp daoImp = new ServiceChargeDaoImp();
        ServiceCharges s = new ServiceCharges();
        Guests g = new Guests();
        g.setEmail("abiola@gmail.com");
        
//              
        String createdDate =  new SimpleDateFormat("yyyy-MM-dd").format(new Date()); 
        String serChargeId =  new SimpleDateFormat("yyyyss").format(new Date()); 
//
//         guestEmail; serviceCharge; sumTotal; createdDate;
//      insert        
//        s.setSerCharge(serChargeId);
//        s.setGuests(g);
//        s.setServiceCharge(150.00);
//        s.setSubTotal(1500.00);
//        s.setGrandTotal(15.0 * 1500.0);
//        s.setCreatedDate(createdDate);
//        
//        daoImp.createdServiceCharge(s);
        
        //update
//        s.setSerCharge("201924");
//        s.setGuests(g);
//        s.setServiceCharge(100.00);
//        s.setSubTotal(1500.00);
//        s.setGrandTotal(10.0 * 1500.0);
//        s.setCreatedDate(createdDate);
//
//        daoImp.updateServiceCharge(s);

                  
//        delete        
//          s.setSerChargeId("201924");
//        daoImp.deleteServiceCharge(s);  
//        
        //getAllGuestDetail
//        List<ServiceCharges> listServiceCharge = daoImp.listServiceCharge();
//        for(Iterator it = listServiceCharge.iterator(); it.hasNext();){
//            ServiceCharges se = (ServiceCharges) it.next();
//            System.out.println(se.getGuestEmail()+ " : "+ se.getServiceCharge()+ " : "+se.getSumTotal()+" : "+se.getCreatedDate());           
//        }
        
//        List<ServiceCharges> listServiceCharge = daoImp.listServiceChargeByEmail("oladeji@yahoo.com");
//        for(Iterator it = listServiceCharge.iterator(); it.hasNext();){
//            ServiceCharges se = (ServiceCharges) it.next();
//            System.out.println(se.getServiceCharge()+ " : "+se.getSubTotal()+" : "+se.getCreatedDate());           
//        }
        
//        List<ServiceCharges> listServiceCharge = daoImp.listServiceChargeById("20190226");
//        for(Iterator it = listServiceCharge.iterator(); it.hasNext();){
//            ServiceCharges se = (ServiceCharges) it.next();
//            System.out.println(se.getServiceCharge()+ " : "+se.getSubTotal()+" : "+se.getCreatedDate());           
//        }

//        daoImp.listRestaurantBySubTotal("oladeji@yahoo.com");
    }

    
}
