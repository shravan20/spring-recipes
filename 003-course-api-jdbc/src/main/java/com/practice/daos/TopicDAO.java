package com.practice.daos;

import java.util.List;

import com.practice.models.Topic;

public interface TopicDAO {

	List<Topic> getAllTopics();

	void addTopic(Topic topic);

	void updateTopic(Topic topic);

	Topic getTopic(int id);

	void deleteTopic(int id);
	
}
