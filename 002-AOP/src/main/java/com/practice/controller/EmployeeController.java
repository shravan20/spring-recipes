package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.Employee;
import com.practice.services.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path="/add/employee")
	public Employee addEmployee(
								@RequestParam("age") int age,
								@RequestParam("fname") String firstName,
								@RequestParam("lname") String lastName,
								@RequestParam("salary") double salary
							   ) {
		return employeeService.createEmployee(age, firstName, lastName, salary);
	}
	
	@GetMapping(path="/update/employee")
	public String update(Employee employee) {
		employeeService.updateEmployee(employee);
		return "Updated";
	}
	
	@GetMapping(path="/delete/employee")
	public String delete() {
		employeeService.deleteEmployee();
		return "Deleted";
	}
}
