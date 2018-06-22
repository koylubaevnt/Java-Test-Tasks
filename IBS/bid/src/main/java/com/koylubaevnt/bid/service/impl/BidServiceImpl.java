package com.koylubaevnt.bid.service.impl;

import java.util.Collection;

import com.koylubaevnt.bid.model.Bid;
import com.koylubaevnt.bid.model.dao.BidDao;
import com.koylubaevnt.bid.service.BidService;

public class BidServiceImpl implements BidService {

	private BidDao bidDao;
	
	public BidDao getBidDao() {
		return bidDao;
	}
	
	public void setBidDao(BidDao bidDao) {
		this.bidDao = bidDao;
	}
	
	@Override
	public void add(Bid entity) {
		bidDao.add(entity);
	}

	@Override
	public void update(Bid entity) {
		bidDao.update(entity);
	}
	
	@Override
	public Collection<Bid> getBids(String search) {
		return bidDao.getBids(search);
	}

	@Override
	public void delete(Bid entity) {
		bidDao.delete(entity);
	}

}
