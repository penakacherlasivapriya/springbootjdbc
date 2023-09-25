package com.jdbc.springjdbc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdbc.springjdbc.model.Employee;

@Repository
public interface EmployeeDao {
	
	int save(Employee employee);
	int update(Employee employee, int id);
	int delete(int id);
	List<Employee> getAll();
	Employee getById(int id);

}
