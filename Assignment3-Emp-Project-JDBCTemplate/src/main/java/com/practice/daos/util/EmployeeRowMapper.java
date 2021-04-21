package com.practice.daos.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.practice.models.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeName(rs.getString("employeeName"));
		employee.setEmployeeDesgination(rs.getString("employeeDesignation"));
		employee.setId(rs.getInt("id"));
		
		return employee;
	}	
}
