package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.ExceptionEmployee;
import com.masai.model.Complain;

public class EmployeeComplainList {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your EmployeeId : ");
		int id = sc.nextInt();
		
		EmployeeDao dao= new EmployeeDaoImpl();
		
		try {
			List<Complain> list = dao.ComplainList(id);
			list.forEach(s -> System.out.println(s));
			
		}catch(ExceptionEmployee e) {
			e.printStackTrace();
		}
	}

}
