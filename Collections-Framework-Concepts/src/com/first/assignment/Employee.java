package com.first.assignment;

public class Employee {

	private int employeeNo;
	private String employeeName;
	private String employeeAddress;
	
	
	
	public Employee(int employeeNo, String employeeName, String employeeAddress) {
		super();
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	@Override
	public String toString() {
		return "[Employee Id="+employeeNo+" Employee Name="+employeeName+" Employee Address="+employeeAddress+"]\n";
	}
	
}
