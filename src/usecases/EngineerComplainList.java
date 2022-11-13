package usecases;

import java.util.List;
import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import Exception.Exception_Engineer;
import model.Complain;



public class EngineerComplainList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your EngineerId : ");
		int id = sc.nextInt();
		
		EngineerDao dao= new EngineerDaoImpl();
		
		List<Complain> list;
		
		try {
			list= dao.ComplainList(id);
			list.forEach(s -> System.out.println(s));
			
		} catch (Exception_Engineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
