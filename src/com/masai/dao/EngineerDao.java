package com.masai.dao;

import java.util.List;

import com.masai.exception.ExceptionComplain;
import com.masai.exception.ExceptionEngineer;
import com.masai.model.Complain;
import com.masai.model.Engineer;

public interface EngineerDao {
	public String RegisterEngineer(Engineer engineer);
	
	public String Engineerlogin(String email,String Password) throws ExceptionEngineer;
	
	public String ChangePassword(String email,String password) throws ExceptionEngineer;
	
	public List<Complain> ComplainList(int engid)throws ExceptionEngineer;
	
	public String UpdateAssignedComplaintStatus(int comid,String status)throws ExceptionComplain;
	

}
