package com.practice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.models.Topic;
import com.practice.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("T1","Spring Framework","Intro to Spring"),
			new Topic("T2","Express Framework","Intro to Express"),
			new Topic("T3","FlaskFramework","Intro to Flask")
			));
	
	@Override
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		return topics;
	}

	@Override
	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
	}

	@Override
	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		for(int indx = 0; indx<topics.size();indx++) {
			Topic t = (Topic) topics.get(indx);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.set(indx, topic);
				return;
			}
		}
	}

	@Override
	public Topic getTopic(String id) {
		// TODO Auto-generated method stub
		Topic topic=null;
		for(int indx = 0; indx<topics.size();indx++) {
			Topic t = (Topic) topics.get(indx);
			if(t.getId().equalsIgnoreCase(id)) {
				topic=t;
				break;
			}
		}
		return topic;
	}

	@Override
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		for(int indx = 0; indx<topics.size();indx++) {
			Topic t = (Topic) topics.get(indx);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.remove(indx);
				return;
			}
		}
	}

	
}
