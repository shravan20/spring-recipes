package com.practice.services;

import java.util.List;

import com.practice.models.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	boolean addEmployee(Employee employee);
	boolean updateEmployee(Integer empId, Employee employee);
	public Employee getEmployee(Integer empId);
	public boolean deleteEmployee(Integer empId);


	
}
