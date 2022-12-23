package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ExceptionComplain;
import com.masai.exception.ExceptionEngineer;
import com.masai.exception.ExceptionHOD;
import com.masai.model.Complain;
import com.masai.model.Engineer;
import com.masai.model.HOD;
import com.masai.utilities.DBUtil;

public class HodLoginImpl implements HodLogin  {

//	hod can register by his/her name,email,password
	@Override
	public String registerEngineer(Engineer engineer) throws ExceptionEngineer {
		String result="Not Inserted";
			
		try(Connection conn=DBUtil.provideConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("insert into engineer(Engname,Engemail,Engpassword) values(?,?,?)");
			ps.setString(1, engineer.getEngname());
			ps.setString(2, engineer.getEngemail());
			ps.setString(3, engineer.getEngpassword());
		
		int x=ps.executeUpdate();		
			
		if(x>0) {
			result= "Enginner inserted successfully";
		}
	
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ExceptionEngineer(e.getMessage());
		}

		return result;
	}

//	hod can signin by his/her username and password
	@Override
	public String SignInHod(String Username, String Password) throws ExceptionHOD {
		String res ="Not inserted";
	
		try(Connection conn=DBUtil.provideConnection()) {
		
			PreparedStatement ps =conn.prepareStatement("insert into signinhod values(?,?)");
			
			ps.setString(1,Username );
			ps.setString(2,Password);
			
			int rs =ps.executeUpdate();
			
			if(rs>0) {
				res ="HOD Login Succesfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ExceptionHOD(e.getMessage());
			
		}
		return res;
	}

//	hod can login by his own credentials
	@Override 
	public HOD LoginInHOD (String username, String password) throws ExceptionHOD {
		HOD hodtoeng= null;
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from signinhod where email=? AND password= ?");
			
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next()) {
				String e= rs.getString("email");
				String p= rs.getString("password");
				
				
			}else {
				throw new ExceptionHOD("Invalid Username or password");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ExceptionHOD(e.getMessage());
		}		
		return hodtoeng;
	}
	
	
//	hod can check list of all engineer 
	@Override
	public List<Engineer> AllEngineer() {
		
		List<Engineer> engineerDetail= new ArrayList<Engineer>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps =conn.prepareStatement("select * from engineer");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("engid");
				String name = rs.getString("engname");
				String email = rs.getString("engemail");
				String password = rs.getString("engpassword");
				
			
				Engineer hodtoeng= new Engineer(id,name,email,password);				
				
				engineerDetail.add(hodtoeng); 	
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return engineerDetail;
	}

//	hod can delete the engineer by his engineer id
	@Override
	public String deleteEngineer(int engid) throws ExceptionEngineer {
			String delEng= "Not Deleted";
			
			try(Connection conn= DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("delete from engineer where engid=?");
				
				ps.setInt(1, engid);
				
				
				int rs=ps.executeUpdate();
				
				
				if(rs>0) {
					delEng= "Engineer Delete Successfully";
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		
			return delEng;
		}
	
//	hod can check all the list of the complain assigned by the employee
	@Override
	public List<Complain> getAllComplainList() throws ExceptionComplain {
		
		List<Complain> task = new ArrayList<Complain>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =conn.prepareStatement("select * from complain");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				int com=rs.getInt("Comid");
				String c = rs.getString("category");
				String s = rs.getString("status");
				int epi = rs.getInt("empid");
				int egi = rs.getInt("engid");
				
				
				Complain complain =new Complain(com,c,s,epi,egi);
				
				task.add(complain);
			}
			
		}	
			catch(SQLException e) {
				throw new ExceptionComplain(e.getMessage());
			}
			
			if(task.size() == 0)
				throw new ExceptionComplain("No Complaints Found ..!");	
		return task;
		
	}

	
//	hod can assigned task to engineer by the engineer Id
	@Override
	public String assignComplaintToEngineer(int Comid,int engid)  throws ExceptionEngineer,ExceptionComplain {
	String message = "Not Assigned";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement(" update complain set engid=? where comid=?");
			
			ps.setInt(1, engid);
			ps.setInt(2, Comid);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Engineer Assigned Successfullt";
			}
			
		}catch(SQLException e) {
			throw new ExceptionComplain(e.getMessage());
		}
		
		return message;	
		}

}
