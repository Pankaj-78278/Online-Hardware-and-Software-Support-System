package com.masai.model;

public class Engineer {
	private int engid;
	private String engname;
	private String engemail;
	private String engpassword;
	
// paramaterized constructor	
	public Engineer(int engid, String engname, String engemail, String engpassword) {
		super();
		this.engid = engid;
		this.engname = engname;
		this.engemail = engemail;
		this.engpassword = engpassword;
	}
	
//	No-args Constructor
	public Engineer() {
		super();
	}
	
//	toString method
	@Override
	public String toString() {
		return "Engineer [engid=" + engid + ", engname=" + engname + ", engemail=" + engemail + ", engpassword="
				+ engpassword + "]";
	}
	
//	Getter and Setter method	
	public int getEngid() {
		return engid;
	}
	public void setEngid(int engid) {
		this.engid = engid;
	}
	public String getEngname() {
		return engname;
	}
	public void setEngname(String engname) {
		this.engname = engname;
	}
	public String getEngemail() {
		return engemail;
	}
	public void setEngemail(String engemail) {
		this.engemail = engemail;
	}
	public String getEngpassword() {
		return engpassword;
	}
	public void setEngpassword(String engpassword) {
		this.engpassword = engpassword;
	}
	
	
}
