package usecases;

import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import Exception.Exception_Engineer;


	public class EngineerChangePassword {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
		
	System.out.println("Enter Your Email");
	String email = sc.next();		
	System.out.println("Enter new password");
	String newpassword = sc.next();
		
	EngineerDao dao = new EngineerDaoImpl();
		
	try {
		dao.ChangePassword(email, newpassword);
		System.out.println("Changed Successfully");
	}catch(Exception_Engineer e){
		e.printStackTrace();
	}

	}

}
