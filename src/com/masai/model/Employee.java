package com.masai.model;

public class Employee {

	private int empid;
	private String empname;
	private String empemail;
	private String emppassword;
	
// paramaterized constructor
	public Employee(int empid, String empname, String empemail, String emppassword) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empemail = empemail;
		this.emppassword = emppassword;
	}
	
//	No-arg constructor	
	public Employee() {
		super();
	}
	
//	toString method	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empemail=" + empemail + ", emppassword="
				+ emppassword + "]";
	}
	
//	Getter and Setter method	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	
	
	
}
