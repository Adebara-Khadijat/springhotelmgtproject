package greater.service;

import greater.pojo.Employees;
import java.util.List;

public interface EmployeeService {
    public void createdEmplyee(Employees e);
    public void updateEmplyee(Employees e);
    public void deleteEmployee(Employees e);
    public List<Employees> listEmployeeByID(String emailId);   
    public List<Employees> listEmployee();  
    public int checkEmployeeLogin(String email_id);
    
}
