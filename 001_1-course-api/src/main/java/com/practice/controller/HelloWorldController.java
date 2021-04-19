package com.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/status")
@RestController
public class HelloWorldController {
	
	@RequestMapping("/greet")
	public String greetings() {
		return "Hello World";
	}
	
}
