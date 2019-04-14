package greater.service;

import greater.dao.ServiceChargeDao;
import greater.pojo.GuestMasterBills;
import greater.pojo.Restaurants;
import greater.pojo.ServiceCharges;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("serviceChargeService")
@Transactional(readOnly = true)
public class ServiceChargeServiceImp implements ServiceChargeService{
    @Autowired
    ServiceChargeDao serviceChargeDao;

    public ServiceChargeDao getServiceChargeDao() {
        return serviceChargeDao;
    }

    public void setServiceChargeDao(ServiceChargeDao serviceChargeDao) {
        this.serviceChargeDao = serviceChargeDao;
    }
    
    @Override
    public void createdServiceCharge(ServiceCharges s) {
        serviceChargeDao.createdServiceCharge(s);
    }

    @Override
    public void updateServiceCharge(ServiceCharges s) {
        serviceChargeDao.updateServiceCharge(s);
    }

    @Override
    public void deleteServiceCharge(ServiceCharges s) {
        serviceChargeDao.deleteServiceCharge(s);
    }

    @Override
    public List<ServiceCharges> listServiceChargeByEmail(String email) {
        return serviceChargeDao.listServiceChargeByEmail(email);
    }

    @Override
    public List<ServiceCharges> listServiceCharge() {
        return serviceChargeDao.listServiceCharge();
    }

    @Override
    public int checkServiceCharge(String email) {
        return serviceChargeDao.checkServiceCharge(email);
    }

    @Override
    public List<Restaurants> listRestaurantBySubTotal(String email) {
        return serviceChargeDao.listRestaurantBySubTotal(email);
    }

    @Override
    public List<ServiceCharges> listServiceChargeById(String serChargeId) {
        return serviceChargeDao.listServiceChargeById(serChargeId);
    }

    @Override
    public int checkServiceChargeId(String serChargeId) {
        return serviceChargeDao.checkServiceChargeId(serChargeId);
    }

    @Override
    public void createdGuestMasterBill(GuestMasterBills gmb) {
        serviceChargeDao.createdGuestMasterBill(gmb);
    }

    
}
