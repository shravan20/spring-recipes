package com.practice.models;

public class Topic {

	private int id;
	private String topicName;
	private String topicDesc;
	public Topic(int id, String topicName, String topicDesc) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.topicDesc = topicDesc;
	}
	public Topic() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}

}
