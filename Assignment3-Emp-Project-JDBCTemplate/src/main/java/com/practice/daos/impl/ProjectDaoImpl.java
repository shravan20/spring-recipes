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
		final String SQL = "select * from project";
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
		final String SQL = "update project set projectname=? , duration=?, members=? where id = ?";
		jdbcTemplate.update(SQL, project.getId(), project.getProjectName(), project.getDuration(), project.getMembers());
	}

	@Override
	public Project getProject(int id) {
		final String SQL="select * from project where id = ?";
		Project project = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new ProjectRowMapper());
		System.out.println("Project fetched from DB");
		return project;
	}

	@Override
	public void deleteProject(int id) {
		final String SQL="delete from project where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Project deleted from DB");
	}

}
