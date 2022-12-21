package com.masai.usecases;

import java.util.List;

import com.masai.dao.HodLogin;
import com.masai.dao.HodLoginImpl;
import com.masai.exception.ExceptionComplain;
import com.masai.model.Complain;

public class GetAllComplain {

	public static void main(String[] args) {
		HodLogin dao =new HodLoginImpl();
		
		try {
			List<Complain> result=dao.getAllComplainList();
			result.forEach(s -> System.out.println(s));
			
		} catch (ExceptionComplain e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}