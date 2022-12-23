package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ExceptionEmployee;
import com.masai.model.Complain;
import com.masai.model.Employee;
import com.masai.utilities.DBUtil;


public class EmployeeDaoImpl implements EmployeeDao {
//	Register Employee by the name,email,password
	@Override
	public String registerEmployee(Employee employee) {
		String message = "Registered Successfully";
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(empname,empemail,emppassword) value(?,?,?)");
			ps.setString(1, employee.getEmpname());
			ps.setString(2, employee.getEmpemail());
			ps.setString(3, employee.getEmppassword());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Registered Successfully !";
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}

		return message;

	}

//	Employee can login by the email,password
	@Override
	public String EmployeeLogin(String email, String password) throws ExceptionEmployee {
		String message = "Invalid username or password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where empemail=? AND emppassword=?");
			
			ps.setString(1,email);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				message = "Login Successfull";
			}	
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return message;
	}
	
// Employee can update  password or email
	@Override
	public String ChangePassword(String email, String password) throws ExceptionEmployee {
		String message = "Invalid password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set emppassword=? where empemail=? ");
			
			ps.setString(1,password);
			ps.setString(2,email);
			
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				message = "password changed successfully !";
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return message;
	}
	
//	Employee can register complain by his ID
	@Override
	public String registerComplain(Complain complain) {
		String message = "Invalid complain";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into complain(category,status,empid) value(?,?,?)");
			
			ps.setString(1,complain.getCategory());
			ps.setString(2,complain.getStatus());
			ps.setInt(3, complain.getEmpid());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Comaplain Registered Successfully !";
			
		}catch(SQLException e){
			
			message = e.getMessage();
			
		}
		return message;
	}

//	Employee can check all the complain list assigned by him/her
	@Override
	public List<Complain> ComplainList(int empId) throws ExceptionEmployee {
		List <Complain> complainList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complain where empid=?");
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("comid");
				String c = rs.getString("category");
				String s = rs.getString("status");
				int epi = rs.getInt("empid");
				int egi = rs.getInt("engid");
				
				Complain complain = new Complain(i,c,s,epi,egi);
				complainList.add(complain);
			}
			
		}catch(SQLException e){
			
			throw new ExceptionEmployee(e.getMessage());
			
		}
		
		if(complainList.size() == 0)
			throw new ExceptionEmployee("No Complain found..");
		
		return complainList;
		
	}

}
