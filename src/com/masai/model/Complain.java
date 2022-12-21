
package com.masai.model;

public class Complain {
	private int compid;
	private String category;
	private String status;
	private int empid;
	private int engid;
	public Complain(int compid, String category, String status, int empid, int engid) {
		super();
		this.compid = compid;
		this.category = category;
		this.status = status;
		this.empid = empid;
		this.engid = engid;
	}
	public Complain() {
		super();
	}
	@Override
	public String toString() {
		return "Complain [compid=" + compid + ", category=" + category + ", status=" + status + ", empid=" + empid
				+ ", engid=" + engid + "]";
	}
	public int getCompid() {
		return compid;
	}
	public void setCompid(int compid) {
		this.compid = compid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getEngid() {
		return engid;
	}
	public void setEngid(int engid) {
		this.engid = engid;
	}
	
}
