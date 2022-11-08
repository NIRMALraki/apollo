package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.Employee;
import com.employee.custom.exception.EmptyInputException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository er;
	
	
	public String createEmp(Employee e)
	{
		if(e.getEname().equals(null)||e.getEname().isEmpty())
		{
			throw new EmptyInputException("602","Employee name is not entered");
		}
			er.save(e);
			return "Employee Created";
		
	}
	
	public String getEmp(int id)
	{
//		Optional<Employee> result = er.findById(id);
//		if(result.isPresent())
//		{
//			return result.get().toString();
//		}
//		
//		return "Employee not found";
		return er.findById(id).get().toString();
	}

}
