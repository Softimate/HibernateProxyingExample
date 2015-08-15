package com.orbitz.cop.proxying.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set addresseses = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public User(Integer id, String name, Set addresseses) {
		this.id = id;
		this.name = name;
		this.addresseses = addresseses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getAddresseses() {
		return this.addresseses;
	}

	public void setAddresseses(Set addresseses) {
		this.addresseses = addresseses;
	}

}