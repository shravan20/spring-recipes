package com.practice.services;

import org.springframework.stereotype.Service;

import com.practice.models.Employee;

@Service
public class EmployeeService {

	public Employee createEmployee(int age, String firstName, String lastName, double salary) {		
		Employee emp = new Employee(age, firstName, lastName, salary);
		System.out.println("EmployeeService::"+emp);
		return emp;
	}

	public void updateEmployee(Employee employee) {		
		System.out.println("EmployeeService::"+employee);
	}
	
	public void deleteEmployee() {		
		System.out.println("Deleted EmployeeService");
	}
	
}
