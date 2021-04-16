package com.first.assignment;

import com.basics.test.Person;

public class Student {

	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		Student student = (Student) o;
		return this.name == student.name ? true : false;
	}
	
	
}
