package com.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.daos.impl.RelationShipDAOImpl;

@Service
public class RelationShipServiceImpl {

	@Autowired
	private RelationShipDAOImpl dao;
	
	public void testOneToOne() {
		dao.testOneToOne();
	}
	
	public void testOneToMany() {
		dao.testOneToMany();
	}
	
	public void testManytoOne() {
		dao.testManyToOne();
	}
	
	public void testManytoMany() {
		dao.testManytoMany();
	}
	
}
