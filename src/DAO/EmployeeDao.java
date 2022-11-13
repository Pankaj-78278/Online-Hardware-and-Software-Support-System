package DAO;

import java.util.List;
import Exception.Exception_Employee;
import model.Complain;
import model.Employee;

public interface EmployeeDao {
	
	public String registerEmployee(Employee employee);
	
	public String EmployeeLogin(String email, String password) throws Exception_Employee;
	
	public String ChangePassword(String email,String password) throws Exception_Employee;
	
	public String registerComplain(Complain complain);
	
	public List<Complain> ComplainList(int empId) throws Exception_Employee;
	
}
