package usecases;

import java.util.List;

import DAO.HOD_Login;
import DAO.HOD_LoginImpl;
import model.Engineer;


public class EnginnerDetail {

	public static void main(String[] args) {
		
		HOD_Login allData =new HOD_LoginImpl();
		List<Engineer> engineerDetail= allData.AllEngineer();
		
		engineerDetail.forEach(s -> System.out.println(s));
		
		
	}
}
