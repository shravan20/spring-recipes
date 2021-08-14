package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.Topic;
import com.practice.services.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping(path ="/topic/{id}")
	public Topic findById(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}

	
	@PostMapping(path ="/topic")
	public void create(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping(path ="/topic/{id}")
	public void modify(@PathVariable("id") String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
	
	@DeleteMapping(path ="/topic/{id}")
	public void delete(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
	}

	
}
