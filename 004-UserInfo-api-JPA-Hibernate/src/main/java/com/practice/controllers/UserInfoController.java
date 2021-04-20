package com.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.practice.models.UserInfo;
import com.practice.services.UserInfoService;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> getUserById(@PathVariable("id") int id) {
		UserInfo userInfo = userInfoService.findById(id);
		if (userInfo==null)
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<UserInfo>(HttpStatus.OK);
	}

	
	@PostMapping(path="/create", headers="Accept=application/json")
	public ResponseEntity<Void> createUser(@RequestBody UserInfo userInfo, UriComponentsBuilder builder) {
		userInfoService.createUser(userInfo);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(builder.path("/userinfo/{id}").buildAndExpand(userInfo.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	@GetMapping(path="/getall")
	public List<UserInfo> getAllUserInfo() {
		return userInfoService.findAll();
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<String> updateUserInfo(@RequestBody UserInfo currentUserInfo, @PathVariable("id") int id){
		UserInfo userinfo = userInfoService.findById(id);
		if(userinfo==null)
			return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		
		userInfoService.updateUserInfo(currentUserInfo, id);
		return new ResponseEntity<String>("User Updated", HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<String> deleteUserInfo(@PathVariable("id") int id){
		UserInfo userinfo=userInfoService.findById(id);
		
		if(userinfo==null)
			return new ResponseEntity<String>("UserNotFound", HttpStatus.NOT_FOUND);
		
		userInfoService.deleteById(id);
		return new ResponseEntity<String>("UserDeleted", HttpStatus.NO_CONTENT);
	}
	
}
