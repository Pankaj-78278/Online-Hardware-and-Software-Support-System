package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ExceptionComplain;
import com.masai.exception.ExceptionEngineer;
import com.masai.model.Complain;
import com.masai.model.Engineer;
import com.masai.utilities.DBUtil;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String RegisterEngineer(Engineer engineer) {
		String message = "Engineer Not Registered";
		
		try(Connection conn = com.masai.utilities.DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("insert into engineer(Engname,Engemail,Engpassword) values(?,?,?)");
			ps.setString(1, engineer.getEngname());
			ps.setString(2, engineer.getEngemail());
			ps.setString(3, engineer.getEngpassword());
		
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Engineer Registered Successfully !";
			
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String Engineerlogin(String email, String Password) throws ExceptionEngineer {
		String result= "Invalid Username or Password";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from engineer where engemail=? AND engpassword=?");
			
			ps.setString(1,email);
			ps.setString(2,Password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				result = "Login Successfull";
			}	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ExceptionEngineer(e.getMessage());
		}
	
		return result;
	}

	@Override
	public String ChangePassword(String email, String password) throws ExceptionEngineer {
		String message = "Invalid password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update engineer set engpassword=? where engemail=? ");
			
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

	@Override
	public List<Complain> ComplainList(int engid) throws ExceptionEngineer {
		List<Complain> result= new ArrayList<Complain>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from complain where engid=?");
			
			ps.setInt(1,engid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("comid");
				String c = rs.getString("category");
				String s = rs.getString("status");
				int epi = rs.getInt("empid");
				int egi = rs.getInt("engid");
				Complain complain=new Complain(i,c,s,epi,egi);
				result.add(complain);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ExceptionEngineer(e.getMessage());
		}
		if(result.size() == 0)
		throw new ExceptionEngineer("No Complaint found..");
		return result;

	}

	@Override
	public String UpdateAssignedComplaintStatus(int comid, String status) throws ExceptionComplain {
		String message = "Invalid Complain ID";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update complain set status=? where comid=? ");
			
			ps.setInt(1,comid);
			ps.setString(2,status);
			
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				message = "Complain Status Updated !";
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return message;
	}

}
