package com.practice.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.practice.models.Topic;

public class TestRestTemplate {


	public static void main(String[] args) {
		
		final String getByIdUri= "http://localhost:9090/topics/{id}";
		final String postUri= "http://localhost:9090/topics/create";
		final String getAllUri= "http://localhost:9090/topics";
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Integer> params = new HashMap<>();
		
		params.put("id",103);
		String strTopic = restTemplate.getForObject(getByIdUri, String.class, params);
		System.out.println("String=>"+strTopic);
		System.out.println("+++++++++++++++++++++++++++++++++++");
		
		Topic topic = restTemplate.getForObject(getByIdUri, Topic.class, params);
		System.out.println("Topic=>"+topic);
		System.out.println("+++++++++++++++++++++++++++++++++++");
	
		Topic newTopic = new Topic(105, "Spring Boot with Spring Cloud", "A comprehensive 3 day course");
		String postResult = restTemplate.postForObject(postUri, newTopic, String.class);
		System.out.println("Result => "+ postResult);
		System.out.println("+++++++++++++++++++++++++++++++++++");
		
		
		ResponseEntity<List<Topic>> response = restTemplate.exchange(
				getAllUri, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Topic>>() { }
				);
		List<Topic> topics = response.getBody();
		for(Topic t : topics )
			System.out.println("Topic t=>"+t);
		
		System.out.println("++++++++++++++++++++++++++++++++++++");
		
		ResponseEntity<Topic> topicResponse = restTemplate.getForEntity(getByIdUri, Topic.class, params);
		Topic topic1 = topicResponse.getBody();
		System.out.println("topic1==>"+topic1);

		HttpHeaders headers1 = response.getHeaders();
		System.out.println("headers2==>"+headers1);

		
		HttpHeaders headers2 = topicResponse.getHeaders();
		System.out.println("headers2==>"+headers2);

	
	}

}
