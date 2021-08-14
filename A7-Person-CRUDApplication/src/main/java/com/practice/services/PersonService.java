package com.practice.services;

import java.util.List;

import com.practice.models.Person;

public interface PersonService {

	List<Person> getAllPerson();
	boolean addPerson(Person person);
	
}
