package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.exception.ExceptionComplain;
import com.masai.exception.ExceptionEngineer;

public class AssignEngineerTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint ID : ");
		int complaintID = sc.nextInt();
		
		System.out.println("Enter Engineer ID : ");
		int engineerId = sc.nextInt();
		

		HodLogin dao= new HodLoginImpl();
		
		try {
			String result=dao.assignComplaintToEngineer(complaintID, engineerId);

			System.out.println("Complaint Assigned Successfully");
		} catch (ExceptionComplain e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEngineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
