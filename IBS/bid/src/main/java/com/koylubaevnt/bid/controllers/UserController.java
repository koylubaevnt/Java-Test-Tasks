package com.koylubaevnt.bid.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koylubaevnt.bid.model.User;
import com.koylubaevnt.bid.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<User> getUsers() {
		return userService.getUsers();
	}
	
}
