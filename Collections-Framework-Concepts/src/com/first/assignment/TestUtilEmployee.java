package com.first.assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class TestUtilEmployee {

	private ArrayList<Employee> employees;

	public TestUtilEmployee() {
		this.employees =  new ArrayList<Employee>();
	}
	
	public void addInput(Employee e) {
		this.employees.add(e);
	}
	
	public void display() {
		Iterator<Employee> itr = employees.iterator(); 
		while(itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println(emp);
		}
	}
}
