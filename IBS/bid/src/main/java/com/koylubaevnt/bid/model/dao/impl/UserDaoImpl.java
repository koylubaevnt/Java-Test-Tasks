package com.koylubaevnt.bid.model.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koylubaevnt.bid.model.User;
import com.koylubaevnt.bid.model.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Autowired
	private List<User> users;
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public void add(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(User entity) {
		throw new UnsupportedOperationException();
	}

    @Override
    public void delete(User entity) {
    	throw new UnsupportedOperationException();
    }
	
	@Override
	public Collection<User> getUsers() {
		return users;
	}

}
