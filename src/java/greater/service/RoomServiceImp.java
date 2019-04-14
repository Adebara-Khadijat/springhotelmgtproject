package greater.service;

import greater.dao.RoomDao;
import greater.pojo.GuestMasterBills;
import greater.pojo.Rooms;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("roomService")
@Transactional(readOnly = true) //Implementing PlatformTransactionManager Interface which enable developer to choose one out of the data access technology ch are JDBC, JTA, JDO, Hibernate   
public class RoomServiceImp implements RoomService {
    
    @Autowired
    RoomDao roomDao;

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void createdRoom(Rooms r) {
        roomDao.createdRoom(r);
    }

    @Override
    public void updateRoom(Rooms r) {
        roomDao.updateRoom(r);
    }

    @Override
    public void deleteRoom(Rooms r) {
        roomDao.deleteRoom(r);
    }

    @Override
    public List<Rooms> listRoomByID(String roomId) {
        return roomDao.listRoomByID(roomId);
    }

    @Override
    public List<Rooms> listRoom() {
        return roomDao.listRoom();
    }
    
    @Override
    public int checkRoomId(String roomId){
        return roomDao.checkRoomId(roomId);
    }

    @Override
    public List<Rooms> listRoomCurrentlyInUse() {
        return roomDao.listRoomCurrentlyInUse();
    }

    @Override
    public List<Rooms> listRoomHistory() {
        return roomDao.listRoomHistory();
    }

    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        roomDao.createdGuestMasterBill(gmb);
    }

    @Override
    public List<Rooms> listRoomNo() {
       return roomDao.listRoomNo();
    }

}
