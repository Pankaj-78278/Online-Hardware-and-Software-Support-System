package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;



public class RegisterEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name : ");
		String empname = sc.nextLine();
		
		
		System.out.println("Enter Employee Email : ");
		String empemail = sc.nextLine();
		
		System.out.println("Enter Employee Password : ");
		String emppassword = sc.nextLine();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		

		Employee employee = new Employee();
		
		employee.setEmpname(empname);
		employee.setEmpemail(empemail);
		employee.setEmppassword(emppassword);
		
		String result = dao.registerEmployee(employee);
		
		System.out.println(result);



	}

}
