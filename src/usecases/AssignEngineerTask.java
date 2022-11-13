package usecases;

import java.util.Scanner;

import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import Exception.Exception_Complain;
import Exception.Exception_Engineer;

public class AssignEngineerTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint ID : ");
		int complaintID = sc.nextInt();
		
		System.out.println("Enter Engineer ID : ");
		int engineerId = sc.nextInt();
		

		HOD_Login dao= new HOD_LoginImpl();
		
		try {
			String result=dao.assignComplaintToEngineer(complaintID, engineerId);

			System.out.println("Complaint Assigned Successfully");
		} catch (Exception_Complain e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception_Engineer e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
