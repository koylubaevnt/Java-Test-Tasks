package com.koylubaevnt.bid.model.dao;

import java.util.Collection;
import com.koylubaevnt.bid.model.Status;

public interface StatusDao {

	void add(Status entity);

	void update(Status entity);
	
	void delete(Status entity);
	
	Collection<Status> getStatus();
	
}