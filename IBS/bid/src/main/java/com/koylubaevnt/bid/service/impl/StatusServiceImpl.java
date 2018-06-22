package com.koylubaevnt.bid.service.impl;

import java.util.Collection;

import com.koylubaevnt.bid.model.Status;
import com.koylubaevnt.bid.model.dao.StatusDao;
import com.koylubaevnt.bid.service.StatusService;

public class StatusServiceImpl implements StatusService {

	private StatusDao statusDao;
	
	public StatusDao getStatusDao() {
		return statusDao;
	}
	
	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}
	
	@Override
	public void add(Status entity) {
		statusDao.add(entity);
	}
	
	@Override
	public void update(Status entity) {
		statusDao.update(entity);
	}
	
	@Override
	public void delete(Status entity) {
		statusDao.delete(entity);
	}
	
	@Override
	public Collection<Status> getStatus() {
		return statusDao.getStatus();
	}

}
