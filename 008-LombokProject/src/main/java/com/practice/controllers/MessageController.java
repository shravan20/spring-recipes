package com.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.Message;
import com.practice.services.MessageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/welcome")
	public Message greetMessage(@RequestParam String user) {
		log.info("In controller");
		Message message = messageService.createMessage(user);
		log.info("Out controller");
		return message;
	}
	
	

}
