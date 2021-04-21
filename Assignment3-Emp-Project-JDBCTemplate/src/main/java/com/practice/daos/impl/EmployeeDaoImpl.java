package com.practice.daos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.daos.EmployeeDAO;
import com.practice.daos.util.EmployeeRowMapper;
import com.practice.models.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> getEmployees() {
		final String SQL = "select * from employee";
		return jdbcTemplate.query(SQL, new EmployeeRowMapper());
	}

	@Override
	public void createEmployee(Employee employee) {
		final String SQL="insert into employee(id,employeename, employee) values(?,?,?)";
		jdbcTemplate.update(SQL, employee.getId(), employee.getEmployeeName(), employee.getEmployeeDesgination());
		System.out.println("Employee Added");
	}

	@Override
	public void updateEmployee(Employee employee) {
		final String SQL = "update employee set employeename=?, employeedesignation=? where id=?";
		jdbcTemplate.update(SQL,employee.getEmployeeName(), employee.getEmployeeDesgination(), employee.getId());
		System.out.println("Employee Data Updated");
	}

	@Override
	public Employee getEmployee(int id) {
		final String SQL = "select * from employee where id =?";
		Employee employee = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new EmployeeRowMapper());
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		final String SQL = "delete from topic where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Topic Deleted!!");
		
	}

	
	
}
