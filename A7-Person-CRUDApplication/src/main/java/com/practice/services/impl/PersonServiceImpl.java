package com.practice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.models.Person;
import com.practice.services.PersonService;

import daos.PersonDAO;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO personDao;
	
	@Override
	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<>();
		personDao.findAll().forEach(persons::add);
		return persons;
	}

	@Override
	public boolean addPerson(Person person) {
		return (personDao.save(person)!=null?true:false);
	}

}
