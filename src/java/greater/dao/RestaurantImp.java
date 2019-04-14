package greater.dao;

import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
import greater.pojo.RestaurantPriceLists;
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
@Repository("restaurantDao")
public class RestaurantImp implements RestaurantDao{
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdRestaurant(Restaurants res) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
//        RestaurantPriceLists rp = new RestaurantPriceLists();
                
        session.save(res);
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
    public void updateRestaurant(Restaurants res) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.update(res);
        trans.commit();
    }

    @Override
    public void deleteRestaurant(Restaurants res) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
               
        session.delete(res);
        trans.commit();
    }

    @Override
    public List<Restaurants> listRestaurantByID(String restId) {
        Restaurants resObj = new Restaurants();
        List<Restaurants> resList = new ArrayList<Restaurants>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Restaurants where id  = :id").setString("id", restId);
        resObj = (Restaurants)queryObj.uniqueResult();
        resList = queryObj.list();
        for(Restaurants res: resList){
//            System.out.println(r.getRoomId());                        
//            System.out.println(r.getGuests().getEmail());            
//            System.out.println(r.getGuests().getGuestType());            
//            System.out.println(r.getRoomType());            
//            System.out.println(r.getRoomNo());            
        }
        trans.commit();
        return resList;
    }
    
    @Override             
    public List<Restaurants> listRestaurantByEmail(String email) {
        Restaurants resObj = new Restaurants();
        List<Restaurants> resList = new ArrayList<Restaurants>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Restaurants> listemail = session.createQuery("select res from Restaurants res where email  = :email").setString("email", email).list();
        resList = listemail;       
        trans.commit();
        return resList;
    }
    
    @Override
    public List<Restaurants> listRestaurantByEmail(String email, String startDate, String endDate) {
        Restaurants resObj = new Restaurants();
        List<Restaurants> resList = new ArrayList<Restaurants>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();                
        List<Restaurants> listemail = session.createQuery("select res from Restaurants res where email = :email AND createdDate between :startDate and :endDate").setString("email", email).setString("startDate", startDate).setString("endDate", endDate).list();
        resList = listemail;       
        trans.commit();
        return resList;
    }
    
    @Override                
    public List<Restaurants> listRestaurantByWalkInGuest(String WINGuest) {        
        List<Restaurants> resList = new ArrayList<Restaurants>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Restaurants> listemail = session.createQuery("select res from Restaurants res where walkInGuestId  = :walkInGuestId").setString("walkInGuestId", WINGuest).list();
                                                        
        resList = listemail;       
        trans.commit();
        return resList;
    }
    
    @Override                
    public List<Restaurants> listRestaurantByWalkInGuest(String WINGuest,String startDate, String endDate) {        
        List<Restaurants> resList = new ArrayList<Restaurants>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Restaurants> listemail = session.createQuery("select res from Restaurants res where walkInGuestId  = :walkInGuestId AND createdDate between :startDate and :endDate").setString("walkInGuestId", WINGuest).setString("startDate", startDate).setString("endDate", endDate).list();
                                                        
        resList = listemail;       
        trans.commit();
        return resList;
    }
             
    @Override    
    public List<Restaurants> listRestaurantBySumTotal(String email) {     
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Restaurants> listSumTotal = session.createQuery("select sum(total) from Restaurants where email  = :email").setString("email", email).list();         
        String sumTotal = listSumTotal.toString().trim();
        trans.commit();
        return listSumTotal;
    }
    
    @Override
    public List<Restaurants> listRestaurantByWINGSumTotal(String WINGuest) {     
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Restaurants> listSumTotal = session.createQuery("select sum(total) from Restaurants where walkInGuestId = :walkInGuestId").setString("walkInGuestId", WINGuest).list();         
        String sumTotal = listSumTotal.toString().trim();
        trans.commit();
        return listSumTotal;
    }

    @Override
    public List<Restaurants> listRestaurant() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Restaurants> listRes = session.createQuery("select res from Restaurants res").list();
        
        trans.commit();
        return listRes;
    }

    @Override
    public int checkRestaurantID(String restId) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Restaurants where id = :id").setString("id", restId);			        
        List restList = q.list();
        for(Iterator it = restList.iterator(); it.hasNext();){
        Restaurants res =(Restaurants)it.next();

        if(res.getId().equals(restId)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }    
    
    @Override
    public int checkRestaurantEmail(String email) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Restaurants where email = :email").setString("email", email);			        
        List restList = q.list();
        for(Iterator it = restList.iterator(); it.hasNext();){
        Restaurants res =(Restaurants)it.next();

        if(res.getGuests().getEmail().equals(email)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }
    
    @Override
    public int checkRestaurantWalkInGuest(String WINGuest) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Restaurants where walkInGuestId = :walkInGuestId").setString("walkInGuestId", WINGuest);			        
        List restList = q.list();
        for(Iterator it = restList.iterator(); it.hasNext();){
        Restaurants res =(Restaurants)it.next();

        if(res.getWalkInGuestId().equals(WINGuest)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }    
    
    @Override
    public List<ServiceCharges> listServiceCharge(String email) {     
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listServiceCharge = session.createQuery("select serviceCharge from ServiceCharges where email  = :email AND productDescription='Restaurant Service Charge'").setString("email", email).list();         
        String serCharge = listServiceCharge.toString().trim();
        System.out.println(serCharge);
        trans.commit();
        return listServiceCharge;
    }
    
    @Override
    public List<ServiceCharges> listSerChGrandTotal(String email) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listGrandTotal = session.createQuery("select grandTotal from ServiceCharges where email  = :email").setString("email", email).list();
        String gTotal = listGrandTotal.toString();       
        System.out.println(gTotal);
        trans.commit();
        return listGrandTotal;
    }
    
    @Override
    public List<ServiceCharges> listSerChGrandTotalWinguest(String WINGuest) {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listGrandTotal = session.createQuery("select grandTotal from ServiceCharges where walkInGuestId = :walkInGuestId").setString("walkInGuestId", WINGuest).list();
        String gTotal = listGrandTotal.toString();       
//        System.out.println(gTotal);
        trans.commit();
        return listGrandTotal;
    }
        
    @Override
    public List<ServiceCharges> listServiceChargeWinguest(String WINGuest) {     
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listServiceCharge = session.createQuery("select serviceCharge from ServiceCharges where walkInGuestId  = :walkInGuestId AND productDescription='Restaurant Service Charge'").setString("walkInGuestId", WINGuest).list();         
        String serCharge = listServiceCharge.toString().trim();
//        System.out.println(serCharge);
        trans.commit();
        return listServiceCharge;
    }
    
    @Override    
    public List<Restaurants> listRestSumTotalDateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<Restaurants> listRoom = session.createQuery("select sum(total) from Restaurants where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();        
//        String roomList = listRoom.toString();
//        System.out.println(roomList);
        trans.commit();
        return listRoom;
    }
    
    @Override
    public List<Restaurants> listRestSumVat5DateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<Restaurants> listRoom = session.createQuery("select sum(vat5) from Restaurants where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();        
//        String roomList = listRoom.toString();
//        System.out.println(roomList);
        trans.commit();
        return listRoom;
    }
    
    @Override    
    public List<Restaurants> listRestSumConTax5DateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<Restaurants> listRoom = session.createQuery("select sum(conTax5) from Restaurants where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();        
//        String roomList = listRoom.toString();
//        System.out.println(roomList);
        trans.commit();
        return listRoom;
    }
    
    public static void main(String employee[]){
        RestaurantImp daoImp = new RestaurantImp();

        Guests g = new Guests();
        g.setEmail("adelabu@gmail.com");

        RestaurantPriceLists restaurantPriceLists = new  RestaurantPriceLists();
        restaurantPriceLists.setRestaurantPriceId(2);

        Restaurants re = new Restaurants();
        
        String createdDate =  new SimpleDateFormat("yyyy-MM-dd").format(new Date()); 
        String createdTime =  new SimpleDateFormat("HH:mm:ss").format(new Date()); 
        String id =  new SimpleDateFormat("yyyyMMddss").format(new Date()); 

//     id;   guests;     restaurantPriceLists;     companyName;    receiptNo;   roomNo;      tableNo;     mealType;
//     qty;  amount;      total;     vat5;     serviceCharge; conTax5;     waiterName;     guestSignature;     signture;
//     times;     createdDate;   chargeRate;     discountedRate;     authorizedDiscount;      approvedDiscount;
        
//      insert        
//        re.setId(id);
////        re.setGuests(g);        
//        re.setRestaurantPriceLists(restaurantPriceLists);
//        re.setReceiptNo(id);
//        re.setRoomNo("105");
//        re.setTableNo("106");
//        re.setMealType("Launch");
//        re.setQty(1);
//        re.setAmount(1000.0);
//        re.setDiscountedRate(800.0);
//        re.setDiscountedRate(800.0);
//        re.setTotal(800.0 * 1);
//        re.setVat5(800.0 * 0.05);
//        re.setConTax5(800.0 * 0.05);        
//        re.setWaiterName("Damilola");
//        re.setAuthorizedDiscount("CEO");
//        re.setApprovedDiscount("Mr. Adelabu");
//        re.setTimes(createdTime);
//        re.setCreatedDate(createdDate);
//
//        daoImp.createdRestaurant(re);
//        
        //update
//        re.setId("2019021428");
//        re.setGuests(g);
//        re.setCompanyName("Ade's Commercial Farming");
//        re.setRestaurantPriceLists(restaurantPriceLists);
//        re.setReceiptNo(id);
//        re.setRoomNo("105");
//        re.setTableNo("106");
//        re.setMealType("Dinner");
//        re.setQty(1);
//        re.setAmount(1000.0);
//        re.setChargeRate(800.0);
//        re.setDiscountedRate(800.0);
//        re.setTotal(800.0 * 1);
//        re.setVat5(800.0 * 0.05);
//        re.setConTax5(800.0 * 0.05);
//        re.setServiceCharge(800.0 * 0.10);
//        re.setWaiterName("Damilola");
//        re.setAuthorizedDiscount("CEO");
//        re.setApprovedDiscount("Mr. Adelabu");
//        re.setTimes(createdTime);
//        re.setCreatedDate(createdDate);
//
//        daoImp.updateRestaurant(re);
                
//        delete        
//        re.setId("2019021403");
//        daoImp.deleteRestaurant(re);
        
        //getAllGuestDetail
//        List<Restaurants> listRestaurant = daoImp.listRestaurant();
//        for(Iterator it = listRestaurant.iterator(); it.hasNext();){
//            Restaurants rest = (Restaurants) it.next();
//            System.out.println(rest.getId()+ " : "+ rest.getGuests().getEmail()+ " : "+rest.getCompanyName()+" : "+rest.getAmount()+" : "+rest.getCreatedDate());           
//        }
        
//        List<Restaurants> listRm = daoImp.listRestaurantByID("2019021406");
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Restaurants rest = (Restaurants) it.next();
//            System.out.println(rest.getId()+ " : "+ rest.getGuests().getEmail()+ " : "+rest.getCompanyName()+" : "+rest.getAmount()+" : "+rest.getCreatedDate());
//        }
        
//        List<Restaurants> listRm = daoImp.listRestaurantByEmail("hameedah@gmail.com");
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Restaurants rest = (Restaurants) it.next();
//            System.out.println(rest.getId()+ " : "+ rest.getGuests().getFirstName()+" "+rest.getGuests().getFirstName()+ " : "+rest.getGuests().getCompanyName()+" : "+rest.getTotal()+" : "+rest.getCreatedDate());
//        }
//        
//        List<Restaurants> listRm = daoImp.listRestaurantByWalkInGuest("WING-2019-0001");
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            Restaurants rest = (Restaurants) it.next();
//            System.out.println(rest.getId()+ " : "+ rest.getWalkInGuestId()+" "+rest.getReceiptNo()+ " : "+rest.getAmount()+" : "+rest.getTotal()+" : "+rest.getCreatedDate());
//        }


//        System.out.println(daoImp.listRestSumTotalDateBetween("2019-02-02", "2019-02-10"));
//        System.out.println(daoImp.listRestSumConTax5DateBetween("2019-02-02", "2019-02-10"));
//        System.out.println(daoImp.listRestSumConTax5DateBetween("2019-02-02", "2019-02-10"));
//        System.out.println(daoImp.listRestaurantBySumTotal("hameedah@gmail.com"));
        
        
        //getAllGuestDetail
//        List<RestaurantPriceLists> listRestP = daoImp.listRestaurantPricePepperSoup();
//        for(Iterator it = listRestP.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getFoodDescription()+ " : "+ rest.getAmount());           
//        }
        
//        daoImp.listRestaurantChoiceOfFood();
//        System.out.println(daoImp.checkResPriceListID(2));
//        System.out.println(daoImp.checkRestaurantWalkInGuest("WING-2019-0001"));
//        System.out.println(daoImp.listServiceCharge("oladeji@yahoo.com"));
        System.out.println(daoImp.listServiceChargeWinguest("WING-2019-0001"));

    }
}
