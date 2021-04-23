package com.practice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.daos.ProjectDAO;
import com.practice.models.Project;
import com.practice.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDao;
	
	@Override
	public List<Project> getProjects() {
		return projectDao.getProjects();
	}

	@Override
	public void addProject(Project project) {
		projectDao.createProject(project);
		
	}

	@Override
	public void updateProject(Project project) {
		projectDao.updateProject(project);
		
	}

	@Override
	public Project getProject(int id) {
		return projectDao.getProject(id);
	}

	@Override
	public void deleteProject(int id) {
		projectDao.deleteProject(id);
	}

	
	
}
