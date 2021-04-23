package com.practice.models;

import lombok.Data;

@Data // Generates Getters/Setters|ToString|Required ArgsConstructor
public class Message {

	private int id;
	private String message;

}
