package com.employee.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.Department;
import com.employee.bean.Employee;
import com.employee.custom.exception.EmptyInputException;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository dr;
	
	@Autowired
	EmployeeRepository er;
	
	Logger logger = LogManager.getLogger(DepartmentService.class);
	
	public String getEmployees(int id)
	{
//		try {
//			return dr.findById(id).get().getEmployee().toString();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error(e.getMessage());
//			return "Department not found";
//		}
		
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
		logger.warn("invalid employeeid");
		return "employee not found";
	}
	
	public String AddDept(Department d)
	{
//		try {
//			dr.save(d);
//			return "Department Created";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error(e.getMessage());
//			return "unsucessfull";
//			
//		}
		if(d.getDname().equals(null)||d.getDname().isEmpty())
		{
			throw new EmptyInputException("601","Department name is not entered");
		}
		else
		{
			dr.save(d);
			return "saved";
		}
		
	}

}
