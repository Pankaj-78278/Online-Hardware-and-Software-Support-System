package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.exception.ExceptionEngineer;
import com.masai.model.Engineer;
import com.masai.model.HOD;

public class DeleteEngineer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Engineer ID");
		int id=sc.nextInt();

		HodLogin hodDelete= new HodLoginImpl();
		
		String eng;
		try {
			eng = hodDelete.deleteEngineer(id);
			
			if(eng!=null) {
				System.out.println("delete engineer successfully");
			}else {
				System.out.println("Engineer table is empty");
			}
			
		} catch (ExceptionEngineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
