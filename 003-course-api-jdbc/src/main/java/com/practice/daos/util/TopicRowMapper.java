package com.practice.daos.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.practice.models.Topic;

public class TopicRowMapper implements RowMapper<Topic> {

	@Override
	public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
		Topic topic = new Topic();
		topic.setId(rs.getInt("id"));
		topic.setTopicName(rs.getString("topicname"));
		topic.setTopicDesc(rs.getString("topicdesc"));
		return topic;
	}

}
