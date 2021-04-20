package com.practice.models;

public class Employee {
	
	private int age;
	private String firstname;
	private String lastname;
	private double salary;
	
	public Employee(int age, String firstname, String lastname, double salary) {
		super();
		this.age = age;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee[age="+age+", firstname="+firstname+", lastname="+lastname+"]";
	}
}