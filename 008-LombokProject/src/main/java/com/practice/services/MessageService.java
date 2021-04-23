package com.practice.services;

import org.springframework.stereotype.Service;

import com.practice.models.Message;

import lombok.NonNull;

@Service
public class MessageService {
	
	public Message createMessage(@NonNull String user) {
		Message message = new Message();
		message.setId(1);
		message.setMessage("Hello "+user.toUpperCase()+", Welcome to Lombok");
		return message;
	}

}
