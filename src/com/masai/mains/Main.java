package com.masai.mains;

import java.util.Scanner;

import com.masai.usecases.EmployeeLogin;
import com.masai.usecases.EngineerLogin;
import com.masai.usecases.LoginHod;
import com.masai.usecases.RegisterEmployee;
import com.masai.usecases.RegisterEngineer;

public class Main {

	public static void main(String[] args) {
		System.out.println("==============================================");
		System.out.println("  Online Hardware And Software Support System");
		System.out.println("===============================================");
		
		System.out.println("Select Option to Continue....");
		System.out.println("1.HOD Login\r\n"
				+ "2.Engineer Login\r\n"
				+ "3.Employee Login\r\n"
				+ "4.New Engineer Registration\r\n"
				+ "5.New Employee Registration\r\n"
				+ "6.Exit");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("........HOD Login ...");
			LoginHod.main(args);
			
		case 2:
			System.out.println(".........Engineer Login ...");
			EngineerLogin.main(args);
			
		case 3:
			System.out.println(".........Employee Login ...");
			EmployeeLogin.main(args);
		
		case 4:
			System.out.println(".........Engineer Registration ...");
			RegisterEngineer.main(args);
			
		case 5:
			System.out.println(".........Employee Registration ...");
			RegisterEmployee.main(args);
			
		default:
			System.out.println("ThankYou");
			
		}	
	}

}
