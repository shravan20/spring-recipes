package com.practice.services;

import java.util.List;
import com.practice.models.Project;

public interface ProjectService {

	List<Project> getProjects();
	void addProject(Project project);
	void updateProject(Project project);
	Project getProject(int id);
	void deleteProject(int id);
	
}
