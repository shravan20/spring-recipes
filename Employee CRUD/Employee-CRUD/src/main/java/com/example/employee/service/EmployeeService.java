package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface EmployeeService {

	EmployeeDto create(EmployeeDto employee);

	EmployeeDto get(Integer id) throws Exception;

	Object filter();

	void generateEmployeeListPdf() throws FileNotFoundException;

	void generateHtmlToPdf() throws IOException;

}
