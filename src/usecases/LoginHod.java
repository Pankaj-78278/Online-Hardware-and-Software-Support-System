package usecases;

import java.util.Scanner;

import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import Exception.Exception_HOD;
import model.HOD;
import model.Engineer;

public class LoginHod {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email/Username");
		String email= sc.next();

		System.out.println("Enter Your Password");
		String password = sc.next();
		
//		HOD hod =new HOD();
//		hod.setHOD_username(email);
//		hod.setHOD_password(password);

		HOD_Login dao= new HOD_LoginImpl();
		
		try {
			 HOD result=dao.LoginInHOD(email, password);
			System.out.println("signup Successfully");
			
			
		} catch (Exception_HOD e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
