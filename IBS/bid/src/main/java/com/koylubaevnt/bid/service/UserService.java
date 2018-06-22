package com.koylubaevnt.bid.service;

import java.util.Collection;

import com.koylubaevnt.bid.model.User;

public interface UserService {
	
	void add(User entity);

	void update (User entity);

	void delete(User entity);
	
	Collection<User> getUsers();

}
