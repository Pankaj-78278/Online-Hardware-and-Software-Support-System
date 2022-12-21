package com.masai.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.exception.ExceptionEngineer;
import com.masai.model.Engineer;

public class RegisterEngineer {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name=sc.nextLine();
		
		System.out.println("Enter Your Email");
		String email=sc.nextLine();
		
		System.out.println("Enter Your Password");
		String password=sc.nextLine();

		
		Engineer hte= new Engineer();
		hte.setEngname(name);
		hte.setEngemail(email);
		hte.setEngpassword(password);
		
		
		
		 HodLogin hl = new HodLoginImpl();
		
		try {
			String result=hl.registerEngineer(hte);
			System.out.println(result);
			
		} catch (ExceptionEngineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
