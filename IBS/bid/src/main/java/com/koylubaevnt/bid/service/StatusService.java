package com.koylubaevnt.bid.service;

import java.util.Collection;
import com.koylubaevnt.bid.model.Status;

public interface StatusService {

	void add(Status entity);

	void update (Status entity);

	void delete(Status entity);
	
	Collection<Status> getStatus();

}
