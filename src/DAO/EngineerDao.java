package DAO;

import java.util.List;

import Exception.Exception_Complain;
import Exception.Exception_Engineer;
import model.Complain;
import model.Engineer;

public interface EngineerDao {
	public String RegisterEngineer(Engineer engineer);
	
	public String Engineerlogin(String email,String Password) throws Exception_Engineer;
	
	public String ChangePassword(String email,String password) throws Exception_Engineer;
	
	public List<Complain> ComplainList(int engid)throws Exception_Engineer;
	
	public String UpdateAssignedComplaintStatus(int comid,String status)throws Exception_Complain;
	

}
