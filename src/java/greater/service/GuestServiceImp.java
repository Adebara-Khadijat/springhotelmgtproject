package greater.service;

import greater.dao.GuestDao;
import greater.pojo.Guests;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("guestService")
@Transactional(readOnly = true) //Implementing PlatformTransactionManager Interface which enable developer to choose one out of the data access technology ch are JDBC, JTA, JDO, Hibernate   
public class GuestServiceImp implements GuestService{
    
    @Autowired
    GuestDao guestDao;

    public GuestDao getGuestDao() {
        return guestDao;
    }

    public void setGuestDao(GuestDao guestDao) {
        this.guestDao = guestDao;
    }
    
    @Override
    public void createdGuest(Guests g) {
//        g.setEmail(g.getEmail());       
//        g.setTitle(g.getTitle());
//        g.setFirstName(g.getFirstName());
//        g.setLastName(g.getLastName());
//        g.setAddress(g.getAddress());
//        g.setDateOfBirth(g.getDateOfBirth());
//        g.setSex(g.getSex());
//        g.setPhone(g.getPhone());        
//        g.setOccupation(g.getOccupation());
//        g.setGuestType(g.getGuestType());
//        g.setCompanyName(g.getCompanyName());
//        g.setNationality(g.getNationality());        
//        g.setPassportNo(g.getPassportNo());
//        g.setResidentPermitNo(g.getResidentPermitNo());
//        g.setNextOfKinName(g.getNextOfKinName());
//        g.setNextOfKinPhone(g.getNextOfKinPhone());
//        g.setNextOfKinAddress(g.getNextOfKinAddress());
//        g.setArrivalDate(g.getArrivalDate());
//        g.setDepartureDate(g.getDepartureDate());
//        g.setTimeCheckIn(g.getTimeCheckIn());
//        g.setTimeCheckOut(g.getTimeCheckOut());
//        g.setReceptionistOnDuty(g.getReceptionistOnDuty());
//        g.setCreatedDate(g.getCreatedDate());
        guestDao.createdGuest(g);
    }

    @Override
    public void updateGuest(Guests g) {
        guestDao.updateGuest(g);
    }

    @Override
    public void deleteGuest(Guests g) {
        guestDao.deleteGuest(g);
    }

    @Override
    public List<Guests> listGuestByID(String emailId) {
        List<Guests> gList = guestDao.listGuestByID(emailId);
        for(Guests g : gList){
     
            g.getEmail();
            g.getTitle();
            g.getFirstName();
            g.getLastName();
            g.getAddress();
            g.getDateOfBirth();
            g.getSex();
            g.getPhone();
            g.getOccupation();
            g.getGuestType();
            g.getCompanyName();
            g.getNationality();
            g.getPassportNo();
            g.getResidentPermitNo();
            g.getNextOfKinName();
            g.getNextOfKinphone();
            g.getNextOfKinAddress();            
            g.getArrivalDate();
            g.getDepartureDate();
            g.getTimeCheckIn();
            g.getTimeCheckOut();
            g.getReceptionistOnDuty();
            g.getCreatedDate();
        }
        return gList;
    }

    @Override
    public List<Guests> listGuest() {
        return guestDao.listGuest();
    }

    @Override
    public int checkGuest(String email_id) {
        return guestDao.checkGuest(email_id);
    }
    
}
