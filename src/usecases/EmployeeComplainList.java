package usecases;

import java.util.List;
import java.util.Scanner;
import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import Exception.Exception_Employee;
import model.Complain;

public class EmployeeComplainList {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your EmployeeId : ");
		int id = sc.nextInt();
		
		EmployeeDao dao= new EmployeeDaoImpl();
		
		try {
			List<Complain> list = dao.ComplainList(id);
			list.forEach(s -> System.out.println(s));
			
		}catch(Exception_Employee e) {
			e.printStackTrace();
		}
	}

}
