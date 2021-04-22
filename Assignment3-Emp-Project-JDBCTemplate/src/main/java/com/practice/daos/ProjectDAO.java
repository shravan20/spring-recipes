package com.practice.daos;

import java.util.List;

import com.practice.models.Project;

public interface ProjectDAO {
	List<Project> getProjects();
	void createProject(Project project);
	void updateProject(Project project);
	Project getProject(int id);
	void deleteProject(int id);
}
