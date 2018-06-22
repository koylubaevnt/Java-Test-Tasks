package com.koylubaevnt.bid.service.impl;

import java.util.Collection;

import com.koylubaevnt.bid.model.User;
import com.koylubaevnt.bid.model.dao.UserDao;
import com.koylubaevnt.bid.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void add(User entity) {
		userDao.add(entity);
	}
	
	@Override
	public void update(User entity) {
		userDao.update(entity);
	}
	
	@Override
	public void delete(User entity) {
		userDao.delete(entity);
	}
	
	@Override
	public Collection<User> getUsers() {
		return userDao.getUsers();
	}

}
