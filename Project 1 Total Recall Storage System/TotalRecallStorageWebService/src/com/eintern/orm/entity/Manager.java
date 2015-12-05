package com.eintern.orm.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="P1Manager")
@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int	manaId;
	
	private String manaName;
	
	@Column(unique=true)
	private String manaEmail;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username", unique=true)
	UserAuthorization userAutho;

	public int getManaId() {
		return manaId;
	}

	public void setManaId(int manaId) {
		this.manaId = manaId;
	}

	public String getManaName() {
		return manaName;
	}

	public void setManaName(String manaName) {
		this.manaName = manaName;
	}

	public String getManaEmail() {
		return manaEmail;
	}

	public void setManaEmail(String manaEmail) {
		this.manaEmail = manaEmail;
	}

	public UserAuthorization getUserAutho() {
		return userAutho;
	}

	public void setUserAutho(UserAuthorization userAuth) {
		this.userAutho = userAuth;
	}
	
	
	
}
