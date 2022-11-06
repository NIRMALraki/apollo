package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.Department;
import com.employee.bean.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository dr;
	
	@Autowired
	EmployeeRepository er;
	
	public String getEmployees(int id)
	{
		return dr.findById(id).get().getEmployee().toString();
	}
	
	public String AddEmp(int empid,int deptid)
	{
		Optional<Employee> result = er.findById(empid);
		if(result.isPresent())
		{
			Department d = new Department();
			d.setD_id(deptid);
			result.get().setDept(d);
			er.saveAndFlush(result.get());
			return "Employee added";
		}
		return "employee not found";
	}
	
	public String AddDept(Department d)
	{
		try {
			dr.save(d);
			return "Department Created";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "unsucessfull";
		}
		
	}

}
