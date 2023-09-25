package com.jdbc.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbc.springjdbc.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Employee employee) {
		
		return jdbcTemplate.update("insert into tbl_employees(name,email,department) values(?,?,?)",new Object[] {employee.getName(),employee.getEmail(),employee.getDepartment()});
	}

	@Override
	public int update(Employee employee, int id) {

		return jdbcTemplate.update("update tbl_employees set name=?,email=?,department=? where id=?",new Object[] {employee.getName(),employee.getEmail(),employee.getDepartment()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from tbl_employees where id=?",id);
	}

	@Override
	public List<Employee> getAll() {
		
		return jdbcTemplate.query("select * from tbl_employees", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee getById(int id) {

		return jdbcTemplate.queryForObject("select * from tbl_employees where id=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}

}
