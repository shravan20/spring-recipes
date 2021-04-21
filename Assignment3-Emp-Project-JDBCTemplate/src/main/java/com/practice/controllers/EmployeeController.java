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

import com.practice.models.Employee;
import com.practice.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path="/{id}")
	public Employee findById(@PathVariable("id") int id) {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping(path="/")
	public List<Employee> findAll(){
		return employeeService.getEmployees();
	}
	
	@PostMapping("/")
	public void create(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@DeleteMapping(path="/")
	public void delete(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}
	
	
}
