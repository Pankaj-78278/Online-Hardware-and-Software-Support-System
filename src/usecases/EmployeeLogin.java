package usecases;

import java.util.Scanner;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import Exception.Exception_Employee;


public class EmployeeLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Email : ");
		String email = sc.next();
		
		System.out.println("Enter Employee password : ");
		String password = sc.next();
	
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.EmployeeLogin(email, password);
			
			System.out.println("Welcome Employee !");
		} catch (Exception_Employee e) {
			System.out.println(e.getMessage());
		}

	}

}
