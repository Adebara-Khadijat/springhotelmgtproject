package greater.dao;

import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.Rooms;
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
@Repository("roomDao")
public class RoomDaoImp implements RoomDao{
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdRoom(Rooms r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.save(r);
        trans.commit();
    }

    @Override
    public void updateRoom(Rooms r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
               
        session.update(r);
        trans.commit();
    }

    @Override
    public void deleteRoom(Rooms r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        
        session.delete(r);                         
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
    public List<Rooms> listRoomByID(String roomId) {
        Rooms rObj = new Rooms();
        List<Rooms> rList = new ArrayList<Rooms>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Rooms where roomId  = :roomId").setString("roomId", roomId);
        rObj = (Rooms)queryObj.uniqueResult();
        rList = queryObj.list();
        for(Rooms r: rList){
//            System.out.println(r.getRoomId());                        
//            System.out.println(r.getGuests().getEmail());            
//            System.out.println(r.getGuests().getGuestType());            
//            System.out.println(r.getRoomType());            
//            System.out.println(r.getRoomNo());            
        }
        trans.commit();
        return rList;
    }
        
    @Override    
    public List<Rooms> listRoom() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Rooms> listRoom = session.createQuery("select r from Rooms r order by roomId desc").list();
        
        trans.commit();
        return listRoom;
    }
    
    @Override    
    public List<Rooms> listRoomNo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Rooms> listRoom = session.createQuery("select distinct roomNo from Rooms r").list();
        String listRoomNo = listRoom.toString();
//        System.out.println(listRoomNo);        
        trans.commit();
        return listRoom;
    }
        
    @Override
    public int checkRoomId(String roomId){
        int status = 1;
             Session session = HibernateUtil.getSessionFactory().openSession();
             Transaction trans = session.beginTransaction();
             Query q = session.createQuery("from Rooms where roomId = :roomId").setString("roomId", roomId);			        
             List guestList = q.list();
             for(Iterator it = guestList.iterator(); it.hasNext();){
             Rooms r =(Rooms)it.next();
             
             if(r.getRoomId().equals(roomId)){                 
                 return status=0;
                }             
             }              
             trans.commit();
             return status;
    }
            
    @Override
    public List<Rooms> listRoomCurrentlyInUse() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Rooms> listRoomCurrently = session.createQuery("select r from Rooms r where departureDate > current_date()").list();
        
        trans.commit();
        return listRoomCurrently;
    }

    @Override
    public List<Rooms> listRoomHistory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();                                
        List<Rooms> listRoomHistory = session.createQuery("select r from Rooms r where departureDate < current_date()").list();
        
        trans.commit();
        return listRoomHistory;
    }
                
     public static void main(String employee[]){
        RoomDaoImp daoImp = new RoomDaoImp();
        Guests g = new Guests();
//        g.setEmail("ola@gmail.com");
        Rooms r = new Rooms();
//        
//        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
        String current_date =  new SimpleDateFormat("yyyy-MM-dd").format(new Date()); 

////        insert        
//        r.setGuests(g);
//        r.setRoomNo(102);       
//        r.setRoomType("Budget Room");
//        r.setRoomRate(18000.0);
//        r.setNoOfNight(4);
//        r.setVat5(0.05*18000*4);
//        r.setConTax5(0.05*18000*4);
//        r.setChargeRate((18000-(0.05*18000+0.05*18000))*4);
//        r.setDeposite(50000.0);
//        r.setBalance(26000.0);
//        r.setNoOfGuestInRoom(2);
//        r.setNoOfLuggage(4);
//        r.setReasonForLodging("proximite to airport");        
//        r.setCreatedDate(createdDate);
//
//        daoImp.createdRoom(r);
        
        //update
//        r.setRoomId(3);
//        r.setGuests(g);
//        r.setRoomNo(103);       
//        r.setRoomType("Presidential Suit");
//        r.setRoomRate(BigDecimal.valueOf(18000));
//        r.setNoOfNight(2);
//        r.setVat5(BigDecimal.valueOf((0.05*18000)*2));
//        r.setConTax5(BigDecimal.valueOf((0.05*18000)*2));
//        r.setChargeRate(BigDecimal.valueOf((18000-(0.05*18000+0.05*18000))*2));
//        r.setDeposite(BigDecimal.valueOf(20000));
//        r.setBalance(BigDecimal.valueOf(16000));
//        r.setNoOfGuestInRoom(2);
//        r.setNoOfLuggage(4);
//        r.setReasonForLodging("lovely services offer by the hotel");        
//        r.setCreatedDate(createdDate);
//        daoImp.updateRoom(r);
//        
//        delete        
//        r.setRoomId(5);
//        daoImp.deleteRoom(r);
        
        //getAllGuestDetail
//        List<Rooms> listRm = daoImp.listRoom();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Rooms rm = (Rooms) it.next();
//            System.out.println(rm.getRoomId()+ " : "+ rm.getGuests().getEmail()+ " : "+rm.getGuests().getFirstName());           
//        }
//        List<Rooms> listRm = daoImp.listRoomNo();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Rooms rm = (Rooms) it.next();
//            System.out.println(rm.getRoomId()+ " : "+ rm.getGuests().getEmail()+ " : "+rm.getGuests().getFirstName());           
//        }
        
//        List<Rooms> listRm = daoImp.listRoomByID(3);
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Rooms rm = (Rooms) it.next();
//            System.out.println(rm.getRoomId()+ " : "+ rm.getGuests().getEmail()+ " : "+rm.getGuests().getFirstName());           
//        }
        //getAllGuestDetail
        List<Rooms> listRm = daoImp.listRoomCurrentlyInUse();
        for(Iterator it = listRm.iterator(); it.hasNext();){
            Rooms rm = (Rooms) it.next();
            System.out.println(rm.getRoomId()+ " : "+ rm.getGuests().getEmail()+ " : "+rm.getGuests().getFirstName()+ " : "+rm.getDepartureDate()+ " : "+current_date);           
        }

        //getAllGuestDetail
//        List<Rooms> listRm = daoImp.listRoomHistory();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Rooms rm = (Rooms) it.next();
//            System.out.println(rm.getRoomId()+ " : "+ rm.getGuests().getEmail()+ " : "+rm.getGuests().getFirstName()+ " : "+rm.getDepartureDate()+ " : "+current_date);           
//        }
        
//        System.out.println(daoImp.checkRoomId("RM2019020401"));
//        System.out.println(daoImp.listRoomNo());
        
    }
    
}
