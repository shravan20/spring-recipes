package com.practice.services;

import java.util.List;

import com.practice.models.UserInfo;

public interface UserInfoService {

	void createUser(UserInfo userInfo);
	List<UserInfo> findAll();
	UserInfo findById(int id);
	UserInfo findByIdQuery(int id);
	UserInfo updateUserInfo(UserInfo userInfo, int id);
	void deleteById(int id);
	
}
