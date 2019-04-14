package greater.dao;

import greater.pojo.BarPriceLists;
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
@Repository("barPriceListDao")
public class BarPriceListDaoImp implements BarPriceListDao {
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdBarPriceList(BarPriceLists barPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        session.save(barPrice);
        trans.commit();
    }

    @Override
    public void updateBarPriceList(BarPriceLists barPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        session.update(barPrice);
        trans.commit();
    }

    @Override
    public void deleteBarPriceList(BarPriceLists barPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();               
        session.delete(barPrice);
        trans.commit();
    }

    @Override
    public List<BarPriceLists> listBarPriceListByID(int barPriceId) {  
        BarPriceLists bObj = new BarPriceLists();
        List<BarPriceLists> rpList = new ArrayList<BarPriceLists>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from BarPriceLists where barPriceId  = :barPriceId").setInteger("barPriceId", barPriceId);
        bObj = (BarPriceLists)queryObj.uniqueResult();
        rpList = queryObj.list();
        for(BarPriceLists rp: rpList){
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
    public List<BarPriceLists> listBarPriceList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listBarPrice = session.createQuery("select b from BarPriceLists b").list();        
        trans.commit();
        return listBarPrice;
    }

    @Override
    public int checkBarPriceListID(int barPriceId) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from BarPriceLists where barPriceId = :barPriceId").setInteger("barPriceId", barPriceId);			        
        List restPriceList = q.list();
        for(Iterator it = restPriceList.iterator(); it.hasNext();){
        BarPriceLists b =(BarPriceLists)it.next();

        if(b.getBarPriceId().equals(barPriceId)){                 
             return status=0;
            }             
          }              
             trans.commit();
             return status;
    }

    @Override
    public List<BarPriceLists> wine() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listWine = session.createQuery("select distinct drinkType from BarPriceLists where drinkType='WINE'").list();
        String wine = listWine.toString();
        trans.commit();
        return listWine;
    }

    @Override
    public List<BarPriceLists> allWine() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();                                 
        List<BarPriceLists> listAllWine = session.createQuery("from BarPriceLists where drinkType='WINE'").list();
        trans.commit();
        return listAllWine;
    }

    @Override
    public List<BarPriceLists> beer() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listBeer = session.createQuery("select distinct drinkType from BarPriceLists where drinkType='BEER'").list();
        String beer = listBeer.toString();        
        trans.commit();
        return listBeer;
    }

    @Override
    public List<BarPriceLists> allBeer() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();                                 
        List<BarPriceLists> listAllBeer = session.createQuery("from BarPriceLists where drinkType='BEER'").list();
        trans.commit();
        return listAllBeer;
    }

    @Override
    public List<BarPriceLists> spirit() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listSpirit = session.createQuery("select distinct drinkType from BarPriceLists where drinkType='SPIRIT'").list();
        String spirit = listSpirit.toString();
        trans.commit();
        return listSpirit;
    }

    @Override
    public List<BarPriceLists> allSpirit() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();                                 
        List<BarPriceLists> listAllSpirit = session.createQuery("from BarPriceLists where drinkType='SPIRIT'").list();
        trans.commit();
        return listAllSpirit;
    }

    @Override
    public List<BarPriceLists> softDrink() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listSoftDrink = session.createQuery("select distinct drinkType from BarPriceLists where drinkType='SOFT DRINKS'").list();
        String softDrink = listSoftDrink.toString();
        trans.commit();
        return listSoftDrink;
    }

    @Override
    public List<BarPriceLists> allSoftDrink() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();                                 
        List<BarPriceLists> listAllSoftDrink = session.createQuery("from BarPriceLists where drinkType='SOFT DRINKS'").list();
        trans.commit();
        return listAllSoftDrink;
    }

    @Override
    public List<BarPriceLists> herbalAlcohol() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listHerbalAlcohol = session.createQuery("select distinct drinkType from BarPriceLists where drinkType='HERBAL (ALCOHOL)'").list();
        String herbalAlcohol = listHerbalAlcohol.toString();
        trans.commit();
        return listHerbalAlcohol;
    }

    @Override
    public List<BarPriceLists> allHerbalAlcohol() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();                                 
        List<BarPriceLists> listAllHerbalAlcohol = session.createQuery("from BarPriceLists where drinkType='HERBAL (ALCOHOL)'").list();
        trans.commit();
        return listAllHerbalAlcohol;
    }

    @Override
    public List<BarPriceLists> juice() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();
        List<BarPriceLists> listJuice = session.createQuery("select distinct drinkType from BarPriceLists where drinkType='JUICE'").list();
        String juice = listJuice.toString();
        trans.commit();
        return listJuice;
    }

    @Override
    public List<BarPriceLists> allJuice() {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        Transaction trans = session.beginTransaction();                                 
        List<BarPriceLists> listAllJuice = session.createQuery("from BarPriceLists where drinkType='JUICE'").list();
        trans.commit();
        return listAllJuice;
    }
    
    public static void main(String employee[]){
        BarPriceListDaoImp daoImp = new BarPriceListDaoImp();//        
        BarPriceLists b = new BarPriceLists();
        
        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 

//private Integer barPriceId;
//     private String drinkType;
//     private String drinkDescription;
//     private Double vat5;
//     private Double conTax5;
//     private Double amount;
//     private String createdDate;        
//      insert        
//        b.setDrinkType("JUICE");
//        b.setDrinkDescription("CHI - EXOTIC");
//        b.setVat5((5.0/100) * 800.0);
//        b.setConTax5((5.0/100) * 800.0);
//        b.setAmount(800.00 + ((5.0/100) * 800.0) + ((5.0/100) * 800.0));
//        b.setCreatedDate(createdDate);
//        
//        daoImp.createdBarPriceList(b);
        
        //update

//        b.setBarPriceId(13);
//        b.setDrinkType("JUICE");
//        b.setDrinkDescription("CHI-EXOTIC");
//        b.setVat5((5.0/100) * 800.0);
//        b.setConTax5((5.0/100) * 800.0);
//        b.setAmount(800.00 + ((5.0/100) * 800.0) + ((5.0/100) * 800.0));
//        b.setCreatedDate(createdDate);
//        daoImp.updateBarPriceList(b);

//        
//        delete        
//        b.setBarPriceId(14);
//        daoImp.deleteBarPriceList(b);
//        
        //getAllGuestDetail
//        List<BarPriceLists> listRestPrice = daoImp.listBarPriceList();
//        for(Iterator it = listRestPrice.iterator(); it.hasNext();){
//            BarPriceLists bar = (BarPriceLists) it.next();
//            System.out.println(bar.getBarPriceId()+ " : "+ bar.getDrinkType()+ " : "+bar.getDrinkDescription()+" : "+bar.getAmount()+" : "+bar.getCreatedDate());           
//        }
        
//        List<BarPriceLists> listRm = daoImp.listBarPriceListByID(13);
//        for(Iterator it = listRm.iterator(); it.hasNext();){
//            BarPriceLists bar = (BarPriceLists) it.next();
//            System.out.println(bar.getBarPriceId()+ " : "+ bar.getDrinkType()+ " : "+bar.getDrinkDescription()+" : "+bar.getAmount()+" : "+bar.getCreatedDate());                      
//        }
        

        //getAllGuestDetail
//        List<BarPriceLists> listBeer = daoImp.allBeer();
//        for(Iterator it = listBeer.iterator(); it.hasNext();){
//            BarPriceLists bar = (BarPriceLists) it.next();
//            System.out.println(bar.getDrinkType()+ " : "+bar.getDrinkDescription()+ " : "+ bar.getAmount());           
//        }
//        
//        System.out.println(daoImp.beer().get(0));
//        System.out.println(daoImp.checkBarPriceListID(12));
    }
    
}
