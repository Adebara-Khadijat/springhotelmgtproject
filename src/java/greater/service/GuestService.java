package greater.service;

import greater.pojo.Guests;
import java.util.List;


public interface GuestService {
    public void createdGuest(Guests g);
    public void updateGuest(Guests g);
    public void deleteGuest(Guests g);
    public List<Guests> listGuestByID(String emailId);    
    public List<Guests> listGuest(); 
    public int checkGuest(String email_id);    
    
}
