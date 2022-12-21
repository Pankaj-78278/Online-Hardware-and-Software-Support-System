package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.ExceptionEngineer;



public class EngineerLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer Email : ");
		String email = sc.nextLine();
		
		System.out.println("Enter Engineer password : ");
		String password = sc.nextLine();

		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			dao.Engineerlogin(email, password);
			
			System.out.println("Welcome Engineer !");
		} catch (ExceptionEngineer e) {
			System.out.println(e.getMessage());
		}

	}

}
