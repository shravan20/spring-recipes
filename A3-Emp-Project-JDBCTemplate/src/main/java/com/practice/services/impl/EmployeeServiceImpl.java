package com.practice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.daos.EmployeeDAO;
import com.practice.models.Employee;
import com.practice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public void addEmployee(Employee employee) {
			employeeDao.createEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);		
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeDao.getEmployee(id);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(id);
	}

}
