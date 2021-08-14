package com.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.daos.MyDAO;

@Service
public class MyService {

	@Autowired
	private MyDAO dataService;
	
	public int findTheGreatest() {
		int []data = dataService.retreiveAllData();
		int greatest = Integer.MIN_VALUE;
		for(int value:data) {
			if(value>greatest)
				greatest=value;
		
		}
		return greatest;
	}
	

}