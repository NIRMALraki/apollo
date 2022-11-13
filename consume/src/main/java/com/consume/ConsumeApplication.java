package com.consume;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.consume.bean.Employee;

@SpringBootApplication
public class ConsumeApplication {
	public static final String GET_EMP_BY_ID= "http://localhost:8765/employees/emp/{id}";
	public static final String GET_EMP_BY_DEPT= "http://localhost:8765/employees/getEmp/{id}";
	static RestTemplate rest = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(ConsumeApplication.class, args);
		getEmpById();
		getEmpByDept();
	}

	static public void getEmpById()
	{
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", 1);
		Employee emp = rest.getForObject(GET_EMP_BY_ID, Employee.class, param);
		System.out.println(emp.getEname());
		System.out.println(emp.getElocation());
	}
	static public void getEmpByDept()
	{
	
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", 3);
		Employee[] emp = rest.getForObject(GET_EMP_BY_DEPT, Employee[].class, param);
		for (Employee employee : emp) {
			System.out.println(employee);
		}
	}
	
	
}
