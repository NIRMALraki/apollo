package com.consume.bean;

import java.util.ArrayList;
import java.util.List;



public class Department {
	
	private int d_id;
	private String dname;
	private List<Employee> employee= new ArrayList<Employee>();
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", dname=" + dname + ", employee=" + employee + "]";
	}
	

}
