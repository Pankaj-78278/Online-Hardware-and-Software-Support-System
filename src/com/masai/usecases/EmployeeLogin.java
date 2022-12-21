package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.ExceptionEmployee;


public class EmployeeLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Email : ");
		String email = sc.nextLine();
		
		System.out.println("Enter Employee password : ");
		String password = sc.nextLine();
	
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.EmployeeLogin(email, password);
			
			System.out.println("Welcome Employee !");
		} catch (ExceptionEmployee e) {
			System.out.println(e.getMessage());
		}

	}

}
