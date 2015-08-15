package com.orbitz.cop.proxying.hibernate;

/**
 * Addresses entity. @author MyEclipse Persistence Tools
 */

public class Addresses implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String address;

	// Constructors

	/** default constructor */
	public Addresses() {
	}

	/** minimal constructor */
	public Addresses(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Addresses(Integer id, User user, String address) {
		this.id = id;
		this.user = user;
		this.address = address;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}