package Main;

import java.util.Scanner;
import usecases.AssignEngineerTask;
import usecases.DeleteEngineer;
import usecases.EnginnerDetail;
import usecases.GetAllComplain;
import usecases.RegisterEngineer;


public class HodMain {
	public static void main(String[] args) {
		System.out.println("Welcome HOD");
		System.out.println("Select Options to Continue");
		System.out.println("1.Register New Engineer");
		System.out.println("2.See List of All Engineer");
		System.out.println("3.Delete Engineer");
		System.out.println("4.See All Complaints");
		System.out.println("5.Assign Engineer to Complaint");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			
		case 1:
			RegisterEngineer.main(args);
		case 2:
			EnginnerDetail.main(args);
		case 3:
			DeleteEngineer.main(args);
		case 4:
			GetAllComplain.main(args);
		case 5:
			AssignEngineerTask.main(args);
		default:
			System.out.println("Invalid input");
			Main.main(args);
		}	

	}
	
}
