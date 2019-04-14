package greater.service;

import greater.dao.EmployeeDao;
import greater.pojo.Employees;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("employeeService")
@Transactional(readOnly = true) //Implementing PlatformTransactionManager Interface which enable developer to choose one out of the data access technology ch are JDBC, JTA, JDO, Hibernate   
public class EmployeeServceImp implements EmployeeService {
    
    @Autowired
    EmployeeDao employeeDao; 

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }       

    @Override
    public void createdEmplyee(Employees e) {
        e.setEmail(e.getEmail());        
        e.setUserRoleId(e.getUserRoleId());
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPassword(e.getPassword());
        e.setSex(e.getSex());
        e.setPhone(e.getPhone());        
        e.setAddress(e.getAddress());
        e.setPosition(e.getPosition());
//        e.setPicture(image.getFileName());                     
        e.setPicture(e.getPicture());                                                
        e.setHireDate(e.getHireDate());
        e.setCreatedDate(e.getCreatedDate());
        employeeDao.createdEmplyee(e);
    }
    
    @Override
    public List<Employees> listEmployeeByID(String emailId){
        List<Employees> eList = employeeDao.listEmployeeByID(emailId);
        for(Employees e: eList){

            e.getEmail();
            e.getUserRoleId();
            e.getFirstName();
            e.getLastName();
            e.getPassword();
            e.getSex();
            e.getPhone();
            e.getAddress();
            e.getPosition();
            e.getPicture();
            e.getHireDate();                    
        }
        return eList ;
    }   
    
    @Override
    public int checkEmployeeLogin(String email_id){
        return employeeDao.checkEmployeeLogin(email_id);
    }

    @Override
    public void updateEmplyee(Employees e) {
        e.setEmail(e.getEmail());        
        e.setUserRoleId(e.getUserRoleId());
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPassword(e.getPassword());
        e.setSex(e.getSex());
        e.setPhone(e.getPhone());        
        e.setAddress(e.getAddress());
        e.setPosition(e.getPosition());
//        e.setPicture(image.getFileName());                     
        e.setPicture(e.getPicture());                                                
        e.setHireDate(e.getHireDate());
        e.setCreatedDate(e.getCreatedDate());
        employeeDao.updateEmplyee(e);
    }

    @Override
    public void deleteEmployee(Employees e){
        
        e.setEmail(e.getEmail());        
        e.setUserRoleId(e.getUserRoleId());
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPassword(e.getPassword());
        e.setSex(e.getSex());
        e.setPhone(e.getPhone());        
        e.setAddress(e.getAddress());
        e.setPosition(e.getPosition());                 
        e.setPicture(e.getPicture());                                                
        e.setHireDate(e.getHireDate());
        e.setCreatedDate(e.getCreatedDate());
        
        employeeDao.deleteEmployee(e);
    }

    @Override
    public List<Employees> listEmployee() {
        return employeeDao.listEmployee();
    }
    
    
    
}
