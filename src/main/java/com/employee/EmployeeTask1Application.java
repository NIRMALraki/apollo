package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.employee")
@EnableJpaRepositories(basePackages = "com.employee.repository")
public class EmployeeTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTask1Application.class, args);
	}

}
