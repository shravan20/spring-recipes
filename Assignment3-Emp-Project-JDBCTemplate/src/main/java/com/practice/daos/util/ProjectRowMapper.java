package com.practice.daos.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.practice.models.Employee;
import com.practice.models.Project;

public class ProjectRowMapper implements RowMapper<Project> {


	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		Project project= new Project();
		
		project.setProjectName(rs.getString("projectName"));
		project.setDuration(rs.getInt("duration"));
		project.setId(rs.getInt("id"));
		List<Employee> employees = new ArrayList<>();
		
		employee.setId(rs.getInt("id"));
		employees.add(employee);
		project.setMembers(employees);
		
		return project;
	}	
	
}
