package com.practice.daos;

import org.springframework.data.repository.CrudRepository;

import com.practice.models.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

}
