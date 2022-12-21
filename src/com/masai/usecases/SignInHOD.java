package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.exception.ExceptionHOD;

public class SignInHOD {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username/Email :");
		String username= sc.nextLine();

		System.out.println("Enter Password :");
		String password= sc.nextLine();
		
		HodLogin dao = new HodLoginImpl();
		
		try {
			String result= dao.SignInHod(username, password);
			System.out.println(result);
		} catch (ExceptionHOD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
