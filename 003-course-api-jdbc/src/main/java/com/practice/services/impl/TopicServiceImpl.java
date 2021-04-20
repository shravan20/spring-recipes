package com.practice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.daos.TopicDAO;
import com.practice.models.Topic;
import com.practice.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDao;

	@Override
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		return topicDao.getAllTopics();
	}

	@Override
	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicDao.addTopic(topic);
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicDao.updateTopic(topic);
	}

	@Override
	public Topic getTopic(int id) {
		// TODO Auto-generated method stub
		return topicDao.getTopic(id);
	}

	@Override
	public void deleteTopic(int id) {
		// TODO Auto-generated method stub
		topicDao.deleteTopic(id);
	}

}
