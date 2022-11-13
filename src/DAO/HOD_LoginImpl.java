package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exception.Exception_Complain;
import Exception.Exception_Engineer;
import Exception.Exception_HOD;
import model.Engineer;
import model.Complain;
import model.HOD;
import utility.DBUtil;

public class HOD_LoginImpl implements HOD_Login  {

	
	@Override
	public String registerEngineer(Engineer engineer) throws Exception_Engineer {
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
			throw new Exception_Engineer(e.getMessage());
		}

		return result;
	}

	@Override
	public String SignInHod(String Username, String Password) throws Exception_HOD {
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
			throw new Exception_HOD(e.getMessage());
			
		}
				
		
		return res;
	}

	@Override 
	public HOD LoginInHOD (String username, String password) throws Exception_HOD {
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
				throw new Exception_HOD("Invalid Username or password");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception_HOD(e.getMessage());
		}
		
		
		
		return hodtoeng;
	}

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

	@Override
	public String deleteEngineer(int engid) throws Exception_Engineer {

//		public String deleteEngineer(int engid) throws Exception_Engineer {
			
			String delEng= "NOt Deleted";
			
			try(Connection conn= DBUtil.provideConnection()) {
				PreparedStatement ps=conn.prepareStatement("delete from engineer where engid=?");
				
				ps.setInt(1, engid);
				
				
				int rs=ps.executeUpdate();
				
				
				if(rs>0) {
					delEng= "Engineer Delete Successfully";
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
//				throw new Exception_HOD(e.getMessage());
			}

		
			return delEng;
		}
	
	@Override
	public List<Complain> getAllComplainList() throws Exception_Complain {
		
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
				throw new Exception_Complain(e.getMessage());
			}
			
			if(task.size() == 0)
				throw new Exception_Complain("No Complaints Found ..!");	
		return task;
		
	}

	@Override
	public String assignComplaintToEngineer(int Comid,int engid)  throws Exception_Engineer,Exception_Complain {
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
			throw new Exception_Complain(e.getMessage());
		}
		
		return message;	
		}

}
