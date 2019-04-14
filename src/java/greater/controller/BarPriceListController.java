package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.BarPriceLists;
import greater.service.BarPriceListService;
import greater.service.RestaurantPriceListService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name="barPriceListController")
@RequestScoped
public class BarPriceListController implements Serializable {
    
    @ManagedProperty(value="#{barPriceListService}")
    
    @Autowired
    BarPriceListService barPriceListService;

    public BarPriceListService getBarPriceListService() {
        return barPriceListService;
    }

    public void setBarPriceListService(BarPriceListService barPriceListService) {
        this.barPriceListService = barPriceListService;
    }
    
     private Integer barPriceId;
     private String drinkType;
     private String drinkDescription;
     private Double vat5;
     private Double conTax5;
     private Double amount;
     private String createdDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    
     private String mgsError;

    public Integer getBarPriceId() {
        return barPriceId;
    }

    public void setBarPriceId(Integer barPriceId) {
        this.barPriceId = barPriceId;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public Double getVat5() {
        return vat5;
    }

    public void setVat5(Double vat5) {
        this.vat5 = vat5;
    }

    public Double getConTax5() {
        return conTax5;
    }

    public void setConTax5(Double conTax5) {
        this.conTax5 = conTax5;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMgsError() {
        return mgsError;
    }

    public void setMgsError(String mgsError) {
        this.mgsError = mgsError;
    }
     
    public BarPriceListController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    
    public String saveBarPrice(){                 
        BarPriceLists barPrice = new BarPriceLists();
        
        vat5 = 0.05 * amount;        
        conTax5 = 0.05 * amount;
        amount = amount + vat5 + conTax5;

//            barPrice.setBarPriceId(barPriceId);
            barPrice.setDrinkType(drinkType);
            barPrice.setDrinkDescription(drinkDescription);
            barPrice.setConTax5(conTax5);
            barPrice.setVat5(vat5);
            barPrice.setAmount(amount);            
            barPrice.setCreatedDate(createdDate);                 
            
            barPriceListService.createdBarPriceList(barPrice);
            setFieldToNull();
            mgsError="Bar Price List Record Created!!!";
                      
            String sEmail = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            String sUserRoleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sUserRoleId").toString();
            String sPassword = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPassword").toString();
            String sFirstName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sFirstName").toString();
            String sLastName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sLastName").toString();
            String sSex = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sSex").toString();
            String sPhone = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPhone").toString();
            String sAddress = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sAddress").toString();
            String sPosition = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPosition").toString();
            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Create Bar Price List with ID "+barPrice.getBarPriceId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_bar_price";
    }        
    
        public String updateBarPrice(){        
        BarPriceLists barPrice = new BarPriceLists();
        
        int mgs = barPriceListService.checkBarPriceListID(barPriceId);
        if(mgs ==0){           
            
        vat5 = 0.05 * amount;        
        conTax5 = 0.05 * amount;
        amount = amount + vat5 + conTax5;
            
            barPrice.setBarPriceId(barPriceId);
            barPrice.setDrinkType(drinkType);
            barPrice.setDrinkDescription(drinkDescription);
            barPrice.setConTax5(conTax5);
            barPrice.setVat5(vat5);
            barPrice.setAmount(amount);            
            barPrice.setCreatedDate(createdDate);                 
            
            barPriceListService.updateBarPriceList(barPrice);
            setFieldToNull();            
            mgsError="Bar Price List Record Updated !!!";          
            
            String sEmail = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            String sUserRoleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sUserRoleId").toString();
            String sPassword = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPassword").toString();
            String sFirstName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sFirstName").toString();
            String sLastName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sLastName").toString();
            String sSex = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sSex").toString();
            String sPhone = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPhone").toString();
            String sAddress = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sAddress").toString();
            String sPosition = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPosition").toString();
            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Update Bar Price List with ID "+barPrice.getBarPriceId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
        }
            else if(mgs !=0){
            mgsError="Bar Price List Record Does Not Exist!!!"; 
        }
        return "hotel_bar_price_edit";
    }
        
        public String deleteBarPrice(){
        BarPriceLists barPrice = new BarPriceLists();
                                                                
        int mgs = barPriceListService.checkBarPriceListID(barPriceId);
        if(mgs ==0){
            
            barPrice.setBarPriceId(barPriceId);
            barPrice.setDrinkType(drinkType);
            barPrice.setDrinkDescription(drinkDescription);
            barPrice.setConTax5(conTax5);
            barPrice.setVat5(vat5);
            barPrice.setAmount(amount);            
            barPrice.setCreatedDate(createdDate);                             
            
            barPriceListService.deleteBarPriceList(barPrice);
            setFieldToNull();            
            mgsError="Bar Price List Record Delete !!!";                    
            
            String sEmail = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sEmail").toString();
            String sUserRoleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sUserRoleId").toString();
            String sPassword = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPassword").toString();
            String sFirstName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sFirstName").toString();
            String sLastName = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sLastName").toString();
            String sSex = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sSex").toString();
            String sPhone = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPhone").toString();
            String sAddress = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sAddress").toString();
            String sPosition = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sPosition").toString();
            String sCreatedDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sCreatedDate").toString();
                        
            audit.setEmail(sEmail);
            audit.setUserRoleId(sUserRoleId);
            audit.setOperation("Delete Bar Price List with ID "+barPrice.getBarPriceId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       
        }
            else if(mgs !=0){
            mgsError="Bar Price List Record Does Not Exist!!!"; 
        }
                 
        return "hotel_bar_price_edit";
    }
        
        // Method To Fetch Particular Restaurant Details From The Database
	public String getBarDetailsByID() { 
            BarPriceLists barPrice = new BarPriceLists();                           
            List<BarPriceLists> barList = barPriceListService.listBarPriceListByID(barPriceId);
                
            int checkBarPriceId = barPriceListService.checkBarPriceListID(barPriceId);                
                if(checkBarPriceId==0){                   
		for(Iterator it = barList.iterator(); it.hasNext();) {                    
                    barPrice = (BarPriceLists)it.next();                                       
                    
                    barPriceId = barPrice.getBarPriceId();
                    drinkType = barPrice.getDrinkType();
                    drinkDescription = barPrice.getDrinkDescription();
                    conTax5 = barPrice.getConTax5();
                    vat5 =barPrice.getVat5();
                    amount = barPrice.getAmount();
                    createdDate = barPrice.getCreatedDate();                                                        
  		  }
                }else if(checkBarPriceId!=0){
                    setMgsError("Bar Price List Record does not Exist!!");                                                          
                }           
		return "hotel_bar_price_edit";
	}
        
        // Method To Fetch All Restaurant Price Lists Details From The Database
    public List<BarPriceLists> getBarPriceDetails() {            
            BarPriceLists barPrice = new BarPriceLists();
                        
            List<BarPriceLists> barPriceList = barPriceListService.listBarPriceList();
		for(Iterator it = barPriceList.iterator();it.hasNext();) {                    
                    barPrice = (BarPriceLists)it.next();
                                        
                    barPriceId = barPrice.getBarPriceId();
                    drinkType = barPrice.getDrinkType();
                    drinkDescription = barPrice.getDrinkDescription();
                    conTax5 = barPrice.getConTax5();
                    vat5 =barPrice.getVat5();
                    amount = barPrice.getAmount();
                    createdDate = barPrice.getCreatedDate();
		}               
		return barPriceList;
	}
    
    public List<BarPriceLists> getWine() {                                      
        List<BarPriceLists> wine = barPriceListService.wine();
        return wine;
    }
   
    public List<BarPriceLists> getAllWine() {                                      
        List<BarPriceLists> allWine = barPriceListService.allWine();
        return allWine;
    }
    
    public List<BarPriceLists> getBeer() {                                      
        List<BarPriceLists> beer = barPriceListService.beer();
        return beer;
    }
   
    public List<BarPriceLists> getAllBeer() {                                      
        List<BarPriceLists> allBeer = barPriceListService.allBeer();
        return allBeer;
    }

    public List<BarPriceLists> getHerbal() {                                      
        List<BarPriceLists> herbal = barPriceListService.herbalAlcohol();
        return herbal;
    }
   
    public List<BarPriceLists> getAllHerbal() {                                      
        List<BarPriceLists> allHerbal = barPriceListService.allHerbalAlcohol();
        return allHerbal;
    }

    public List<BarPriceLists> getJuice() {                                      
        List<BarPriceLists> juice = barPriceListService.juice();
        return juice;
    }
   
    public List<BarPriceLists> getAllJuice() {                                      
        List<BarPriceLists> allJuice = barPriceListService.allJuice();
        return allJuice;
    }

    public List<BarPriceLists> getSoftDrink() {                                      
        List<BarPriceLists> softDrink = barPriceListService.softDrink();
        return softDrink;
    }
   
    public List<BarPriceLists> getAllSoftDrink() {                                      
        List<BarPriceLists> allSoftDrink = barPriceListService.allSoftDrink();
        return allSoftDrink;
    }

    public List<BarPriceLists> getSpirit() {                                      
        List<BarPriceLists> spirit = barPriceListService.spirit();
        return spirit;
    }
   
    public List<BarPriceLists> getAllSpirit() {                                      
        List<BarPriceLists> allSpirit = barPriceListService.allSpirit();
        return allSpirit;
    }

    
        public void setFieldToNull(){                
        this.setBarPriceId(0);
        this.setDrinkType("");
        this.setDrinkDescription("");
        this.setAmount(0.0);        
        this.setCreatedDate("");        
    }

    
}
