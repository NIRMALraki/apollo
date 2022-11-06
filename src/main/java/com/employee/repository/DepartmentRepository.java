package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.bean.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
