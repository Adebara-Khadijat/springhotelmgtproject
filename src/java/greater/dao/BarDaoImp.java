package greater.dao;

import greater.pojo.BarPriceLists;
import greater.pojo.Bars;
import greater.pojo.GuestMasterBills;
import greater.pojo.Guests;
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
@Repository("barDao")
public class BarDaoImp implements BarDao {
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdBar(Bars b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();                
        session.save(b);
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
    public void updateBar(Bars b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        session.update(b);
        trans.commit();
    }

    @Override
    public void deleteBar(Bars b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();               
        session.delete(b);
        trans.commit();
    }

    @Override
    public List<Bars> listBarByID(String barId) {
        Bars bObj = new Bars();
        List<Bars> resList = new ArrayList<Bars>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Bars where id  = :id").setString("id", barId);
        bObj = (Bars)queryObj.uniqueResult();
        resList = queryObj.list();
        trans.commit();
        return resList;
    }

    @Override
    public List<Bars> listBar() {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Bars> listBar = session.createQuery("select b from Bars b").list();
        
        trans.commit();
        return listBar;
    }

    @Override
    public int checkBarID(String barId) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Bars where id = :id").setString("id", barId);			        
        List restList = q.list();
        for(Iterator it = restList.iterator(); it.hasNext();){
        Bars b =(Bars)it.next();
        if(b.getId().equals(barId)){                 
             return status=0;
            }             
          }              
          trans.commit();
          return status;
    }

    @Override
    public int checkBarEmail(String email) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Bars where email = :email").setString("email", email);			        
        List restList = q.list();
        for(Iterator it = restList.iterator(); it.hasNext();){
        Bars b =(Bars)it.next();
        if(b.getGuests().getEmail().equals(email)){                 
             return status=0;
            }             
        }              
            trans.commit();
            return status;
    }

    @Override         
    public List<Bars> listBarByEmail(String email) {        
        List<Bars> bList = new ArrayList<Bars>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Bars> listemail = session.createQuery("select b from Bars b where email = :email").setString("email", email).list();
        bList = listemail;       
        trans.commit();
        return bList;
    }

    @Override         
    public List<Bars> listBarByEmail(String email, String startDate, String endDate){        
        List<Bars> bList = new ArrayList<Bars>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Bars> listemail = session.createQuery("select b from Bars b where email = :email AND createdDate between :startDate and :endDate").setString("email", email).setString("startDate", startDate).setString("endDate", endDate).list();        
        bList = listemail;       
        trans.commit();
        return bList;
    }

    @Override
    public List<Bars> listBarBySumTotal(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Bars> listSumTotal = session.createQuery("select sum(total) from Bars where email = :email").setString("email", email).list();         
        String sumTotal = listSumTotal.toString().trim();
        trans.commit();
        return listSumTotal;
    }

    @Override
    public List<ServiceCharges> listServiceCharge(String email, String productDec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listServiceCharge = session.createQuery("select serviceCharge from ServiceCharges where email = :email AND productDescription =:productDec").setString("email", email).setString("productDec", productDec).list();         
        String serCharge = listServiceCharge.toString().trim();
//        System.out.println(serCharge);
        trans.commit();
        return listServiceCharge;
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotal(String email, String productDec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listGrandTotal = session.createQuery("select grandTotal from ServiceCharges where email = :email AND productDescription =:productDec").setString("email", email).setString("productDec", productDec).list();
        String gTotal = listGrandTotal.toString();       
        System.out.println(gTotal);
        trans.commit();
        return listGrandTotal;
    }

    @Override         
    public List<Bars> listBarByWalkInGuest(String WINGuest) {
        List<Bars> bList = new ArrayList<Bars>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Bars> listemail = session.createQuery("select b from Bars b where walkInGuestId  = :walkInGuestId").setString("walkInGuestId", WINGuest).list();
        bList = listemail;       
        trans.commit();
        return bList;
    }
    
    @Override         
    public List<Bars> listBarByWalkInGuest(String WINGuest, String startDate, String endDate) {
        List<Bars> bList = new ArrayList<Bars>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Bars> listemail = session.createQuery("select b from Bars b where walkInGuestId = :walkInGuestId AND createdDate between :startDate and :endDate").setString("walkInGuestId", WINGuest).setString("startDate", startDate).setString("endDate", endDate).list();                                     
        bList = listemail;       
        trans.commit();
        return bList;
    }
    
    @Override
    public int checkBarWalkInGuest(String WINGuest) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Bars where walkInGuestId = :walkInGuestId").setString("walkInGuestId", WINGuest);			        
        List barList = q.list();
        for(Iterator it = barList.iterator(); it.hasNext();){
        Bars b =(Bars)it.next();

        if(b.getWalkInGuestId().equals(WINGuest)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }

    @Override
    public List<Bars> listBarByWINGSumTotal(String WINGuest) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<Bars> listSumTotal = session.createQuery("select sum(total) from Bars where walkInGuestId = :walkInGuestId").setString("walkInGuestId", WINGuest).list();         
        String sumTotal = listSumTotal.toString().trim();
        trans.commit();
        return listSumTotal;
    }

    @Override
    public List<ServiceCharges> listSerChGrandTotalWinguest(String WINGuest, String productDec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listGrandTotal = session.createQuery("select grandTotal from ServiceCharges where walkInGuestId=:walkInGuestId AND productDescription =:productDec").setString("walkInGuestId", WINGuest).setString("productDec", productDec).list();
        String gTotal = listGrandTotal.toString();       
        trans.commit();
        return listGrandTotal;
    }

    @Override
    public List<ServiceCharges> listServiceChargeWinguest(String WINGuest, String productDec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        List<ServiceCharges> listServiceCharge = session.createQuery("select serviceCharge from ServiceCharges where walkInGuestId =:walkInGuestId AND productDescription =:productDec").setString("walkInGuestId", WINGuest).setString("productDec", productDec).list();         
        String serCharge = listServiceCharge.toString();
        trans.commit();
        return listServiceCharge;
    }

    @Override
    public List<Bars> listBarSumTotalDateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<Bars> listBar = session.createQuery("select sum(total) from Bars where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();        
//        String roomList = listRoom.toString();
//        System.out.println(roomList);
        trans.commit();
        return listBar;
    }

    @Override
    public List<Bars> listBarSumVat5DateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<Bars> listBar = session.createQuery("select sum(vat5) from Bars where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();        
        String roomList = listBar.toString();
        trans.commit();
        return listBar;
    }

    @Override
    public List<Bars> listBarSumConTax5DateBetween(String startDate, String endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();    
        List<Bars> listBar = session.createQuery("select sum(conTax5) from Bars where createdDate between :startDate and :endDate").setString("startDate", startDate).setString("endDate", endDate).list();        
        String roomList = listBar.toString();
        trans.commit();
        return listBar;
    }
    
        public static void main(String bar[]){
        BarDaoImp daoImp = new BarDaoImp();

        Guests g = new Guests();
        g.setEmail("abiola@gmail.com");

        BarPriceLists barPriceLists = new  BarPriceLists();
        barPriceLists.setBarPriceId(1);

        Bars b = new Bars();
        
        String createdDate =  new SimpleDateFormat("yyyy-MM-dd").format(new Date()); 
        String createdTime =  new SimpleDateFormat("HH:mm:ss").format(new Date()); 
        String id =  new SimpleDateFormat("yyyyMMddss").format(new Date()); 

//     id;   guests;     restaurantPriceLists;     companyName;    receiptNo;   roomNo;      tableNo;     mealType;
//     qty;  amount;      total;     vat5;     serviceCharge; conTax5;     waiterName;     guestSignature;     signture;
//     times;     createdDate;   chargeRate;     discountedRate;     authorizedDiscount;      approvedDiscount;
        
//      insert        
//        b.setId(id);
//        b.setGuests(g);        
//        b.setBarPriceLists(barPriceLists);
//        b.setReceiptNo(id);
//        b.setRoomNo("105");
//        b.setTableNo("106");
//        b.setMealType("Launch");
//        b.setQty(1);
//        b.setAmount(1000.0);
//        b.setDiscountedRate(800.0);
//        b.setDiscountedRate(800.0);
//        b.setTotal(800.0 * 1);
//        b.setVat5(800.0 * 0.05);
//        b.setConTax5(800.0 * 0.05);        
//        b.setWaiterName("Damilola");
//        b.setAuthorizedDiscount("CEO");
//        b.setApprovedDiscount("Mr. Adelabu");
//        b.setTimes(createdTime);
//        b.setCreatedDate(createdDate);
//
//        daoImp.createdBar(b);
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
        System.out.println(daoImp.listServiceCharge("oladeji@yahoo.com","Bar Service Charge").get(0));

//        
    }
    
}
