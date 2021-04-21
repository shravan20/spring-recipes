package com.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.services.impl.RelationShipServiceImpl;

@RestController
@RequestMapping("/mapping")
public class RelationShipController {

	@Autowired
	private RelationShipServiceImpl service;
	
	@GetMapping(path = "/onetoone")
	public void testOneToOne() {
		service.testOneToOne();
	}
	
	@GetMapping(path = "/onetomany")
	public void testOnetoMany() {
		service.testOneToMany();
	}
	
	@GetMapping(path = "/manytoone")
	public void testManytoOne() {
		service.testManytoOne();
	}
	
	@GetMapping(path = "/manytomany")
	public void testManytoMany() {
		service.testManytoMany();
	}
}
