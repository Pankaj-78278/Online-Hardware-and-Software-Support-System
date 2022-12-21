package com.masai.mains;

import java.util.Scanner;

import com.masai.usecases.EngineerChangePassword;
import com.masai.usecases.EngineerComplainList;
import com.masai.usecases.EngineerUpdateStatus;

public class EngineerMain {

	public static void main(String[] args) {
		System.out.println("Welcome Engineer");
		System.out.println("Select Options to Continue");
		System.out.println("1.Check Assigned Complaint");
		System.out.println("2.Update Assign Complaint");
		System.out.println("3.Change Password");
		
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		switch(choice) {
			
		case 1:
			EngineerComplainList.main(args);
		case 2:
			EngineerUpdateStatus.main(args);
		case 3:
			EngineerChangePassword.main(args);
		default:
			System.out.println("Invalid Input");
			Main.main(args);
		}
	}

}
