package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exception.Exception_Complain;
import Exception.Exception_Engineer;
import model.Complain;
import model.Engineer;
import utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String RegisterEngineer(Engineer engineer) {
		String message = "Engineer Not Registered";
		
		try(Connection conn = utility.DBUtil.provideConnection()){
			
			
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
	public String Engineerlogin(String email, String Password) throws Exception_Engineer {
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
			throw new Exception_Engineer(e.getMessage());
		}
	
		return result;
	}

	@Override
	public String ChangePassword(String email, String password) throws Exception_Engineer {
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
	public List<Complain> ComplainList(int engid) throws Exception_Engineer {
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
			throw new Exception_Engineer(e.getMessage());
		}
		if(result.size() == 0)
		throw new Exception_Engineer("No Complaint found..");
		return result;

	}

	@Override
	public String UpdateAssignedComplaintStatus(int comid, String status) throws Exception_Complain {
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