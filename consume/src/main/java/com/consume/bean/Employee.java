package com.consume.bean;



public class Employee {

	private int eid;
	private String ename;
	private String elocation;
	
	private Department dept;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getElocation() {
		return elocation;
	}

	public void setElocation(String elocation) {
		this.elocation = elocation;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", elocation=" + elocation +  "]";
	}
	
	
}
