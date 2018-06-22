package com.koylubaevnt.bid.service;

import java.util.Collection;

import com.koylubaevnt.bid.model.Bid;

public interface BidService {

	void add(Bid entity);

	void update (Bid entity);

	void delete(Bid entity);

	Collection<Bid> getBids(String search);

}
