package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.ExceptionEngineer;


	public class EngineerChangePassword {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
		
	System.out.println("Enter Your Email");
	String email = sc.nextLine();		
	System.out.println("Enter new password");
	String newpassword = sc.nextLine();
		
	EngineerDao dao = new EngineerDaoImpl();
		
	try {
		dao.ChangePassword(email, newpassword);
		System.out.println("Changed Successfully");
	}catch(ExceptionEngineer e){
		e.printStackTrace();
	}

	}

}
