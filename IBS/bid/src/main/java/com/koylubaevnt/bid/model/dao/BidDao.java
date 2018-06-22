package com.koylubaevnt.bid.model.dao;

import java.util.Collection;

import com.koylubaevnt.bid.model.Bid;

public interface BidDao {

	void add(Bid entity);

	void update(Bid entity);
	
	void delete(Bid entity);
	
	Collection<Bid> getBids(String search);
	
}