package greater.dao;

import greater.pojo.RoomStatus;
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
@Repository("roomStatusDao")
public class RoomStatusDaoImp implements RoomStatusDao{
        
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdRoomStatus(RoomStatus rs) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.save(rs);
        trans.commit();
    }

    @Override
    public void updateRoomStatus(RoomStatus rs) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
               
        session.update(rs);
        trans.commit();
    }

    @Override
    public void deleteRoomStatus(RoomStatus rs) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        
        session.delete(rs);                         
        trans.commit();
    }

    @Override
    public List<RoomStatus> listRoomStatusByID(int roomStatusId) {
        RoomStatus rsObj = new RoomStatus();
        List<RoomStatus> rsList = new ArrayList<RoomStatus>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from RoomStatus where roomStatusId  = :roomStatusId").setInteger("roomStatusId", roomStatusId);
        rsObj = (RoomStatus)queryObj.uniqueResult();
        rsList = queryObj.list();
        for(RoomStatus r: rsList){
//            System.out.println(r.getRoomId());                        
//            System.out.println(r.getGuests().getEmail());            
//            System.out.println(r.getGuests().getGuestType());            
//            System.out.println(r.getRoomType());            
//            System.out.println(r.getRoomNo());            
        }
        trans.commit();
        return rsList;
    }

    @Override
    public List<RoomStatus> listRoomStatus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoom = session.createQuery("select rs from RoomStatus rs").list();
        
        trans.commit();
        return listRoom;
    }
    
    @Override
    public List<RoomStatus> listRoomStatusCurrently() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoom = session.createQuery("select rs from RoomStatus rs where createdDate = current_date()").list();
        
        trans.commit();
        return listRoom;
    }
    
    @Override
    public int checkRoomStatusId(int roomStatusId) {
        int status = 1;
             Session session = HibernateUtil.getSessionFactory().openSession();
             Transaction trans = session.beginTransaction();
             Query q = session.createQuery("from RoomStatus where roomStatusId  = :roomStatusId").setInteger("roomStatusId", roomStatusId);             
             List roomStatusList = q.list();
             for(Iterator it = roomStatusList.iterator(); it.hasNext();){
             RoomStatus rs =(RoomStatus)it.next();
             
             if(rs.getRoomStatusId().equals(roomStatusId)){                 
                 return status=0;
                }             
             }              
             trans.commit();
             return status;
    }
        
    @Override    
    public List<RoomStatus> listCountRoomStatusVC() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Vacant Clean' AND createdDate = current_date()").list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    @Override
    public List<RoomStatus> listCountRoomStatusVD() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Vacant Dirty' AND createdDate = current_date()").list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    @Override
    public List<RoomStatus> listCountRoomStatusOD() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Occupied Dirty' AND createdDate = current_date()").list();
        
        trans.commit();
        return listRoomStatusVC;
    }

    @Override
    public List<RoomStatus> listCountRoomStatusOO() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Out of Order Room' AND createdDate = current_date()").list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    
    @Override
    public List<RoomStatus> listCountRoomStatusTotal(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus where createdDate = current_date()").list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    //fetching date between from database     
    @Override
    public List<RoomStatus> listRoomStatusDateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    //select distinct createdDate from room_status
        List<RoomStatus> listRoom = session.createQuery("select distinct rs from RoomStatus rs where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();
        
        trans.commit();
        return listRoom;
    }
        
    @Override
    public List<RoomStatus> listCountRoomStatusDateVC(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Vacant Clean' AND createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    @Override
    public List<RoomStatus> listCountRoomStatusDateOD(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Occupied Dirty' AND createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    @Override
    public List<RoomStatus> listCountRoomStatusDateVD(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Vacant Dirty' AND createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();
        
        trans.commit();
        return listRoomStatusVC;
    }

    @Override
    public List<RoomStatus> listCountRoomStatusDateOO(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus  where statesOfTheRoom ='Out of Order Room' AND createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
    @Override
    public List<RoomStatus> listCountRoomStatusDateTotal(String startDate, String endDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RoomStatus> listRoomStatusVC = session.createQuery("select count(statesOfTheRoom) from RoomStatus where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();
        
        trans.commit();
        return listRoomStatusVC;
    }
    
               
//    public static void main(String employee[]){
//        RoomStatusDaoImp daoImp = new RoomStatusDaoImp();
//        RoomStatus rs = new RoomStatus();
//
//        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
//        roomStatusId, roomNo, roomType, statesOfTheRoom, tv, intecom, ac, fridge, lightingPoint, beding,
//furniture, toilet, toiletries, remarks, createdDate
////        insert        
//        rs.setRoomNo(209);
//        rs.setRoomType("Classic");
//        rs.setStatesOfTheRoom("Out of Order Room");
//        rs.setTv("OK");
//        rs.setIntecom("OK");
//        rs.setAc("OK");
//        rs.setFridge("OK");
//        rs.setLightingPoint("OK");
//        rs.setBeding("OK");
//        rs.setFurniture("OK");
//        rs.setToilet("OK");
//        rs.setToiletries("OK");
//        rs.setRemarks("OK");
//        rs.setCreatedDate(createdDate);
//        daoImp.createdRoomStatus(rs);
//        
        //update        
//        rs.setRoomStatusId(17);
//        rs.setRoomNo(208);
//        rs.setRoomType("Budget");
//        rs.setStatesOfTheRoom("Out of Order Room");
//        rs.setTv("OK");
//        rs.setIntecom("OK");
//        rs.setAc("OK");
//        rs.setFridge("OK");
//        rs.setLightingPoint("OK");
//        rs.setBeding("OK");
//        rs.setFurniture("OK");
//        rs.setToilet("OK");
//        rs.setToiletries("OK");
//        rs.setRemarks("OK");
//        rs.setCreatedDate(createdDate);
//        daoImp.updateRoomStatus(rs);
//        
//        delete        
//        rs.setRoomStatusId(19);
//        daoImp.deleteRoomStatus(rs);
        
        //getAllGuestDetail
//        List<RoomStatus> listRm = daoImp.listRoomStatus();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            RoomStatus rm = (RoomStatus) it.next();
//            System.out.println(rm.getRoomStatusId()+ " : "+ rm.getStatesOfTheRoom()+ " : "+rm.getRoomNo());           
//        }   
        //getAllGuestDetail
//        List<RoomStatus> listRm = daoImp.listRoomStatusByID("10");
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            RoomStatus rm = (RoomStatus) it.next();
//            System.out.println(rm.getRoomStatusId()+ " : "+ rm.getStatesOfTheRoom()+ " : "+rm.getRoomNo());           
//        }
                
        //getAllGuestDetail
//        List<Rooms> listRm = daoImp.listRoomCurrentlyInUse();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Rooms rm = (Rooms) it.next();
//            System.out.println(rm.getRoomId()+ " : "+ rm.getGuests().getEmail()+ " : "+rm.getGuests().getFirstName()+ " : "+rm.getDepartureDate()+ " : "+current_date);           
//        }
        

        //getAllGuestDetail        
//        List<RoomStatus> listRm = daoImp.listCountRoomStatusVC();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            RoomStatus rm = (RoomStatus) it.next();
//            System.out.println(rm.getAc());     
        
//        List<RoomStatus> listRm = daoImp.listRoomStatusCurrently();
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            RoomStatus rm = (RoomStatus) it.next();
//            System.out.println(rm.getRoomNo()+" : "+rm.getCreatedDate());           
//        }

//        System.out.println(daoImp.listCountRoomStatusVC());
//        System.out.println(daoImp.listCountRoomStatusVD());
//        System.out.println(daoImp.listCountRoomStatusOD());
//        System.out.println(daoImp.listCountRoomStatusOO());
                
//getAllGuestDetail
//        List<RoomStatus> listRm = daoImp.listRoomStatusDateBetween("2019-02-01", "2019-02-10");
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            RoomStatus rm = (RoomStatus) it.next();
//            System.out.println(rm.getRoomNo()+ " : "+ rm.getStatesOfTheRoom()+ " : "+rm.getCreatedDate()+ " : "+rm.getFridge()+ " : "+rm.getIntecom());           
//        }        
////        
//        System.out.println("VC: "+daoImp.listCountRoomStatusDateVC("2019-02-01","2019-02-10"));
//        System.out.println("VD: "+daoImp.listCountRoomStatusDateVD("2019-02-01","2019-02-10"));
//        System.out.println("OD: "+daoImp.listCountRoomStatusDateOD("2019-02-01","2019-02-10"));
//        System.out.println("OO: "+daoImp.listCountRoomStatusDateOO("2019-02-01","2019-02-10"));
//        System.out.println("Total: "+daoImp.listCountRoomStatusDateTotal("2019-02-01","2019-02-10"));
        
//    }
    
    
}
