package com.eintern.orm.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "P1Transaction")
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;

	// Could use Date type
	private Date dateEntered;

	private double dollarAmount;

	//In my teammates code, his only cascades are in this Transaction entity.
	//@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "custId")
	Customer customer;

//	@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "unitId")
	StorageUnit storageunit;

	public Transaction() {
		transactionId = 0;
		dateEntered = null;
		dollarAmount = 0;
		customer = null;
		storageunit = null;
	}

	public Transaction(int transactionId, Date dateEntered, double dollarAmount, Customer customer,
			StorageUnit storageunit) {
		super();
		this.transactionId = transactionId;
		this.dateEntered = dateEntered;
		this.dollarAmount = dollarAmount;
		this.customer = customer;
		this.storageunit = storageunit;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	public double getDollarAmount() {
		return dollarAmount;
	}

	public void setDollarAmount(double dollarAmount) {
		this.dollarAmount = dollarAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StorageUnit getStorageunit() {
		return storageunit;
	}

	public void setStorageunit(StorageUnit storageunit) {
		this.storageunit = storageunit;
	}

}
