package com.practice.daos;

import java.util.List;

import com.practice.models.UserInfo;

public interface UserInfoDAO {
	
	void addUser(UserInfo userinfo);
	List<UserInfo>getAllUserInfo();
	UserInfo findById(int id);
	UserInfo findByIdQuery(int id);
	UserInfo update(UserInfo userInfo, int id);
	void delete(int id);

}
