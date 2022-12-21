package com.masai.dao;

import java.util.List;

import com.masai.exception.ExceptionEmployee;
import com.masai.model.Complain;
import com.masai.model.Employee;

public interface EmployeeDao {
	
	public String registerEmployee(Employee employee);
	
	public String EmployeeLogin(String email, String password) throws ExceptionEmployee;
	
	public String ChangePassword(String email,String password) throws ExceptionEmployee;
	
	public String registerComplain(Complain complain);
	
	public List<Complain> ComplainList(int empId) throws ExceptionEmployee;
	
}
