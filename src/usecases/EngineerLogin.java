package usecases;

import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import Exception.Exception_Engineer;



public class EngineerLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer Email : ");
		String email = sc.next();
		
		System.out.println("Enter Engineer password : ");
		String password = sc.next();

		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			dao.Engineerlogin(email, password);
			
			System.out.println("Welcome Engineer !");
		} catch (Exception_Engineer e) {
			System.out.println(e.getMessage());
		}

	}

}
