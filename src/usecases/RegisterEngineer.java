package usecases;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import Exception.Exception_Engineer;
import model.Engineer;

public class RegisterEngineer {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name=sc.next();
		
		System.out.println("Enter Your Email");
		String email=sc.next();
		
		System.out.println("Enter Your Password");
		String password=sc.next();

		
		Engineer hte= new Engineer();
		hte.setEngname(name);
		hte.setEngemail(email);
		hte.setEngpassword(password);
		
		
		
		 HOD_Login hl = new HOD_LoginImpl();
		
		try {
			String result=hl.registerEngineer(hte);
			System.out.println(result);
			
		} catch (Exception_Engineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
