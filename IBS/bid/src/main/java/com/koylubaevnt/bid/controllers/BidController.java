package com.koylubaevnt.bid.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koylubaevnt.bid.model.Bid;
import com.koylubaevnt.bid.service.BidService;

@Controller
@RequestMapping("/application")
public class BidController {

	@Autowired
	private BidService bidService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<Bid> getBids(String search) {
		return bidService.getBids(search);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Bid setBids(@RequestBody Bid bid)
	{	
		bidService.add(bid);
		return bid;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delBid(@RequestBody Bid bid) {
		bidService.delete(bid);
		return "del";
	}
}
