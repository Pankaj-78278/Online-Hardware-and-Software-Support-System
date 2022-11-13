package usecases;

import java.util.List;

import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import Exception.Exception_Complain;
import model.Complain;

public class GetAllComplain {

	public static void main(String[] args) {
		HOD_Login dao =new HOD_LoginImpl();
		
		try {
			List<Complain> result=dao.getAllComplainList();
			result.forEach(s -> System.out.println(s));
			
		} catch (Exception_Complain e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}