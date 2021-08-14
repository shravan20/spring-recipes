package com.practice.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path="/")
	public String rootUrl() { 
		return "This is permitted to all";
	}
	
	@GetMapping(path="/rest/hello")
	public String sayHello() {
		String userName = getUserName();
		return "Hi there - This is permitted only to Role Admin ::" + userName;
	}
	
	public String getUserName() {
		
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userName = ((UserDetails)principal).getUsername();
		return userName;
		
	}
}
