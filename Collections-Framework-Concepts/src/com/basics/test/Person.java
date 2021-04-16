package com.basics.test;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
		firstName = "NA";
		lastName = "NA";
		id=-1;
		age=-1;
	}
	
	public Person(int id, String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id=id;
		this.age=age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[ID:"+id+" firstName:"+firstName+" lastName:"+lastName+"]\n";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.id==p.getId() ? true : false;
	}
	
	
}
