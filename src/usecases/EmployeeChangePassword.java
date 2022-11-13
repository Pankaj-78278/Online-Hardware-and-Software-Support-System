package usecases;

import java.util.Scanner;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import Exception.Exception_Employee;


public class EmployeeChangePassword {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email");
		String email = sc.next();
		
		System.out.println("Enter new password");
		String newpassword = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.ChangePassword(email, newpassword);
			System.out.println("Changed Successfully");
			
		}catch(Exception_Employee e) {
			e.printStackTrace();
		}
		
	}

}
