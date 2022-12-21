package com.masai.mains;

import java.util.Scanner;

import com.masai.usecases.EmployeeChangePassword;
import com.masai.usecases.EmployeeComplainList;
import com.masai.usecases.EmployeeRegisterComplain;

public class EmployeeMain {

	public static void main(String[] args) {
		System.out.println("Welcom Employee");
		System.out.println("Select Options to Continue");
		System.out.println("1.Register new Complaint");
		System.out.println("2.Check Your Complaints");
		System.out.println("3.Change Password");
		
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			EmployeeRegisterComplain.main(args);
		case 2:
			EmployeeComplainList.main(args);
		case 3:
			EmployeeChangePassword.main(args);
		default:
			System.out.println("Inalid Input");
			Main.main(args);
		}
		
	}

}
