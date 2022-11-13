package model;

public class HOD {
//	private int HODId;
	private String HOD_username;
	private String HOD_password;
	public HOD(int hODId, String hOD_username, String hOD_password) {
		super();
//		HODId = hODId;
		HOD_username = hOD_username;
		HOD_password = hOD_password;
	}
	@Override
	public String toString() {
		return "HOD [HOD_username=" + HOD_username + ", HOD_password=" + HOD_password + "]";
	}
	public HOD() {
		super();
	}
//	public int getHODId() {
//		return HODId;
//	}
//	public void setHODId(int hODId) {
//		HODId = hODId;
//	}
	public String getHOD_username() {
		return HOD_username;
	}
	public void setHOD_username(String hOD_username) {
		HOD_username = hOD_username;
	}
	public String getHOD_password() {
		return HOD_password;
	}
	public void setHOD_password(String hOD_password) {
		HOD_password = hOD_password;
	}
	
	
	
	
	
}
