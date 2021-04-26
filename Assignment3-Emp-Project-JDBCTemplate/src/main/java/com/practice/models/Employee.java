package com.practice.models;

//@table("EmployeeInfo")==>employee_info
public class Employee {

    // Employee (id->int,name->string,designation->string)
	
	private int id;
	// @column("EmployeeName/employeeName") ==> employee_name
	private String employeeName;
	private String employeeDesgination;
	
	
	
	public Employee(int id, String employeeName, String employeeDesgination) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeDesgination = employeeDesgination;
	}
	
	public Employee() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDesgination() {
		return employeeDesgination;
	}
	public void setEmployeeDesgination(String employeeDesgination) {
		this.employeeDesgination = employeeDesgination;
	}
	
		
	
}
