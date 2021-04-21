package com.practice.models;

import java.util.List;

public class Project {

	// Project (id->int,name->string,duration->int, members->List<Employee>)
	
	private int id;
	
	private int duration;
	
	private String projectName;
	
	private List<Employee> Members;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getMembers() {
		return Members;
	}

	public void setMembers(List<Employee> members) {
		Members = members;
	}
	
	
}
