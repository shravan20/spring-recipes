package com.practice.daos.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.daos.UserInfoDAO;
import com.practice.models.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addUser(UserInfo userInfo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(userInfo);
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		Session session = sessionFactory.getCurrentSession();
		List<UserInfo> list = session.createQuery("from userInfo").list();
		return list;
	}

	@Override
	public UserInfo findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserInfo userInfo = (UserInfo)session.get(UserInfo.class, id);
		return userInfo;
	}

	@Override
	public UserInfo findByIdQuery(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query<UserInfo> query = session.createQuery("from UserInfo where id = :id");
		query.setParameter("id", id);
		List<UserInfo> users = query.getResultList();
		
		Query<Integer> cntQuery = session.createQuery("select count(id) from UserInfo");
		List<Integer> cntList = cntQuery.getResultList();
		System.out.println("Count => "+ cntList.get(0));
		return users.get(0);
	}

	@Override
	public UserInfo update(UserInfo userInfo, int id) {
		Session session = sessionFactory.getCurrentSession();
		UserInfo existingUserInfo = (UserInfo) session.load(UserInfo.class, id);
		existingUserInfo.setFullName(userInfo.getFullName());
		existingUserInfo.setCountry(userInfo.getCountry());
		return existingUserInfo;

	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserInfo userInfo=findById(id);
		session.delete(userInfo);
	}

}
