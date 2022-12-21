package com.masai.dao;

import java.util.List;
//import java.util.concurrent.CompletableFuture;

import com.masai.exception.ExceptionComplain;
import com.masai.exception.ExceptionEngineer;
import com.masai.exception.ExceptionHOD;
import com.masai.model.Complain;
import com.masai.model.Engineer;
import com.masai.model.HOD;

public interface HodLogin {
	
	public String  SignInHod(String username,String password) throws ExceptionHOD;
	
	public HOD LoginInHOD(String Username, String Password) throws ExceptionHOD;
	
	public String registerEngineer(Engineer engineer) throws ExceptionEngineer;
	
	public List <Engineer> AllEngineer();
	
	public String deleteEngineer(int engid) throws ExceptionEngineer;
	
	public List<Complain> getAllComplainList() throws ExceptionComplain;
	
	public String assignComplaintToEngineer(int Comid,int engid) throws ExceptionComplain,ExceptionEngineer;
	
	
}