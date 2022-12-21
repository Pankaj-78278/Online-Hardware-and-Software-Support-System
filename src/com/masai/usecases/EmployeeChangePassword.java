package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.ExceptionEmployee;


public class EmployeeChangePassword {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email");
		String email = sc.nextLine();
		
		System.out.println("Enter new password");
		String newpassword = sc.nextLine();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.ChangePassword(email, newpassword);
			System.out.println("Changed Successfully");
			
		}catch(ExceptionEmployee e) {
			e.printStackTrace();
		}
		
	}

}
