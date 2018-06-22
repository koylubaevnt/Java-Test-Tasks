package com.koylubaevnt.bid.model.dao.impl;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.koylubaevnt.bid.model.Status;
import com.koylubaevnt.bid.model.dao.StatusDao;

public class StatusDaoImpl implements StatusDao {

	@Autowired
	private List<Status> statusList;
	
	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

	@Override
	public void add(Status entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Status entity) {
		throw new UnsupportedOperationException();
	}

    @Override
    public void delete(Status entity) {
    	throw new UnsupportedOperationException();
    }
	
	@Override
	public Collection<Status> getStatus() {
		return statusList;
	}

}
