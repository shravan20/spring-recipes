package com.practice.daos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.daos.TopicDAO;
import com.practice.daos.util.TopicRowMapper;
import com.practice.models.Topic;



@Repository
public class TopicDAOImpl implements TopicDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Topic> getAllTopics() {
		final String SQL = "select * from topic";
		return jdbcTemplate.query(SQL,  new TopicRowMapper());		
	}

	@Override
	public void addTopic(Topic topic) {
		final String SQL="insert into topic(id,topicname,topicdesc) values(?,?,?)";
		jdbcTemplate.update(SQL, topic.getId(), topic.getTopicName(), topic.getTopicDesc());
		System.out.println("Topic Added to DB");
	}

	@Override
	public void updateTopic(Topic topic) {
		final String SQL="update topic set topicname=? , topicdesc= ? where id = ?";
		jdbcTemplate.update(SQL, topic.getTopicName(), topic.getTopicDesc(), topic.getId());
		System.out.println("Topic Updated to DB");		
	}

	@Override
	public Topic getTopic(int id) {
		final String SQL="select * from where id = ?";
		Topic topic = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new TopicRowMapper());
		System.out.println("Topic fetched from DB");
		return topic;
	}

	@Override
	public void deleteTopic(int id) {
		final String SQL="delete from topic where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Topic deleted from DB");
	}

}
