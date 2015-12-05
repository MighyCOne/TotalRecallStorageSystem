package com.eintern.orm.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="P1StorageUnit")
@Entity
public class StorageUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int unitId;
	
	//In days
	private int timeRemaining;
	
	private boolean isAvailable;
	
	//@OneToMany(mappedBy="storageunit", cascade=CascadeType.ALL)
	@OneToMany(mappedBy="storageunit")
	Set<Transaction> transaction;
	
	public StorageUnit() {
		unitId = 0;
		timeRemaining = 0;
		isAvailable = false;
		transaction = null;
	}
	
	public StorageUnit(int unitId, int timeRemaining, boolean isAvailable, Set<Transaction> transaction,Set<Customer> customers) {
		super();
		this.unitId = unitId;
		this.timeRemaining = timeRemaining;
		this.isAvailable = isAvailable;
		this.transaction = transaction;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public int getTimeRemaining() {
		return timeRemaining;
	}
	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Set<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "StorageUnit [unitId=" + unitId +"]";
	}
	
}
