package com.masai.usecases;

import java.util.List;

import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.model.Engineer;


public class EnginnerDetail {

	public static void main(String[] args) {
		
		HodLogin allData =new HodLoginImpl();
		List<Engineer> engineerDetail= allData.AllEngineer();
		
		engineerDetail.forEach(s -> System.out.println(s));
		
		
	}
}
