package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.ExceptionEngineer;
import com.masai.model.Complain;



public class EngineerComplainList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your EngineerId : ");
		int id = sc.nextInt();
		
		EngineerDao dao= new EngineerDaoImpl();
		
		List<Complain> list;
		
		try {
			list= dao.ComplainList(id);
			list.forEach(s -> System.out.println(s));
			
		} catch (ExceptionEngineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
