package com.practice.daos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.daos.ProjectDAO;
import com.practice.daos.util.EmployeeRowMapper;
import com.practice.daos.util.ProjectRowMapper;
import com.practice.models.Project;

@Repository
public class ProjectDaoImpl implements ProjectDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Project> getProjects() {
		final String SQL = "select * from Project";
		return jdbcTemplate.query(SQL, new ProjectRowMapper());
	}

	@Override
	public void createProject(Project project) {
		final String SQL="insert into project(id,projectname, duration, members) values(?,?,?,?)";
		jdbcTemplate.update(SQL, project.getId(), project.getProjectName(),project.getDuration(), project.getMembers());
		System.out.println("Project Added");	
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Project getProject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProject(int id) {
		// TODO Auto-generated method stub
		
	}

}
