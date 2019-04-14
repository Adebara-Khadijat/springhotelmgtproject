package greater.dao;

import greater.pojo.BarPriceLists;
import java.util.List;

public interface BarPriceListDao {
    public void createdBarPriceList(BarPriceLists barPrice);
    public void updateBarPriceList(BarPriceLists barPrice);
    public void deleteBarPriceList(BarPriceLists barPrice);
    public List<BarPriceLists> listBarPriceListByID(int barPriceId);        
    public List<BarPriceLists> listBarPriceList();         
    public int checkBarPriceListID(int barPriceId);    
    public List<BarPriceLists> wine();
    public List<BarPriceLists> allWine();
    public List<BarPriceLists> beer();
    public List<BarPriceLists> allBeer();
    public List<BarPriceLists> spirit();
    public List<BarPriceLists> allSpirit();
    public List<BarPriceLists> softDrink();
    public List<BarPriceLists> allSoftDrink();
    public List<BarPriceLists> herbalAlcohol();
    public List<BarPriceLists> allHerbalAlcohol();
    public List<BarPriceLists> juice();
    public List<BarPriceLists> allJuice();
}
