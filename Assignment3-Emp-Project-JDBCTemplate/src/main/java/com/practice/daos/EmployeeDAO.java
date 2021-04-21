package com.practice.daos;

import java.util.List;

import com.practice.models.Employee;

public interface EmployeeDAO {
 
	List<Employee> getEmployees();
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployee(int id);
	void deleteEmployee(int id);

}
