package greater.service;

import greater.pojo.GuestMasterBills;
import greater.pojo.Rooms;
import java.util.List;

public interface RoomService {
    public void createdRoom(Rooms r);
    public void updateRoom(Rooms r);
    public void deleteRoom(Rooms r);
    public void createdGuestMasterBill(GuestMasterBills gmb);    
    public List<Rooms> listRoomByID(String roomId);      
    public List<Rooms> listRoom(); 
    public List<Rooms> listRoomNo();
    public List<Rooms> listRoomCurrentlyInUse();     
    public List<Rooms> listRoomHistory();    
    public int checkRoomId(String roomId);
    
}
