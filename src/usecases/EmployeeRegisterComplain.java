package usecases;

import java.util.Scanner;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import model.Complain;



public class EmployeeRegisterComplain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Category(Software/hardware) : ");
		String category = sc.next();
		
		
		System.out.println("Status Pending");
		String status = "Pending";
		
		System.out.println("Enter Your EmployeeID :  ");
		int empId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		Complain complain = new Complain();
		complain.setCategory(category);
		complain.setStatus(status);
		complain.setEmpid(empId);
		
		String result = dao.registerComplain(complain);
		
		System.out.println(result);
	}

}
