package usecases;

import java.util.Scanner;
import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import Exception.Exception_Complain;

public class EngineerUpdateStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint ID to Update");
		int comid = sc.nextInt();
		
		System.out.println("Enter New Status of Complaint");
		String status = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();

		try {
			dao.UpdateAssignedComplaintStatus(comid, status);
			System.out.println("Status Updated Successfully");
		} catch (Exception_Complain e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
