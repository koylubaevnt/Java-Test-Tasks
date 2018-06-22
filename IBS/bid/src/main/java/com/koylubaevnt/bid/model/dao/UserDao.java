package com.koylubaevnt.bid.model.dao;

import java.util.Collection;
import com.koylubaevnt.bid.model.User;

public interface UserDao {

	void add(User entity);

	void update(User entity);
	
	void delete(User entity);
	
	public Collection<User> getUsers();
	
}