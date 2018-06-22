package com.koylubaevnt.bid.model.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koylubaevnt.bid.model.Bid;
import com.koylubaevnt.bid.model.dao.BidDao;
public class BidDaoImpl implements BidDao {

	@Autowired
	private List<Bid> bids;
		
	@Autowired
	private static Long index = 7L;

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	
	public static void setIndex(Long index) {
		BidDaoImpl.index = index;
	}
	
	@Override
	public void add(Bid entity) {
		entity.setId(index++);
		bids.add(entity);
	}

	@Override
	public void update(Bid entity) {
		int index = bids.indexOf(entity);
		if (index != -1) {
			bids.add(index, entity);
		}
	}

    @Override
    public void delete(Bid entity) {
        Iterator<Bid> it = bids.iterator();
    	while (it.hasNext()) {
			Bid bid = it.next();
			if(bid.getId().equals(entity.getId())) {
				it.remove();
				break;
			}
		}
    }

    @Override
    public Collection<Bid> getBids(String search) {
        if (null == search || search.trim().isEmpty()) {
            return bids;
        }
        
        List<Bid> list = new ArrayList<>();
    	for(Bid item : bids) {
        	if(item.getNumber().contains(search)) {
        		list.add(item);
        	}
        }
        return list;
    }


}
