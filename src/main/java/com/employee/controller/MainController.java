package com.employee.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.Department;
import com.employee.bean.Employee;
import com.employee.service.DepartmentService;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class MainController {
	
	Logger logger = LogManager.getLogger(MainController.class);
	
	@Autowired
	EmployeeService es;
	
	@Autowired
	DepartmentService ds;
	
	 
	@PostMapping("createemp")
	public String createEmp(@RequestBody Employee e)
	{
		 logger.trace(e);
		return es.createEmp(e);
	}
	
	@PostMapping("createdept")
	public String createDept(@RequestBody Department d)
	{
		logger.trace(d);
		return ds.AddDept(d);
	}
	
	@GetMapping("getEmp/{id}")
	public String getEmp(@PathVariable int id)
	{
		logger.trace(id);
		return ds.getEmployees(id);
	}
	
	@PatchMapping("addEmp/{empid}/{deptid}")
	public String addEmp(@PathVariable int empid,@PathVariable int deptid)
	{
		logger.trace("empid = "+empid+" deptid = "+deptid );
		return ds.AddEmp(empid, deptid);
	}
	
	@GetMapping("emp/{id}")
	public String emp(@PathVariable int id)
	{
		return es.getEmp(id);
	}
	

}
