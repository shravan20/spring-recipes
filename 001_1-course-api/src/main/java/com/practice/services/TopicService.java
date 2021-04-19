package com.practice.services;

import java.util.List;

import com.practice.models.Topic;

public interface TopicService {

	List<Topic> getAllTopics();
	void addTopic(Topic topic);
	void updateTopic(String id, Topic topic);
	Topic getTopic(String id);
	void deleteTopic(String id);
}
