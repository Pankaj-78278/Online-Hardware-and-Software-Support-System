package usecases;

import java.util.Scanner;

import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import Exception.Exception_HOD;

public class SignInHOD {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username/Email :");
		String username= sc.next();

		System.out.println("Enter Password :");
		String password= sc.next();
		
		HOD_Login dao = new HOD_LoginImpl();
		
		try {
			String result= dao.SignInHod(username, password);
			System.out.println(result);
		} catch (Exception_HOD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
