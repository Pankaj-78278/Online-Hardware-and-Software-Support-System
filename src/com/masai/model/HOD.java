package com.masai.model;

public class HOD {
	private String HOD_username;
	private String HOD_password;
	
// paramaterized constructor	
	public HOD(int hODId, String hOD_username, String hOD_password) {
		super();
		HOD_username = hOD_username;
		HOD_password = hOD_password;
	}
	
//	toString method
	@Override
	public String toString() {
		return "HOD [HOD_username=" + HOD_username + ", HOD_password=" + HOD_password + "]";
	}
	
//    No-args Constructor	
	public HOD() {
		super();
	}

//	Getter and Setter method
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
