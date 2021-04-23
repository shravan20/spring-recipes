package com.practice.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.daos.PersonDAO;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.models.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonDAO personDao;
	
	@GetMapping(path = "/getAll")
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		personDao.findAll().forEach(persons :: add);
		return persons;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") int id){
		Person person = personDao.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Person Not Found")
		);
		
		return ResponseEntity.ok().body(person);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){
		System.out.println(person);
		Person p = personDao.save(person);
		return ResponseEntity.ok().body(p);
	}
		
}
