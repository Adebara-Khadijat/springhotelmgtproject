package greater.service;

import greater.dao.RoomStatusDao;
import greater.pojo.RoomStatus;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("roomStatusService")
@Transactional(readOnly = true)
public class RoomStatusServiceImp implements RoomStatusService {
    
    @Autowired
    RoomStatusDao roomStatusDao;

    public RoomStatusDao getRoomStatusDao() {
        return roomStatusDao;
    }

    public void setRoomStatusDao(RoomStatusDao roomStatusDao) {
        this.roomStatusDao = roomStatusDao;
    }
    
    @Override
    public void createdRoomStatus(RoomStatus rs) {
        roomStatusDao.createdRoomStatus(rs);
    }

    @Override
    public void updateRoomStatus(RoomStatus rs) {
        roomStatusDao.updateRoomStatus(rs);
    }

    @Override
    public void deleteRoomStatus(RoomStatus rs) {
        roomStatusDao.deleteRoomStatus(rs);
    }

    @Override
    public List<RoomStatus> listRoomStatusByID(int roomStatusId) {
        return roomStatusDao.listRoomStatusByID(roomStatusId);
    }

    @Override
    public List<RoomStatus> listRoomStatus() {
        return roomStatusDao.listRoomStatus();
    }

    @Override
    public int checkRoomStatusId(int roomStatusId) {
        return roomStatusDao.checkRoomStatusId(roomStatusId);
    }

    @Override
    public List<RoomStatus> listCountRoomStatusVC() {
        return roomStatusDao.listCountRoomStatusVC();
    }

    @Override
    public List<RoomStatus> listCountRoomStatusVD() {
        return roomStatusDao.listCountRoomStatusVD();
    }

    @Override
    public List<RoomStatus> listCountRoomStatusOD() {
        return roomStatusDao.listCountRoomStatusOD();
    }

    @Override
    public List<RoomStatus> listCountRoomStatusOO() {
        return roomStatusDao.listCountRoomStatusOO();
    }
    
    @Override
    public List<RoomStatus> listCountRoomStatusTotal() {
        return roomStatusDao.listCountRoomStatusTotal();
    }
    
    @Override
    public List<RoomStatus> listRoomStatusCurrently(){
        return roomStatusDao.listRoomStatusCurrently();
    }
  
    @Override
    public List<RoomStatus> listRoomStatusDateBetween(String startDate, String endDate) {
        return roomStatusDao.listRoomStatusDateBetween(startDate, endDate);
    }

    @Override
    public List<RoomStatus> listCountRoomStatusDateVC(String startDate, String endDate) {
        return roomStatusDao.listCountRoomStatusDateVC(startDate, endDate);
    }

    @Override
    public List<RoomStatus> listCountRoomStatusDateOD(String startDate, String endDate) {
        return roomStatusDao.listCountRoomStatusDateOD(startDate, endDate);
    }

    @Override
    public List<RoomStatus> listCountRoomStatusDateVD(String startDate, String endDate) {
        return roomStatusDao.listCountRoomStatusDateVD(startDate, endDate);
    }

    @Override
    public List<RoomStatus> listCountRoomStatusDateOO(String startDate, String endDate) {
        return roomStatusDao.listCountRoomStatusDateOO(startDate, endDate);
    }

    @Override
    public List<RoomStatus> listCountRoomStatusDateTotal(String startDate, String endDate) {
        return roomStatusDao.listCountRoomStatusDateTotal(startDate, endDate);
    }
    
}
