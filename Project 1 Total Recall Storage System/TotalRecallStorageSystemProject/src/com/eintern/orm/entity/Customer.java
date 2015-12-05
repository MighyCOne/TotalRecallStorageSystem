package com.eintern.orm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="P1Customer")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	
	private String custName;
	
	@Column(unique=true)
	private String custEmail;
	
	private double custBalance;
	
	private String custFeedback;
	
	private boolean buying_status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username", unique=true)
	UserAuthorization userAuth;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	Set <Transaction> transaction;
	
	public Customer() {
		custId = 0;
		custName = null;
		custEmail = null;
		custBalance = 0;
		custFeedback = null;
		transaction = null;
		userAuth = null;
		buying_status=true;
	}
	
	public Customer(int custId, String custName, String custEmail, double custBalance,
			String custFeedback, Set<Transaction> transaction, UserAuthorization userAuth, Set <UserAuthorization> users, boolean buying_status) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custBalance = custBalance;
		this.custFeedback = custFeedback;
		this.transaction = transaction;
		this.userAuth = userAuth;
		this.buying_status=buying_status;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	/*public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}*/
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	public String getCustFeedback() {
		return custFeedback;
	}
	public void setCustFeedback(String custFeedback) {
		this.custFeedback = custFeedback;
	}
	public Set<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}
	public UserAuthorization getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(UserAuthorization userAuth) {
		this.userAuth = userAuth;
	}

	public boolean isBuying_status() {
		return buying_status;
	}

	public void setBuying_status(boolean buying_status) {
		this.buying_status = buying_status;
	}	

}
