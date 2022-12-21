package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.exception.ExceptionHOD;
import com.masai.model.Engineer;
import com.masai.model.HOD;

public class LoginHod {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email/Username");
		String email= sc.nextLine();

		System.out.println("Enter Your Password");
		String password = sc.nextLine();
		
//		HOD hod =new HOD();
//		hod.setHOD_username(email);
//		hod.setHOD_password(password);

		HodLogin dao= new HodLoginImpl();
		
		try {
			 HOD result=dao.LoginInHOD(email, password);
			System.out.println("signup Successfully");
			
			
		} catch (ExceptionHOD e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
