package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.ExceptionComplain;

public class EngineerUpdateStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint ID to Update");
		int comid = sc.nextInt();
		
		System.out.println("Enter New Status of Complaint");
		String status = sc.nextLine();
		
		EngineerDao dao = new EngineerDaoImpl();

		try {
			dao.UpdateAssignedComplaintStatus(comid, status);
			System.out.println("Status Updated Successfully");
		} catch (ExceptionComplain e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
