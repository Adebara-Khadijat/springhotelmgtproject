package greater.controller;

import greater.dao.EmployeeLogin;
import greater.pojo.AuditTrailLogins;
import greater.pojo.RoomStatus;
import greater.service.RoomStatusService;
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

@ManagedBean(name="roomStatusController")
@RequestScoped
public class RoomStatusController implements Serializable {
    
    @ManagedProperty(value="#{roomStatusService}")
    
    @Autowired
    RoomStatusService roomStatusService; 

    public RoomStatusService getRoomStatusService() {
        return roomStatusService;
    }

    public void setRoomStatusService(RoomStatusService roomStatusService) {
        this.roomStatusService = roomStatusService;
    }
    
     private Integer roomStatusId;
     private Integer roomNo;
     private String roomType;
     private String statesOfTheRoom;
     private String tv;
     private String intecom;
     private String ac;
     private String fridge;
     private String lightingPoint;
     private String beding;
     private String furniture;
     private String toilet;
     private String toiletries;
     private String remarks;
     private String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());          
     private String mgsError;
     private String startDate; 
     private String endDate;

    public Integer getRoomStatusId() {
        return roomStatusId;
    }

    public void setRoomStatusId(Integer roomStatusId) {
        this.roomStatusId = roomStatusId;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatesOfTheRoom() {
        return statesOfTheRoom;
    }

    public void setStatesOfTheRoom(String statesOfTheRoom) {
        this.statesOfTheRoom = statesOfTheRoom;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getIntecom() {
        return intecom;
    }

    public void setIntecom(String intecom) {
        this.intecom = intecom;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getFridge() {
        return fridge;
    }

    public void setFridge(String fridge) {
        this.fridge = fridge;
    }

    public String getLightingPoint() {
        return lightingPoint;
    }

    public void setLightingPoint(String lightingPoint) {
        this.lightingPoint = lightingPoint;
    }

    public String getBeding() {
        return beding;
    }

    public void setBeding(String beding) {
        this.beding = beding;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getToiletries() {
        return toiletries;
    }

    public void setToiletries(String toiletries) {
        this.toiletries = toiletries;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endtDate) {
        this.endDate = endtDate;
    }
    
    
             
    public RoomStatusController() {
    }
    
    EmployeeLogin el = new EmployeeLogin();    
    AuditTrailLogins audit = new AuditTrailLogins();     
    
    public String saveRoomStatus(){                 
        RoomStatus rs = new RoomStatus();

            rs.setRoomNo(roomNo);
            rs.setRoomType(roomType);
            rs.setStatesOfTheRoom(statesOfTheRoom);
            rs.setTv(tv);
            rs.setIntecom(intecom);
            rs.setAc(ac);
            rs.setFridge(fridge);
            rs.setLightingPoint(lightingPoint);
            rs.setBeding(beding);
            rs.setFurniture(furniture);
            rs.setToilet(toilet);
            rs.setToiletries(toiletries);
            rs.setRemarks(remarks);
            rs.setCreatedDate(createdDate);            
            
            roomStatusService.createdRoomStatus(rs);
            setFieldToNull();
            mgsError="Room Status Record Created!!!";
                      
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
            audit.setOperation("Create Room Status with Room Status ID  "+rs.getRoomStatusId());
            audit.setPassword(sPassword);
            audit.setFirstName(sFirstName);
            audit.setLastName(sLastName);
            audit.setSex(sSex);
            audit.setPhone(sPhone);
            audit.setAddress(sAddress);
            audit.setPosition(sPosition);
            audit.setCreatedDate(sCreatedDate);
            el.createAuditTrailLogin(audit);                       

        return "hotel_room_status";
    }        
    
    public String updateRoom(){        
        RoomStatus rs = new RoomStatus();
        
        int mgs = roomStatusService.checkRoomStatusId(roomStatusId);
        if(mgs ==0){
            
            rs.setRoomStatusId(roomStatusId);
            rs.setRoomNo(roomNo);
            rs.setRoomType(roomType);
            rs.setStatesOfTheRoom(statesOfTheRoom);
            rs.setTv(tv);
            rs.setIntecom(intecom);
            rs.setAc(ac);
            rs.setFridge(fridge);
            rs.setLightingPoint(lightingPoint);
            rs.setBeding(beding);
            rs.setFurniture(furniture);
            rs.setToilet(toilet);
            rs.setToiletries(toiletries);
            rs.setRemarks(remarks);
            rs.setCreatedDate(createdDate);            
            
            roomStatusService.updateRoomStatus(rs);
            setFieldToNull();            
            mgsError="RoomStatus Record Updated !!!";          
            
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
            audit.setOperation("Update Room Status with Room Status ID "+rs.getRoomStatusId());
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
            mgsError="RoomStatus Record Does Not Exist!!!"; 
        }
        return "hotel_room_status_edit";
    }
    
    // Method To Fetch Particular Room Details From The Database
	public String getRoomStatusDetailsByID() { 
            RoomStatus rs = new RoomStatus();   
                        
            List<RoomStatus> roomList = roomStatusService.listRoomStatusByID(roomStatusId);
                
            int checkRoomStatusId = roomStatusService.checkRoomStatusId(roomStatusId);                
                if(checkRoomStatusId==0){                   
		for(Iterator it = roomList.iterator(); it.hasNext();) {                    
                    rs = (RoomStatus)it.next();                                       
                    
                roomStatusId = rs.getRoomStatusId();
                roomNo = rs.getRoomNo();
                roomType = rs.getRoomType();
                statesOfTheRoom = rs.getStatesOfTheRoom();
                tv = rs.getTv();
                intecom = rs.getIntecom();
                ac = rs.getAc();
                fridge = rs.getFridge();
                lightingPoint =rs.getLightingPoint();
                beding =rs.getBeding();
                furniture =rs.getFurniture();
                toilet = rs.getToilet();
                toiletries =rs.getToiletries();
                remarks =rs.getRemarks();
                createdDate =rs.getCreatedDate();            
                    
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
                    audit.setOperation("Select Room Status with Room Status ID "+rs.getRoomStatusId());
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
                }else if(checkRoomStatusId!=0){
                    setMgsError("RoomStatus Record does not Exist!!");                                                          
                }           
		return "hotel_room_status_edit";
	}
        
        public String deleteRoom(){
        RoomStatus rs = new RoomStatus();
                
        int mgs = roomStatusService.checkRoomStatusId(roomStatusId);    
        if(mgs ==0){
            
            rs.setRoomStatusId(roomStatusId);
            rs.setRoomNo(roomNo);
            rs.setRoomType(roomType);
            rs.setStatesOfTheRoom(statesOfTheRoom);
            rs.setTv(tv);
            rs.setIntecom(intecom);
            rs.setAc(ac);
            rs.setFridge(fridge);
            rs.setLightingPoint(lightingPoint);
            rs.setBeding(beding);
            rs.setFurniture(furniture);
            rs.setToilet(toilet);
            rs.setToiletries(toiletries);
            rs.setRemarks(remarks);
            rs.setCreatedDate(createdDate);            
            
            roomStatusService.deleteRoomStatus(rs);
            setFieldToNull();                        
            mgsError="RoomStatus Record Deleted !!!";          
            
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
            audit.setOperation("Delete Room Status with Room Status ID "+rs.getRoomStatusId());
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
            mgsError="Room Record Does Not Exist!!!"; 
        }
        
        return "hotel_room_status_edit";
    }

   // Method To Fetch All Room status Details From The Database
    public List<RoomStatus> getRoomStatusDetails() {            
            RoomStatus rs = new RoomStatus();
                        
            List<RoomStatus> roomStatusList = roomStatusService.listRoomStatus();
		for(Iterator it = roomStatusList.iterator();it.hasNext();) {                    
                    rs = (RoomStatus)it.next();
                                        
                    roomStatusId = rs.getRoomStatusId();
                    roomNo = rs.getRoomNo();
                    roomType = rs.getRoomType();
                    statesOfTheRoom = rs.getStatesOfTheRoom();
                    tv = rs.getTv();
                    intecom = rs.getIntecom();
                    ac = rs.getAc();
                    fridge = rs.getFridge();
                    lightingPoint =rs.getLightingPoint();
                    beding =rs.getBeding();
                    furniture =rs.getFurniture();
                    toilet = rs.getToilet();
                    toiletries =rs.getToiletries();
                    remarks =rs.getRemarks();
                    createdDate =rs.getCreatedDate();            
                    
		}               
		return roomStatusList;
	}
   
   // Method To Fetch All Current Room status Details From The Database
    public List<RoomStatus> getRoomStatusCurrentDetails() {            
            RoomStatus rs = new RoomStatus();
                        
            List<RoomStatus> roomStatusList = roomStatusService.listRoomStatusCurrently();
		for(Iterator it = roomStatusList.iterator();it.hasNext();) {                    
                    rs = (RoomStatus)it.next();
                                        
                    roomStatusId = rs.getRoomStatusId();
                    roomNo = rs.getRoomNo();
                    roomType = rs.getRoomType();
                    statesOfTheRoom = rs.getStatesOfTheRoom();
                    tv = rs.getTv();
                    intecom = rs.getIntecom();
                    ac = rs.getAc();
                    fridge = rs.getFridge();
                    lightingPoint =rs.getLightingPoint();
                    beding =rs.getBeding();
                    furniture =rs.getFurniture();
                    toilet = rs.getToilet();
                    toiletries =rs.getToiletries();
                    remarks =rs.getRemarks();
                    createdDate =rs.getCreatedDate();            
                    
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
                    audit.setOperation("View Current Room Status with Current Date "+ rs.getCreatedDate());
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
		return roomStatusList;
	}
   
    // Method To Fetch All Vacant Clean Room From The Database
    public List<RoomStatus> getCountRoomStatusVC() {                                                
            List<RoomStatus> roomListVC = roomStatusService.listCountRoomStatusVC();		               
		return roomListVC;
	}
    // Method To Fetch All Vacant Dirty Room From The Database
    public List<RoomStatus> getCountRoomStatusVD() {                                                
            List<RoomStatus> roomListVC = roomStatusService.listCountRoomStatusVD();		               
		return roomListVC;
	}
    // Method To Fetch All Occupied Dirty Room From The Database
    public List<RoomStatus> getCountRoomStatusOD() {                                                
            List<RoomStatus> roomListVC = roomStatusService.listCountRoomStatusOD();		               
		return roomListVC;
	}
    // Method To Fetch All Vacant Clean Room From The Database
    public List<RoomStatus> getCountRoomStatusOO() {                                                
            List<RoomStatus> roomListVC = roomStatusService.listCountRoomStatusOO();		               
		return roomListVC;
	}
    // Method To Fetch All Vacant Clean Room From The Database
    public List<RoomStatus> getCountRoomTotal() {                                                
            List<RoomStatus> roomListTotal = roomStatusService.listCountRoomStatusTotal();		               
		return roomListTotal;
	}
        
    public String getRoomStatusDetailsByDateBetween() { 
            RoomStatus rs = new RoomStatus();   
                        
            List<RoomStatus> roomList = roomStatusService.listRoomStatusDateBetween(startDate, endDate);

		for(Iterator it = roomList.iterator();it.hasNext();) {                    
                    rs = (RoomStatus)it.next();
                                        
                    roomStatusId = rs.getRoomStatusId();
                    roomNo = rs.getRoomNo();
                    roomType = rs.getRoomType();
                    statesOfTheRoom = rs.getStatesOfTheRoom();
                    tv = rs.getTv();
                    intecom = rs.getIntecom();
                    ac = rs.getAc();
                    fridge = rs.getFridge();
                    lightingPoint =rs.getLightingPoint();
                    beding =rs.getBeding();
                    furniture =rs.getFurniture();
                    toilet = rs.getToilet();
                    toiletries =rs.getToiletries();
                    remarks =rs.getRemarks();
                    createdDate =rs.getCreatedDate();            
                    
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
                    audit.setOperation("Select Room Status with Start Date "+startDate+" and End Date "+endDate);
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
		return "hotel_room_status_list";
	}
    
   // Method To Fetch All Room Status Date Between Details From The Database
    public List<RoomStatus> getRoomStatusDateBetween() {                            
            RoomStatus rs = new RoomStatus();
                        
            List<RoomStatus> roomStatusList = roomStatusService.listRoomStatusDateBetween(startDate, endDate);
		for(Iterator it = roomStatusList.iterator();it.hasNext();) {                    
                    rs = (RoomStatus)it.next();
                                        
                    roomStatusId = rs.getRoomStatusId();
                    roomNo = rs.getRoomNo();
                    roomType = rs.getRoomType();
                    statesOfTheRoom = rs.getStatesOfTheRoom();
                    tv = rs.getTv();
                    intecom = rs.getIntecom();
                    ac = rs.getAc();
                    fridge = rs.getFridge();
                    lightingPoint =rs.getLightingPoint();
                    beding =rs.getBeding();
                    furniture =rs.getFurniture();
                    toilet = rs.getToilet();
                    toiletries =rs.getToiletries();
                    remarks =rs.getRemarks();
                    createdDate =rs.getCreatedDate();            
                    
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
                    audit.setOperation("Select Room Status with Start Date "+startDate+" and End Date "+endDate);
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
		return roomStatusList;
	}
   
    // Method To Fetch All Vacant Clean Room From The Database
    public List<RoomStatus> getCountRoomStatusDateBetVC() {                                                
            List<RoomStatus> roomListVC = roomStatusService.listCountRoomStatusDateVC(startDate, endDate);		               
                        
		return roomListVC;
	}
    // Method To Fetch All Vacant Dirty Room From The Database
    public List<RoomStatus> getCountRoomStatusDateBetVD() {                                                
            List<RoomStatus> roomListVD = roomStatusService.listCountRoomStatusDateVD(startDate, endDate);		               
		return roomListVD;
	}
    // Method To Fetch All Occupied Dirty Room From The Database
    public List<RoomStatus> getCountRoomStatusDateBetOD() {                                                
            List<RoomStatus> roomListOD = roomStatusService.listCountRoomStatusDateOD(startDate, endDate);		               
		return roomListOD;
	}
    // Method To Fetch All Vacant Clean Room From The Database
    public List<RoomStatus> getCountRoomStatusDateBetOO() {                                                
            List<RoomStatus> roomListOO = roomStatusService.listCountRoomStatusDateOO(startDate, endDate);		               
		return roomListOO;
	}
    // Method To Fetch All Vacant Clean Room From The Database
    public List<RoomStatus> getCountRoomStateDateBetTotal() {                                                
            List<RoomStatus> roomListTotal = roomStatusService.listCountRoomStatusDateTotal(startDate, endDate);		               
		return roomListTotal;
	}
                
    public void setFieldToNull(){          
        this.setRoomStatusId(0);
        this.setRoomNo(0);        
        this.setRoomType("");
        this.setStatesOfTheRoom("");
        this.setTv("");
        this.setIntecom("");
        this.setAc("");
        this.setFridge("");
        this.setLightingPoint("");
        this.setBeding("");
        this.setFurniture("");            
        this.setToilet("");
        this.setToiletries("");
        this.setRemarks("");            
        this.setCreatedDate("");        
    }
    
}
