package com.koylubaevnt.bid.model;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = -7923699893334380078L;

	private Long id;
	
	private String name;
	
	public Status() {
	}
	
	public Status(String name) {
		this(null, name);
	}
	
	public Status(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + "]";
	}
	
	
}
