package com.eintern.orm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="P1User")
@Entity
public class UserAuthorization {
	
	@Id
	private String username;
	
	private String password;
	
	private String type;
	
	@OneToOne(mappedBy="userAuth",cascade=CascadeType.ALL)
	Customer customer;
	
	@OneToOne(mappedBy="userAutho",cascade=CascadeType.ALL)
	Manager manager;
	
	public UserAuthorization() {
		username=null;
		password=null;
		type = null;
		customer = null;
		manager=null;
	}
	
	public UserAuthorization(String username, String password, String type, Customer customer, Manager manager) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.customer = customer;
		this.manager= manager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
