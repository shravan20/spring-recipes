package com.practice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.daos.UserInfoDAO;
import com.practice.models.UserInfo;
import com.practice.services.UserInfoService;


@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDao;
	@Override
	public void createUser(UserInfo userinfo) {
		userInfoDao.addUser(userinfo);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.getAllUserInfo();
	}

	@Override
	public UserInfo findById(int id) {
		return userInfoDao.findById(id);
	}

	@Override
	public UserInfo findByIdQuery(int id) {
		return userInfoDao.findByIdQuery(id);
	}

	@Override
	public UserInfo updateUserInfo(UserInfo userInfo, int id) {
		return userInfoDao.update(userInfo, id);
	}

	@Override
	public void deleteById(int id) {
		userInfoDao.delete(id);
	}

}
