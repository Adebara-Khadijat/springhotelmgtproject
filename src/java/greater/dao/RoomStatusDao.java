package greater.dao;

import greater.pojo.RoomStatus;
import java.util.List;

public interface RoomStatusDao {
    public void createdRoomStatus(RoomStatus rs);
    public void updateRoomStatus(RoomStatus rs);
    public void deleteRoomStatus(RoomStatus rs);
    public List<RoomStatus> listRoomStatusByID(int roomStatusId);        
    public List<RoomStatus> listRoomStatus();             
    public int checkRoomStatusId(int roomStatusId);
    public List<RoomStatus> listCountRoomStatusVC();
    public List<RoomStatus> listCountRoomStatusVD();
    public List<RoomStatus> listCountRoomStatusOD();
    public List<RoomStatus> listCountRoomStatusOO();
    public List<RoomStatus> listCountRoomStatusTotal();
    public List<RoomStatus> listRoomStatusCurrently();    
    public List<RoomStatus> listRoomStatusDateBetween(String startDate, String endDate);
    public List<RoomStatus> listCountRoomStatusDateVC(String startDate, String endDate);
    public List<RoomStatus> listCountRoomStatusDateOD(String startDate, String endDate);    
    public List<RoomStatus> listCountRoomStatusDateVD(String startDate, String endDate);
    public List<RoomStatus> listCountRoomStatusDateOO(String startDate, String endDate);
    public List<RoomStatus> listCountRoomStatusDateTotal(String startDate, String endDate);
    
}
