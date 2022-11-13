package DAO;

import java.util.List;
//import java.util.concurrent.CompletableFuture;


import Exception.Exception_Complain;
import Exception.Exception_Engineer;
import Exception.Exception_HOD;
import model.Engineer;
import model.Complain;
import model.HOD;

public interface HOD_Login {
	
	public String  SignInHod(String username,String password) throws Exception_HOD;
	
	public HOD LoginInHOD(String Username, String Password) throws Exception_HOD;
	
	public String registerEngineer(Engineer engineer) throws Exception_Engineer;
	
	public List <Engineer> AllEngineer();
	
	public String deleteEngineer(int engid) throws Exception_Engineer;
	
	public List<Complain> getAllComplainList() throws Exception_Complain;
	
	public String assignComplaintToEngineer(int Comid,int engid) throws Exception_Complain,Exception_Engineer;
	
	
}