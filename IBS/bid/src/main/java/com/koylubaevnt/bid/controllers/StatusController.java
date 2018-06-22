package com.koylubaevnt.bid.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koylubaevnt.bid.model.Status;
import com.koylubaevnt.bid.service.StatusService;

@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<Status> getStatus() {
		return statusService.getStatus();
	}
	
}
