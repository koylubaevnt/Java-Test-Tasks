package com.koylubaevnt.bid.model;

import java.io.Serializable;

public class Bid implements Serializable {

	private static final long serialVersionUID = 8031565557510331543L;

	private Long id;
	
	private String number;
	
	private User from;
	
	private User to;
	
	private Status status;
	
	public Bid() {
	}
	
	public Bid(String number, User from, User to, Status status) {
		this(null, number, from, to, status);
	}
	
	public Bid(Long id, String number, User from, User to, Status status) {
		this.id = id;
		this.number = number;
		this.from = from;
		this.to = to;
		this.status = status;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setFrom(User from) {
		this.from = from;
	}
	
	public User getFrom() {
		return from;
	}
	
	public void setTo(User to) {
		this.to = to;
	}
	
	public User getTo() {
		return to;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Bid [id=" + id + ", number=" + number + ", from=" + from + ", to=" + to + ", status=" + status + "]";
	}
	
	
}
