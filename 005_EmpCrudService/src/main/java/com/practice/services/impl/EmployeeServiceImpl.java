package com.practice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.daos.EmployeeDAO;
import com.practice.models.Employee;
import com.practice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);		
		return employees;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return (employeeDao.save(employee)!=null?true:false);
	}

	@Override
	public boolean updateEmployee(Integer empId, Employee employee) {
		Optional<Employee> container = employeeDao.findById(empId);
		if(!container.isPresent())
			return false;
		
		Employee empToUpdate = container.get();
		
		empToUpdate.setFirstName(employee.getFirstName());
		empToUpdate.setLastName(employee.getLastName());
		empToUpdate.setSalary(employee.getSalary());
		return (employeeDao.save(empToUpdate)!=null?true:false);
	}

	@Override
	public Employee getEmployee(Integer empId) {
		Optional<Employee> container = employeeDao.findById(empId);
		Employee emp = null;
		if(container.isPresent()) {
			emp = container.get();
		}
		
		return emp;
	}

	@Override
	public boolean deleteEmployee(Integer empId) { 
		Optional<Employee> container = employeeDao.findById(empId);
		if(!container.isPresent()) {
			return false;
		}
		employeeDao.deleteById(empId);
		return true;
		
	}
	
}
