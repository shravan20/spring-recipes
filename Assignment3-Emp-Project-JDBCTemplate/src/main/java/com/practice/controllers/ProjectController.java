package com.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.practice.models.Project;
import com.practice.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping(path="/{id}")
	public Project findById(@PathVariable("id") int id) {
		return projectService.getProject(id);
	}
	
	@GetMapping(path="/")
	public List<Project> findAll(){
		return projectService.getProjects();
	}
	
	
	@PostMapping("/")
	public void create(@RequestBody Project project) {
		projectService.addProject(project);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") int id) {
		projectService.deleteProject(id); 
	}
}
