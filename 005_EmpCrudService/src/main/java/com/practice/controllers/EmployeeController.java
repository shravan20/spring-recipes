package com.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.exceptions.CannotAddException;
import com.practice.exceptions.ResourceAlreadyExistsException;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.models.Employee;
import com.practice.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "EmployeeCRUD", description = "CRUD Employee Operations")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value="View List of all Employees", response=Iterable.class)
	@ApiResponses(
			value = {
					@ApiResponse(code=200, message="Successful Execution"),
					@ApiResponse(code=404, message="Resource Not Found"),
					@ApiResponse(code=401, message="Unauthorized")
					
			}
			)
	@GetMapping(path="/employees/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		if(employees.size()==0)
			throw new ResourceNotFoundException("Resource Not found");
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	
	@ApiResponses(
			value = {
					@ApiResponse(code=200, message = "Successful Execution"),
					@ApiResponse(code=404, message = "Resource Not Found")
			}
			)
	@GetMapping(path="/employees/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId){
		Employee employee = employeeService.getEmployee(empId);
		if(employee==null) {
			throw new ResourceNotFoundException("Resource Not Found");		
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}
	
	
	@ApiResponses(
			value= {
					@ApiResponse(code=200, message = "Successful Execution"),
					@ApiResponse(code=405, message = "Already exists")
			}
			)
	@PostMapping(path="/employees")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		String retVal = "Failed";
		Employee emp = employeeService.getEmployee(employee.getId());
		
		if(emp!=null) {
			throw new ResourceAlreadyExistsException("EmployeeAlreadyExists Exception");
		}
		
		boolean status = employeeService.addEmployee(employee);
		
		if(!status) {
			throw new CannotAddException("Unable to add Employee");
		}
		
		retVal="Success";
		
		return new ResponseEntity<String> (retVal, HttpStatus.OK);
	}
	
	
	@ApiResponses(
			value= {
					@ApiResponse(code=200, message = "Successful Execution"),
					@ApiResponse(code=404, message = "Resource Not Found")
			}
			)
	@PutMapping(path="/employees/{empId}")
	public ResponseEntity<String> update(@RequestBody Employee employee, @PathVariable("empId") int empId){
		String retVal = "Failed";
		Employee emp = employeeService.getEmployee(employee.getId());
		
		if(emp==null)
			throw new ResourceNotFoundException("Unable to Update");
		
		boolean status = employeeService.updateEmployee(empId, employee);
		retVal="Success";
		return new ResponseEntity<String>(retVal, HttpStatus.OK);
	}
	
	@ApiResponses(
			value= {
					@ApiResponse(code=200, message = "Successful Execution"),
					@ApiResponse(code=404, message = "Resource Not Found")
			}
			)
	@DeleteMapping(path="/employees/{empId}")
	public ResponseEntity<String> delete(@PathVariable("empId") int empId){
		String retVal = "Failed";
		Employee emp = employeeService.getEmployee(empId);
		if(emp==null)
			throw new ResourceNotFoundException(retVal);
		boolean status = employeeService.deleteEmployee(empId);
		if(status)
			retVal = "Success";
		
		return new ResponseEntity<String>(retVal, HttpStatus.OK);
		
	}
	
}
