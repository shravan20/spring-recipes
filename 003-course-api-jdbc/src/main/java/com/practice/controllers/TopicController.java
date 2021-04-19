package com.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.Topic;
import com.practice.services.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping(path="/")
	public List<Topic> findAll(){
		return topicService.getAllTopics();
	}

	@GetMapping(path="/{id}")
	public Topic findById(@PathVariable("id") int id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping(path="/")
	public void create(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@DeleteMapping("/")
	public void delele(@PathVariable("id") int id) {
		topicService.deleteTopic(id);
	}
	
}
