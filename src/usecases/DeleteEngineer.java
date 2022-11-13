package usecases;

import java.util.Scanner;

import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import Exception.Exception_Engineer;
import model.HOD;
import model.Engineer;

public class DeleteEngineer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Engineer ID");
		int id=sc.nextInt();

		HOD_Login hodDelete= new HOD_LoginImpl();
		
		String eng;
		try {
			eng = hodDelete.deleteEngineer(id);
			
			if(eng!=null) {
				System.out.println("delete engineer successfully");
			}else {
				System.out.println("Engineer table is empty");
			}
			
		} catch (Exception_Engineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
