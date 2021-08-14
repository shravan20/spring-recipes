package com.practice.models;

public class Topic {

	private String id;
	private String topicName;
	private String topicDescription;
	
	
	
	public Topic(String id, String topicName, String topicDescription) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
	
}
