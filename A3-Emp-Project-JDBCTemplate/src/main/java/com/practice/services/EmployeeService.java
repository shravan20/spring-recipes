package com.practice.services;

import java.util.List;

import com.practice.models.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployee(int id);
	void deleteEmployee(int id);
}
