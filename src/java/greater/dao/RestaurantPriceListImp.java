package greater.dao;

import greater.pojo.RestaurantPriceLists;
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
@Repository("restaurantPriceListDao")
public class RestaurantPriceListImp implements RestaurantPriceListDao {
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdResPriceList(RestaurantPriceLists restPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.save(restPrice);
        trans.commit();
    }

    @Override
    public void updateResPriceList(RestaurantPriceLists restPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        session.update(restPrice);
        trans.commit();
    }

    @Override
    public void deleteResPriceList(RestaurantPriceLists restPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
               
        session.delete(restPrice);
        trans.commit();
    }

    @Override
    public List<RestaurantPriceLists> listResPriceListByID(int restPriceId) {
        RestaurantPriceLists rpObj = new RestaurantPriceLists();
        List<RestaurantPriceLists> rpList = new ArrayList<RestaurantPriceLists>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from RestaurantPriceLists where restaurantPriceId  = :restaurantPriceId").setInteger("restaurantPriceId", restPriceId);
        rpObj = (RestaurantPriceLists)queryObj.uniqueResult();
        rpList = queryObj.list();
        for(RestaurantPriceLists rp: rpList){
//            System.out.println(r.getRoomId());                        
//            System.out.println(r.getGuests().getEmail());            
//            System.out.println(r.getGuests().getGuestType());            
//            System.out.println(r.getRoomType());            
//            System.out.println(r.getRoomNo());            
        }
        trans.commit();
        return rpList;
    }

    @Override
    public List<RestaurantPriceLists> listResPriceList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("select r from RestaurantPriceLists r").list();
        
        trans.commit();
        return listRestPrice;
    }

    @Override
    public List<RestaurantPriceLists> pepperSoup() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("select  distinct foodType from RestaurantPriceLists where foodType='PEPPER SOUP'").list();
        trans.commit();
        return listRestPrice;
    }
    
    @Override
    public List<RestaurantPriceLists> allPepperSoup(){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("from RestaurantPriceLists where foodType='PEPPER SOUP'").list();
        trans.commit();
        return listRestPrice;
    }

    @Override
    public List<RestaurantPriceLists> peppered() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> peppered = session.createQuery("select distinct foodType from RestaurantPriceLists where foodType='PEPPERED'").list();        
        trans.commit();
        return peppered;
    }
    
    @Override
    public List<RestaurantPriceLists> allPepperred(){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("from RestaurantPriceLists where foodType='PEPPERED'").list();
        trans.commit();
        return listRestPrice;
    }
    
    @Override
    public List<RestaurantPriceLists> barbecue() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listBarbecue = session.createQuery("select distinct foodType from RestaurantPriceLists where foodType='BARBECUE'").list();
        String barbecue = listBarbecue.toString();
        trans.commit();
        return listBarbecue;
    }
    
    @Override
    public List<RestaurantPriceLists> allBarBecue(){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("from RestaurantPriceLists where foodType='BARBECUE'").list();
        trans.commit();
        return listRestPrice;
    }

    @Override
    public List<RestaurantPriceLists> byOrder() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listByOrder = session.createQuery("select distinct foodType from RestaurantPriceLists where foodType='BY ORDER'").list();
        String byOrder = listByOrder.toString();
        trans.commit();
        return listByOrder;
    }
    
    @Override
    public List<RestaurantPriceLists> allByOrder(){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("from RestaurantPriceLists where foodType='BY ORDER'").list();
        trans.commit();
        return listRestPrice;
    }
    
    @Override
    public List<RestaurantPriceLists> choiceOfFood(){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listChoiceOfFood = session.createQuery("select  distinct foodType from RestaurantPriceLists where foodType='CHOICE OF FOOD'").list();
        String choiceOfFood = listChoiceOfFood.toString();
        trans.commit();
        return listChoiceOfFood;
    }
    
    @Override
    public List<RestaurantPriceLists> allChoiceOfFood(){
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<RestaurantPriceLists> listRestPrice = session.createQuery("from RestaurantPriceLists where foodType='CHOICE OF FOOD'").list();
        trans.commit();
        return listRestPrice;
    }

    @Override
    public int checkResPriceListID(int restPriceId) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from RestaurantPriceLists where restaurantPriceId = :restaurantPriceId").setInteger("restaurantPriceId", restPriceId);			        
        List restPriceList = q.list();
        for(Iterator it = restPriceList.iterator(); it.hasNext();){
        RestaurantPriceLists r =(RestaurantPriceLists)it.next();

        if(r.getRestaurantPriceId().equals(restPriceId)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
      }
    
    
    public static void main(String employee[]){
        RestaurantPriceListImp daoImp = new RestaurantPriceListImp();//        
        RestaurantPriceLists r = new RestaurantPriceLists();
        
        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 

//        restaurantPriceId;
//     private String foodType;
//     private String foodDescription;
//     private Double amount;
//     private String createdDate;
        
//      insert        
//        r.setFoodType("PEPPER SOUP");
//        r.setFoodDescription("COW- LEG PEPPER SAUCE");
//        r.setAmount(1000.0);        
//        r.setCreatedDate(createdDate);
//
//        daoImp.createdResPriceList(r);
        
        //update
//        r.setRestaurantPriceId(2);
//        r.setFoodType("PEPPER SOUP");
//        r.setFoodDescription("COW-LEG PEPPER SAUCE, CHICKEN PEPPER SAUCE");
//        r.setAmount(1000.0);        
//        r.setCreatedDate(createdDate);
//
//        daoImp.updateResPriceList(r);
//        
//        delete        
//        r.setRestaurantPriceId(4);
//        daoImp.deleteResPriceList(r);
//        
        //getAllGuestDetail
//        List<RestaurantPriceLists> listRestPrice = daoImp.listResPriceList();
//        for(Iterator it = listRestPrice.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getRestaurantPriceId()+ " : "+ rest.getFoodType()+ " : "+rest.getFoodDescription()+" : "+rest.getAmount()+" : "+rest.getCreatedDate());           
//        }
        
//        List<RestaurantPriceLists> listRm = daoImp.listResPriceListByID(3);
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getRestaurantPriceId()+ " : "+ rest.getFoodType()+ " : "+rest.getFoodDescription()+" : "+rest.getAmount()+" : "+rest.getCreatedDate());           
//        }
        

        //getAllGuestDetail
//        List<RestaurantPriceLists> listRestP = daoImp.listRestaurantPricePepperSoup();
//        for(Iterator it = listRestP.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getFoodDescription()+ " : "+ rest.getAmount());           
//        }
        
        
//        daoImp.listRestaurantChoiceOfFood();
//        System.out.println(daoImp.checkResPriceListID(2));
//        System.out.println(daoImp.pepperSoup());
//        System.out.println(daoImp.peppered());        
//        List<RestaurantPriceLists> listRestP = daoImp.allPepperSoup();
//        for(Iterator it = listRestP.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getFoodDescription()+ " : "+ rest.getAmount());           
//        }

//        List<RestaurantPriceLists> listRestP = daoImp.allPepperred();
//        for(Iterator it = listRestP.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getFoodDescription()+ " : "+ rest.getAmount());           
//        }
        
//        List<RestaurantPriceLists> listRestP = daoImp.allByOrder();
//        for(Iterator it = listRestP.iterator(); it.hasNext();){
//            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
//            System.out.println(rest.getFoodDescription()+ " : "+ rest.getAmount());           
//        }
        
        List<RestaurantPriceLists> listRestP = daoImp.allChoiceOfFood();
        for(Iterator it = listRestP.iterator(); it.hasNext();){
            RestaurantPriceLists rest = (RestaurantPriceLists) it.next();
            System.out.println(rest.getFoodDescription()+ " : "+ rest.getAmount());           
        }
        

//        System.out.println(daoImp.checkResPriceListID(4));

            
    }

}

