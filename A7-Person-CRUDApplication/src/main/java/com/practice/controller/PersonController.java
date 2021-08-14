package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.Person;
import com.practice.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public ResponseEntity<List<Person>> getAllPerson(){
		List<Person> p = personService.getAllPerson();
//		if(p.size()==0)
//			throw new ResourceNotFoundException("Resource Not found");
		return new ResponseEntity<List<Person>>(p,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> createPerson(@RequestBody Person person){	
		personService.addPerson(person);
		return new ResponseEntity<String>("Created",HttpStatus.OK);
	}
}
